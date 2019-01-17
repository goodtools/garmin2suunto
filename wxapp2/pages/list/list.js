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

    onLoad: function (options) {
        var param = util.getSetting();
        if (param.username && param.email && param.password) {
            this.doLoadData(false)
        } else {
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

    doLoadData: function (more, callback) {
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
        query.action = "list"
        wx.request({
            data: query,
            url: that.apiurl,
            method: 'POST',
            success: function (r) {
                // console.log(r)
                that.garmincookie = r.header["Garmin-Cookie"];
                var lastList = that.data.list,
                    fullList = more ? lastList.concat(r.data) : r.data;
                console.log(fullList)
                that.setData({
                    loadingData: false,
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
                wx.hideLoading();
                wx.hideNavigationBarLoading();
                that.setData({
                    loadingData: false
                });
            }
        })
    },

    onPullDownRefresh: function () {
        console.log("onPullDownRefresh")
        this.doLoadData(false);
    },

    onReachBottom: function () {
        console.log("onReachBottom")
        this.doLoadData(true);
    },

    onLongTap: function (e) {
        var current = e.currentTarget.dataset
        if (current.moveid) {
            return
        }
        var that = this;
        wx.showModal({
            title: '提示',
            content: '将当期活动数据同步到move?',
            showCancel: true,
            success(res) {
                if (res.confirm) {
                    that.doSync(current.activityid, () => {
                        that.doLoadData(true)
                    });
                } else if (res.cancel) {
                    console.log('用户点击取消')
                }
            }
        })
    },

    doSync: function (activityId, callback) {
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
            success: function (r) {
                if (callback) {
                    callback();
                }
            },
            error: function (r) {
                console.info('error', r);
            },
            complete: function () {
                wx.hideLoading();
            }
        })
    },

})