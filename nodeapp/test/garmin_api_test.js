const garmin = require('../src/garmin_api');
const move = require('../src/move_api');
const g2m = require('../src/g2m')
const querystring = require('querystring');
const axios = require('axios');

var userName = process.env.username
var password = process.env.password
var usermail = process.env.usermail
var userkey = process.env.userkey

global.userName = userName
global.password = password
global.usermail = usermail
global.userkey = userkey



axios.get("https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",{
    params: {
        userName : userName,
        password : password,
        usermail : usermail,
        userkey : userkey,
        limit: 20,
        start: 0
    }
})
    .catch(function (e) {
        console.log(e)
    })
    .then(function (response) {
        console.log(response.data[0])
})

axios.post("https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",{
        userName : userName,
        password : password,
        usermail : usermail,
        userkey : userkey,
        activityId: 50453091
})
    .catch(function (e) {
        console.log(e)
    })
    .then(function (response) {
        console.log(response.data)
    })


// g2m.list({
//     limit: 10,
//     start: 0
// })
//     .then(function (response2) {
//         console.log(response2)
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

