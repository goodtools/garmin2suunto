// @GET("/modern/proxy/activity-service/activity/{id}")
// Single<Activity> garminActivity(@Path("id") String id);
// @GET("/modern/proxy/activity-service/activity/{id}/details")
// Single<ActivityDetail> garminActivityDetails(@Path("id") String id);
// @GET("/modern/proxy/activity-service/activity/{id}/splits")
// Single<ActivitySplits> garminActivitySplits(@Path("id") String id);
// @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=20&start=0")
// Single<List<ActivityItem>> latest20();
// @GET("/modern/proxy/activitylist-service/activities/search/activities")
// Single<List<ActivityItem>> search(@Query("limit") int limit, @Query("start") int start);
// @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=1000")
// Single<List<ActivityItem>> search(@Query("startDate") String startDate);

var MODERN_URL = "https://connect.garmin.cn/modern";
const GARMIN_CN = "https://connect.garmin.cn";
const SSO_GARMIN_CN = "https://sso.garmin.cn";
const request = require('request');

var loginpage = 'https://sso.garmin.cn/sso/login'
var latest20 = 'https://connect.garmin.cn/modern/proxy/activitylist-service/activities/search/activities?limit=20&start=0';

var loginParmas = {
    "service": MODERN_URL,
    "clientId": "GarminConnect",
    "gauthHost": SSO_GARMIN_CN + "/sso",
    "consumeServiceTicket": "false"
}

const axios = require('axios');
const querystring = require('querystring');
// const axiosCookieJarSupport = require('axios-cookiejar-support').default;
// // const axiosCookieJarSupport = require('axios-cookiejar-support').default;
// const tough = require('tough-cookie');
// axiosCookieJarSupport(axios);
// const cookieJar = new tough.CookieJar();
//
// axios.defaults.jar = cookieJar

userName = 'jiawu.lu@gmail.com'
password = 'Taobao1234'
cookiejar = {
    cookies : {},
    update : function (arr) {
        for (let i = 0; i < arr.length; i++) {
            var cookie = arr[i]
            // if (cookie.indexOf('garmin.cn') <= 0) {
            //     continue;
            // }
            var kv = cookie.split(';')[0].split('=');
            if (kv.length == 2 && kv[1]){
                this.cookies[kv[0]] = kv[1]
            }
        }
    },
    getCookieStr : function () {
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

axios.interceptors.response.use(function (response) {
    console.log(">>>>>" + response.config.method + ">" + response.config.url)
    console.log(response.headers["set-cookie"])

    cookiejar.update(response.headers["set-cookie"])
    return response;
}, function (error) {

    console.log(">>>>>[error]" + error.response.config.method + ">" + error.response.config.url)
    console.log(error.response.headers["set-cookie"])

    cookiejar.update(error.response.headers["set-cookie"])
    if (401 === error.response.status) {
        window.location = '/login';
    } else {
        return Promise.reject(error);
    }
});
axios.interceptors.request.use(function (config) {
    // Do something before request is sent

    var cookieStr = cookiejar.getCookieStr()
    console.log("<<<<<" + config.method + "<"  + config.url)
    console.log(cookieStr)

    config.headers.Cookie = cookieStr
    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});

// Make a request for a user with a given ID
function getLatest20() {
    axios.get(latest20)
        .catch(function (error) {
            // handle error
            console.log(error.response.status);
            if (403 == error.response.status) {

            }
        })
        .then(function () {
            // always executed
            console.log("then ... then")
        })
}

function login() {

    axios.get(loginpage, loginParmas)
        .then(function (response) {
            // console.log(response)
            return axios.post(loginpage, querystring.stringify({
                "_eventId": "submit",
                "embed": "true",
                "username": userName,
                "password": password
            }))
        })
        .then(function (response) {
            // console.log(response)
            return axios.get(MODERN_URL)
        })
        .then(function (response2) {
            // console.log(response2)
        })
        .catch(function (e) {
            // console.log(e)
        })
        .then(function () {
            console.log(">>>")
        })
}

login()



//MODERN_URL 'https://s.m.taobao.com'
// MODERN_URL = 'https://s.m.taobao.com'
// console.log(MODERN_URL)
// return axios.get(MODERN_URL, {
//         headers: {
//             Cookie: garmin_cookie
//         }
//     })
//     .then(function (response2) {
//         console.log(response2)
//     })
//     .catch(function (e) {
//         console.log(e)
//     })
//     .then(function () {
//         console.log(">>>")
//     })

// request.get(latest20)
//     .on('response', function(response) {
//         if (statusCode == 403){
//
//         }
//         console.log(response.statusCode) // 200
//         console.log(response.headers['content-type']) // 'image/png'
//         })
//     .on('error', function(err) {
//         console.log(err)
//     });

// request(,
//     function (error, response, body) {
//
//     if (response.statusCode == 403){
//
//     }
//
//
//     console.log('error:', error); // Print the error if one occurred
//     console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
//     console.log('body:', body); // Print the HTML for the Google homepage.
// });

// curl -v -I --cookie '__cfduid=d4be4bb203a0bbbe381e50265e5f661d81547301302; GARMIN-SSO=1; GarminNoCache=true; GARMIN-SSO-GUID=D93FFDDCBB34AC46E13D0583C6D71DD1B9DBFA18; GARMIN-SSO-CUST-GUID=08fbb9cf-79a8-4d8e-8ab5-55dd9941addb' https://connect.garmin.cn/modern
// curl -v -I --cookie '_ga=GA1.2.995626472.1532650446; notice_preferences=2:; notice_gdpr_prefs=0,1,2:; __cfduid=d590b67a37ee157ade8790e0cfd5c2ed31547300766; _gid=GA1.2.1636522550.1547300768; GARMIN-SSO=1; GarminNoCache=true; GARMIN-SSO-GUID=D93FFDDCBB34AC46E13D0583C6D71DD1B9DBFA18; GARMIN-SSO-CUST-GUID=08fbb9cf-79a8-4d8e-8ab5-55dd9941addb; SESSIONID=3fa52ae3-d581-47e7-92a1-92d648b64618; utag_main=v_id:0164d915d9dc00134b931846e5fb0307800510700093c$_sn:3$_ss:0$_st:1547303156583$ses_id:1547300767363%3Bexp-session$_pn:4%3Bexp-session; __atuvc=2%7C2; __atuvs=5c39efc14204d118001; ADRUM=s=1547301368961&r=https%3A%2F%2Fconnect.garmin.cn%2Fmodern%2F%3F0' https://connect.garmin.cn/modern