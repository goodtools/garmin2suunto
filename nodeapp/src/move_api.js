const axios = require('axios').create({
    baseURL: 'https://uiservices.movescount.com',
});
const querystring = require('querystring');

let regex = new RegExp("\\d+");
function getGarminActivityId(item) {
    if (!item.Notes){
        return "";
    }
    var found = regex.exec(item.Notes)
    if (found){
        return found[0]
    }
    return ""
}

module.exports = {

    list: function (startdate, maxcount) {
        var searchUrl = '/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP';
        return axios.get(searchUrl, {
            params: {
                email: global.userName,
                userkey: global.userkey,
                startDate: startdate,
                maxcount: maxcount
            }
        })
            .catch(function (e) {
                console.log(e)
            })
            .then(function (response) {
                var ret = {};
                for (let i = 0; i < response.data.length; i++) {
                    var data = response.data[i]
                    var id = getGarminActivityId(data)
                    if (id && id != ''){
                        ret[id] = data
                    }
                }
                return ret;
            })
    }
}