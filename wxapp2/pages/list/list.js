const util = require('../../utils/util.js')

Page({
    apiurl: "https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",
    garmincookie: null,
    limit: 20,
    start: 0,
    data: {
        /**
         * 用于控制当 scroll-view 滚动到底部时，显示 “数据加载中...” 的提示
         */
        hidden: true,
        /**
         * 用于显示文章的数组
         */
        list: [],
        /**
         * 数据是否正在加载中，避免用户瞬间多次下滑到底部，发生多次数据加载事件
         */
        loadingData: false
    },
    onLoad: function (options) {

      var param = util.getSetting();
      if(param.username && param.email && param.password){
        this.start = 0;
        this.setData({
            loadingData: true
        });
        wx.showLoading({
            title: '数据加载中...',
        });
        var that = this;
        that.loadData(false, () => {
            that.setData({
                hidden: true,
                loadingData: false
            });
            wx.hideLoading();
        });
      }else{
        console.log(param)
        wx.switchTab({
          url: '/pages/setting/setting',
        })
      }

    },

    getQueryData: function () {
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

    loadData: function (tail, callback) {
        var that = this;
        var query = this.getQueryData();
        query.action = "list"
        wx.request({
            data: query,
            url: that.apiurl,
            method: 'POST',
            success: function (r) {
                // console.log(r)
                that.garmincookie = r.header["Garmin-Cookie"];
                var lastList = that.data.list,
                    fullList = tail ? lastList.concat(r.data) : r.data;
                console.log(fullList)
                that.setData({
                    list: fullList
                });
                if (callback) {
                    callback();
                }
            },
            error: function (r) {
                console.info('error', r);
            },
            complete: function () {
            }
        })
    },
    /**
     * 上滑加载更多
     */
    scrollToLower: function (e) {
        console.info('scrollToLower', e);
        var hidden = this.data.hidden,
            loadingData = this.data.loadingData,
            that = this;
        if (hidden) {
            this.setData({
                hidden: false
            });
            // console.info(this.data.hidden);
        }
        if (loadingData) {
            return;
        }
        this.setData({
            loadingData: true
        });
        // 加载数据,模拟耗时操作

        wx.showLoading({
            title: '数据加载中...',
        });

        that.start++;
        that.loadData(true, () => {
            that.setData({
                hidden: true,
                loadingData: false
            });
            wx.hideLoading();
        });
    },
    scrollToUpper: function (e) {
        this.onLoad();
    },
    longTap: function (e) {
        var current = e.currentTarget.dataset
        if(current.moveid){
          return
        }
        var that = this;
        wx.showModal({
            title: '提示',
            content: '将当期活动数据同步到move?',
            showCancel: true,
            success(res) {
                if (res.confirm) {
                    that.onSync(current.activityid)
                } else if (res.cancel) {
                    console.log('用户点击取消')
                }
            }
        })
    },

    onSync: function (activityId) {

        wx.showLoading({
            title: '正在同步',
        });
        var that = this;
        that.sync(activityId, () => {
            wx.hideLoading();
            that.onLoad()
        });

    },

    sync: function (activityId, callback) {
        var that = this;
        var query = this.getQueryData();
        query.action = "sync"
        query.activityId = activityId;
        wx.request({
            data: query,
            url: that.apiurl,
            method: 'POST',
            success: function (r) {
                if (callback) {
                    callback();
                }
            },
            error: function (r) {
                console.info('error', r);
            },
            complete: function () {
            }
        })
    },

})