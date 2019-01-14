const g2m = require('./g2m');

exports.main_handler = async (event, context, callback) => {

    var query = event.queryString;

    global.userName = query.userName
    global.password = query.password
    global.usermail = query.usermail
    global.userkey = query.userkey

    let newVar = await g2m.list({
        limit: query.limit,
        start: query.start
    }).then(function (list) {
        var response = {
            "isBase64Encoded": false,
            "statusCode": 200,
            "headers": {"Content-Type":"application/json"},
            "body": JSON.stringify(list)
        }
        return response
    });
    console.log(newVar)
    return newVar
};



