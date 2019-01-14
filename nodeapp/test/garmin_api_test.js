const garmin = require('../src/garmin_api');
const move = require('../src/move_api');
const g2m = require('../src/g2m')

var userName = process.env.username
var password = process.env.password
var usermail = process.env.usermail
var userkey = process.env.userkey

global.userName = userName
global.password = password
global.usermail = usermail
global.userkey = userkey


// const axios = require('axios');
// axios.get("https://service-p9bx7akn-1257958482.ap-shanghai.apigateway.myqcloud.com/release/g2m_node",{
//     params: {
//         userName : userName,
//         password : password,
//         usermail : usermail,
//         userkey : userkey,
//         limit: 20,
//         start: 0
//     }
// })
//     .catch(function (e) {
//         console.log(e)
//     })
//     .then(function (response) {
//     console.log(response)
// })


// g2m.list({
//     limit: 10,
//     start: 0
// })
//     .then(function (response2) {
//         console.log(response2)
//     })

garmin.getMove(50360706)
    .then(function (e) {
        console.log(e)
    })

