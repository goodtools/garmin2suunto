const util = require('../../utils/util.js')

Page({
  apiurl: "https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",
  garmincookie: null,
  limit: 20,
  start: 0,
  data: {
    list: [],
    loadingData: false
  },

  onShareAppMessage() {
    return {
      title: '活动列表',
      path: 'pages/list/list'
    }
  },

  onShow: function(options) {
    console.log(param)
    var param = util.getSetting();
    if (param.username && param.email && param.password ) {
      if (this.data.list.length == 0){
        this.doLoadData(false)
      }
    } else {
      // console.log(param)
      wx.switchTab({
        url: '/pages/setting/setting',
      })
    }
  },

  getQueryData: function() {
    var setting = util.getSetting();
    return {
      userName: setting.username,
      password: setting.password,
      usermail: setting.email,
      userkey: setting.key,
      limit: this.limit,
      start: this.start * this.limit,
      cookiejar: this.garmincookie
    }
  },

  doLoadData: function(more, callback) {
    if (this.data.loadingData) {
      return
    }
    wx.showLoading({
      title: '数据加载中...',
      mask: true
    });
    wx.showNavigationBarLoading();
    this.setData({
      loadingData: true
    });
    if (more) {
      this.start++;
    } else {
      this.start = 0;
    }
    var that = this;
    var query = this.getQueryData();
    var showToast = false
    query.action = "list"
    wx.request({
      data: query,
      url: that.apiurl,
      method: 'POST',
      success: function(r) {

        console.log(r)
        if(r.statusCode != 200){
          showToast = true
          wx.showToast({
            title: '加载失败 ' + r.errMsg,
            icon: 'none',
            duration: 2000
          })
          return;
        }
        
        that.garmincookie = r.header["Garmin-Cookie"];
        var lastList = that.data.list,
          fullList = more ? lastList.concat(r.data) : r.data;
        // console.log(fullList)
        that.setData({
          loadingData: false,
          list: fullList
        });
        if (callback) {
          callback();
        }
      },
      error: function(r) {
        console.info('error', r);
      },
      complete: function() {
        showToast || wx.hideLoading();
        wx.hideNavigationBarLoading();
        that.setData({
          loadingData: false
        });
      }
    })
  },

  onPullDownRefresh: function() {
    // console.log("onPullDownRefresh")
    wx.stopPullDownRefresh();
    this.doLoadData(false);
  },

  onReachBottom: function() {
    // console.log("onReachBottom")
    this.doLoadData(true);
  },

  onLongTap: function(e) {
    var current = e.currentTarget.dataset
    // if (current.moveid) {
    //     return
    // }
    var that = this;
    var itemList = ['复制garmin链接']
    if (current.moveid) {
      itemList.push('复制move链接')
    } else {
      itemList.push('立即同步')
    }
    wx.showActionSheet({
      itemList: itemList,
      success(res) {
        // console.log(res)
        if (res.tapIndex == 0) {
          wx.setClipboardData({
            data: "https://connect.garmin.cn/modern/activity/" + current.activityid
          });
        } else if (current.moveid) {
          wx.setClipboardData({
            data: "http://www.movescount.com/moves/move" + current.moveid
          });
        } else {
          that.doSync(current.activityid, null, () => {
            that.doLoadData(false)
          });
        }
      },
      fail(res) {
        // console.log(res.errMsg)
      }
    })
  },

  doSync: function(activityId, success, callback) {
    wx.showLoading({
      title: '正在同步',
      mask: true
    });
    var that = this;
    var query = this.getQueryData();
    query.action = "sync"
    query.activityId = activityId;
    wx.request({
      data: query,
      url: that.apiurl,
      method: 'POST',
      success: function(r) {
        if (success) {
          success();
        }
      },
      error: function(r) {
        // console.info('error', r);
        wx.showToast({
          title: '同步失败',
          icon: 'none',
          duration: 2000
        })
      },
      complete: function() {
        wx.hideLoading();
        if (callback) {
          callback();
        }
      }
    })
  },

  // onShow: function(){
  //   console.log("on show")
  // }

})