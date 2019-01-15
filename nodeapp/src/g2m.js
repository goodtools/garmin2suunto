const garmin = require('./garmin_api');
const move = require('./move_api');
const convert = require('./convert');

module.exports = {

    list : function (param) {
        return garmin.search(param.limit, param.start)
            .then(function (response) {
                if (response.length > 0) {
                    var startTimeLocal = response[response.length - 1].startTimeLocal;
                    var startDate = startTimeLocal.split(" ")[0];
                    return move.list(startDate, response.length)
                        .then(function (map) {
                            response.forEach(function (data) {
                                data.move_data = map[data.activityId]
                            })
                            return response;
                        })
                }
            })
    },

    getMove: function (param) {
        return garmin.getActivity(param.activityId)
            .then(function (response) {
                // console.log(response)
                return convert(response.activity,response.splites,response.detail )
            })
    },

    save: function (data) {
        return move.save(data)
    },

    sync: function (param) {
        var self = this;
        return this.getMove(param)
            .then(function (data) {
                return self.save(data)
            })
    }

}