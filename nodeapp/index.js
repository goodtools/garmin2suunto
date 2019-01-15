const g2m = require('./src/g2m');
const garmin = require('./src/garmin_api');

async function doGet(query) {
    let newVar = await g2m.list({
        limit: query.limit,
        start: query.start
    }).then(function (list) {
        return list
    });
    return newVar;
}

async function doPost(query) {
    let newVar = await g2m.sync({
        activityId: query.activityId
    }).then(function (result) {
        return result
    });
    return newVar;
}

exports.main_handler = async (event, context, callback) => {

    var query = event.queryString;
    if (event.httpMethod == 'POST'){
        query = JSON.parse(event.body)
    }
    global.userName = query.userName
    global.password = query.password
    global.usermail = query.usermail
    global.userkey = query.userkey
    global.garminCookie = query.cookiejar

    var response = {
        "isBase64Encoded": false,
        "statusCode": 200
    }

    switch (query.action) {
        case "list":
            console.log("start to do list")
            let newVar = await doGet(query);
            response.body = JSON.stringify(newVar)
            break;
        case "sync":
            console.log("start to do sync")
            let newVar2 = await doPost(query);
            response.body = JSON.stringify(newVar2)
            break;
        default:
            break;
    }

    response.headers = {"Content-Type": "application/json" , "garmin-cookie" : garmin.cookie()};
    // console.log(response)
    return response
};



