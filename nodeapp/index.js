const g2m = require('./src/g2m');

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

    var response = {
        "isBase64Encoded": false,
        "statusCode": 200,
        "headers": {"Content-Type": "application/json"},
    }

    if (event.httpMethod == 'GET'){
        let newVar = await doGet(query);
        response.body = JSON.stringify(newVar)
    }else if (event.httpMethod == 'POST'){
        let newVar = await doPost(query);
        response.body = JSON.stringify(newVar)
    }

    // console.log(response)
    return response
};



