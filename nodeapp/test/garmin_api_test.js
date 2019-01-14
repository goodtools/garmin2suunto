const garmin = require('../src/garmin_api');
const move = require('../src/move_api');
const g2m = require('../src/g2m')

var userName = process.env.username
var password = process.env.password
var usermail = process.env.usermail
var userKey = process.env.userkey

global.userName = userName
global.password = password
global.usermail = usermail
global.userkey = userKey


g2m.list({
    limit: 10,
    start: 0
})
    .then(function (response2) {
        console.log(response2)
    })

