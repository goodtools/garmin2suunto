const garmin = require('../src/garmin_api');
const move = require('../src/move_api');
const g2m = require('../src/g2m')
const querystring = require('querystring');
const axios = require('axios');

var userName = process.env.username
var password = process.env.password
var usermail = process.env.username
var userkey = process.env.userkey

global.userName = userName
global.password = password
global.usermail = usermail
global.userkey = userkey
// global.garmincookie="__cfduid=de4e83944f32032115fc5eb1c22de0d961547559563; SESSIONID=1-d796-4810-b899-6dd8d6dfeac6; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=en; SESSION=; CASTGC=TGT-422196-REcE2Exu1pNIyvz0AWBjqxrUgqqSe4G0znoMrELn4NpCyQNSdX-cas; GARMIN-SSO=1; GarminNoCache=true; GarminBuyCacheKey=; GARMIN-SSO-GUID=D93FFDDCBB34AC46E13D0583C6D71DD1B9DBFA18; GARMIN-SSO-CUST-GUID=08fbb9cf-79a8-4d8e-8ab5-55dd9941addb"

axios.post("https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",{
        userName : userName,
        password : password,
        usermail : usermail,
        userkey : userkey,
        limit: 20,
        start: 0,
        action: 'list',
        cookiejar : global.garmincookie
    })
    .catch(function (e) {
        console.log(e)
    })
    .then(function (response) {
        console.log(response)
})

// axios.post("https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",{
//         userName : userName,
//         password : password,
//         usermail : usermail,
//         userkey : userkey,
//         activityId: 50453091
// })
//     .catch(function (e) {
//         console.log(e)
//     })
//     .then(function (response) {
//         console.log(response.data)
//     })


// g2m.list({
//     limit: 10,
//     start: 0
// })
//     .then(function (response2) {
//         console.log(response2)
//         console.log(garmin.cookie())
//     })

// g2m.getMove({
//     activityId : 50453091
// })
//     .then(function (e) {
//         console.log(JSON.stringify(e))
//     })


// g2m.sync({
//     activityId : 50453091
// })
//     .then(function (e) {
//         console.log(JSON.stringify(e))
//     })

