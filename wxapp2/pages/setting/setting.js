const util = require('../../utils/util.js')

Page({
  onLoad: function () {
    try {
      var value = util.getSetting()
      // console.log(value)
      if (!value) {
        value = {}  
      }
      if (!value.key || "" == value.key) {
        value.key = util.uuid()
      }
      // console.log(value)
      this.setData(value)
    } catch (e) {
      // Do something when catch error
    }
  },

  data: {
  },

  formSubmit(e) {
    // console.log('form发生了submit事件，携带数据为：', e.detail.value)
    wx.setStorage({
      key: 'settings',
      data: e.detail.value,
      success: function(){
        wx.showToast({
          title: '成功',
          icon: 'success',
          duration: 2000
        })
      },
      fail: function(){
        wx.showToast({
          title: '失败',
          icon: 'none',
          duration: 2000
        })
      }
    });
  }

})
