const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

var setting = null;
module.exports = {
  formatTime: formatTime,
  getSetting: function(){
    if(setting){
      return setting
    }
    setting = wx.getStorageSync("settings")
    return setting;
  },
  saveSetting: function(value, success){
    // console.log(value);
    setting = value;
    wx.setStorage({
      key: 'settings',
      data: value,
      success: function () {
        if(null != success){
          success();
        }
      }
    });

  },
  uuid: function(){
    var d = Date.now();
    if (typeof performance !== 'undefined' && typeof performance.now === 'function') {
      d += performance.now(); //use high-precision timer if available
    }
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = (d + Math.random() * 16) % 16 | 0;
      d = Math.floor(d / 16);
      return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    }); 
  }
}
