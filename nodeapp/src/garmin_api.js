var MODERN_URL = "https://connect.garmin.cn/modern";
const GARMIN_CN = "https://connect.garmin.cn";
const SSO_GARMIN_CN = "https://sso.garmin.cn";

var loginpage = 'https://sso.garmin.cn/sso/signin'

var loginParmas = {
    "service": MODERN_URL,
    "clientId": "GarminConnect",
    "locale": "zh",
    "id": "gauth-widget",
    "gauthHost": SSO_GARMIN_CN + "/sso",
    "consumeServiceTicket": "false"
}

const axios = require('axios').create({})
const _axios = require('axios')
const querystring = require('querystring');

var cookiejar = {
    cookies : {},
    update : function (arr) {
        if (!arr){
            return
        }
        for (let i = 0; i < arr.length; i++) {
            var cookie = arr[i]
            // if (cookie.indexOf('garmin.cn') <= 0) {
            //     continue;
            // }
            var kv = cookie.split(';')[0].split('=');
            if (kv.length == 2){
                this.cookies[kv[0]] = kv[1]
            }
        }
    },
    getCookieStr : function () {
        if (global.garmincookie){
            return global.garmincookie
        }
        var str = ''
        for (var key in this.cookies){
            // console.log(key)
            str += (key + "=" + this.cookies[key] + "; ")
        }
        return str.substring(0,str.length - 2);
    }
}

axios.defaults.withCredentials = true
axios.defaults.maxRedirects = 0
axios.defaults.validateStatus = function (status) {
    return (status >= 200 && status < 300) || status == 302; // default
}
axios.interceptors.response.use(function (response) {
    console.log(">>>>>" + response.config.method + ">" + response.config.url)
    console.log(response.headers["set-cookie"])
    cookiejar.update(response.headers["set-cookie"])
    return response;
}, function (error) {
    console.log(">>>>>[error]" + error.response.config.method + ">" + error.response.config.url)
    // console.log(error.response.headers["set-cookie"])
    cookiejar.update(error.response.headers["set-cookie"])
    if (403 === error.response.status) {
        console.log("start auto login " + error.config.url)
        delete global.garmincookie
        return new Promise(function(resolve, reject) {
            garminlogin().then(function (response) {
                axios.get(error.config.url)
                    .then(function (response) {
                        // console.log(response)
                        resolve(response)
                    })
            })
        });
    } else {
        return Promise.reject(error);
    }
});

function garminlogin() {
    function sso(ssoUrl, resolve, reject) {
        return axios.get(ssoUrl).then(
            function(res) {
                // console.log(ssoUrl);
                if (res.status === 302) {
                    var location = res.headers.location;
                    sso(location, resolve, reject);
                } else {
                    resolve('success');
                }
            },
            function(error) {
                reject(error);
            }
        );
    }
    function promiseLogin(url) {
        return new Promise(function(resolve, reject) {
            axios.get(url).then(
                function(res) {
                    if (302 === res.status) {
                        var location = res.headers.location;
                        sso(location, resolve, reject);
                    } else {
                        resolve('success');
                    }
                },
                function(error) {
                    reject(error);
                }
            );
        });
    }
    return axios.get(loginpage, loginParmas)
        .then(function (response) {
            // console.log(response)
            var headers = {
                "origin":"https://sso.garmin.cn",
                "authority":"sso.garmin.cn",
                "accept-language":"zh,en-US;q=0.9,en;q=0.8,zh-TW;q=0.7,zh-CN;q=0.6,ja;q=0.5"
            }
            return axios.post(loginpage, querystring.stringify({
                "_eventId": "submit",
                "embed": "true",
                "username": global.userName,
                "password": global.password
            }), {headers: headers})
        })
        .then(function (response) {
            // console.log(response)
            // console.log("on success")
            return promiseLogin(MODERN_URL)
            // console.log(loginResult)
        })
}

axios.interceptors.request.use(function (config) {
    // Do something before request is sent
    var cookieStr = cookiejar.getCookieStr()
    // console.log("<<<<<" + config.method + "<"  + config.url)
    // console.log(cookieStr)
    config.headers.Cookie = cookieStr
    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});

module.exports = {

    cookie : function(){
        return cookiejar.getCookieStr()
    },

    search : function(limit,start) {
        var searchUrl = 'https://connect.garmin.cn/modern/proxy/activitylist-service/activities/search/activities?limit='+limit+'&start='+start;
        return axios.get(searchUrl)
            .then(function (response) {
                return response.data.filter(function (item,index,arr) {
                     var type = item.activityType.typeKey;
                     return type.indexOf("cycling") >= 0 || type.indexOf("running") >= 0
                });
            })
    },

    getLatest20 : function() {
        return this.search(20,0)
    },

    getActivity : function (id) {
        var activityUrl = "https://connect.garmin.cn/modern/proxy/activity-service/activity/" + id;
        var activityDetailUrl =  activityUrl + "/details";
        var activitySplitesUrl = activityUrl + "/splits";
        return axios.get(activityUrl)
            .then(function (response) {
                return _axios.all([
                        axios.get(activityDetailUrl),
                        axios.get(activitySplitesUrl)
                    ])
                    .then(_axios.spread(function(detail, splites) {
                        return {
                            activity : response.data,
                            splites : splites.data,
                            detail : detail.data
                        }
                    }))
            })
    }

};