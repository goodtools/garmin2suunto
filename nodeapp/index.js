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

exports.main_handler = async (event, context, callback) => {

    console.log(event)
    var query = event.queryString;
    console.log(query)
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
    }

    // console.log(response)
    return response
};



