function convertSimple(activity, move) {

    var fitVO = {};
    fitVO.activityId = activity.activityId;
    if (move){
        fitVO.moveId = move.MoveID;
    }
    fitVO.title = (activity.startTimeLocal.substring(5, 16) + " " + activity.activityName);
//        "running", "cycling"
    var type = activity.activityType.typeKey;
    if ("running" == (type)) {
        if (null != activity.startLatitude) {
            fitVO.type = ("run");
        }else {
            fitVO.type = ("treadmill");
        }
    }else if ("treadmill_running" == (type)) {
        fitVO.type = "treadmill";
    }else if ("cycling" == (type)) {
        fitVO.type =("bike");
    }else {
        fitVO.type =("run");
    }
    fitVO.duration = formatDuration(activity.duration);
    fitVO.distance = (activity.distance / 1000).toFixed(2);
    fitVO.calories = activity.calories.toFixed(1);
    fitVO.speed = (activity.averageSpeed * 3.6).toFixed(1) + "/" + (activity.maxSpeed * 3.6).toFixed(1);
    fitVO.hr = activity.averageHR.toFixed(1) + "/" + activity.maxHR.toFixed(1);
    fitVO.cadence = activity.averageRunningCadenceInStepsPerMinute.toFixed(1) + "/" + activity.maxRunningCadenceInStepsPerMinute.toFixed(1);
    return fitVO;


}

function formatDuration(duration) {

    var absSeconds = Number.parseInt(duration.toFixed(0));
    var hour = (absSeconds / 3600).toFixed(0);
    var minute = ((absSeconds % 3600) / 60).toFixed(0);
    if (hour < 10){
        hour = "0" + hour;
    }
    if (minute < 10){
        minute = "0" + minute;
    }
    return hour + ":" + minute

}




function convertMove(activity, splits, detail) {

    var move = {}
    move.Notes = getNotes(activity);
    var summaryDTO = activity.summaryDTO;

    summaryDTO.startTimeLocal && (move.LocalStartTime=summaryDTO.startTimeLocal)
    summaryDTO.startLatitude && (move.StartLatitude=summaryDTO.startLatitude)
    summaryDTO.startLongitude && (move.StartLongitute=summaryDTO.startLongitude)
    move.AscentAltitude=summaryDTO.elevationGain;
    if (summaryDTO.elevationLoss) {
        move.AscentAltitude=summaryDTO.elevationLoss;
    }
    var distance = summaryDTO.distance;
    move.Distance = ( distance ? Number.parseInt(distance) : 0 );
    move.Duration = summaryDTO.duration;
    
    if (summaryDTO.averageHR) {
        move.AvgHR = Number.parseInt(summaryDTO.averageHR)
    }
    if (summaryDTO.maxHR) {
        move.PeakHR = Number.parseInt(summaryDTO.maxHR)
    }
    if (summaryDTO.calories) {
        move.Energy = Number.parseInt(summaryDTO.calories)
    }
    if (summaryDTO.maxElevation) {
        move.HighAltitude = Number.parseFloat(summaryDTO.maxElevation)
    }
    if (summaryDTO.minElevation) {
        move.LowAltitude = Number.parseFloat(summaryDTO.minElevation)
    }
    if (summaryDTO.maxSpeed) {
        move.MaxSpeed = Number.parseFloat(summaryDTO.maxSpeed)
    }
    if (summaryDTO.averageMovingSpeed) {
        move.AvgSpeed= Number.parseFloat(summaryDTO.averageMovingSpeed)
    }
    if (summaryDTO.maxPower) {
        move.MaxPower= Number.parseFloat(summaryDTO.maxPower)
    }
    if (summaryDTO.averagePower) {
        move.AvgPower = Number.parseFloat(summaryDTO.averagePower)
    }
    if (summaryDTO.averageTemperature) {
        move.AvgTemp= Number.parseFloat(summaryDTO.averageTemperature)
    }
    if (summaryDTO.minTemperature) {
        move.MinTemp= Number.parseFloat(summaryDTO.minTemperature)
    }
    if (summaryDTO.maxTemperature) {
        move.MaxTemp= Number.parseFloat(summaryDTO.maxTemperature)
    }
    if (summaryDTO.averageTemperature) {
        move.AvgTemp= Number.parseFloat(summaryDTO.averageTemperature)
    }
    //设置cadence 重要
    if (summaryDTO.averageBikeCadence) {
        move.AvgBikeCadence= Number.parseFloat(summaryDTO.averageBikeCadence)
    }
    if (summaryDTO.maxBikeCadence) {
        move.MaxBikeCadence= Number.parseFloat(summaryDTO.maxBikeCadence)
    }
    if (summaryDTO.averageRunCadence) {
        move.AvgRunningCadence= Number.parseFloat(summaryDTO.averageRunCadence)
    }
    if (summaryDTO.maxRunCadence) {
        move.MaxRunningCadence= Number.parseFloat(summaryDTO.maxRunCadence)
    }

    move.Marks = convertMoveMarks(splits);
    var trackPoints = convertTrackPoint(detail);
    move.Track = {
        TrackPoints : trackPoints
    }
    move.Samples = {
        SampleSets : convertSampleList(detail)
    }

    move.ActivityID = getActivityType(activity, trackPoints.length > 0);
    return move;
}

function getActivityType(activity, hasTrack) {
    var type = activity.activityTypeDTO.typeKey;
    if ("running" == (type)) {
        if (hasTrack) {
            return 3;
        }
        return 93;
    } else if ("cycling" == (type)) {
        return 4;
    }else if ("treadmill_running" == (type)){
        return 93;
    }
    return 1;
}

function getNotes(activity) {
    var notes = "";
    var garminActivityId = activity.activityId;
    notes += garminActivityId
    notes += ("\n\n");
    if (activity.activityName) {
        notes += activity.activityName;
        notes += ("\n\n");
    }

    if (activity.description) {
        notes += activity.description;
        notes +=("\n\n");
    }
    notes += ("http://connect.garmin.cn/activity/"  +  garminActivityId);
    return notes;
}



function convertMoveMarks(splits) {
    var marks = []
    splits.lapDTOs.forEach(function (lapDTO) {
        var moveMark = {};
        moveMark.Type = 0;
        moveMark.SplitTimeFromPrevious = lapDTO.duration;
        moveMark.DistanceFromPrevious = Number.parseInt(lapDTO.distance);
        marks.push(moveMark)
    })
    return marks
}

function convertTrackPoint(detail) {
    if ( null == detail.geoPolylineDTO || null == detail.geoPolylineDTO.polyline) {
        return [];
    }
    var list = []
    detail.geoPolylineDTO.polyline.forEach(function (track) {
        list.push(convertTrack(track))
    })
    return list
}
function convertTrack(track) {
    var tp = {};
    // tp.Altitude = track.altitude;
    tp.Latitude = track.lat;
    tp.LocalTime = getLocalTime(track.time);
    tp.Longitude = track.lon
    tp.Speed = track.speed
    return tp;
}


function convertSampleList(detail) {
    if (null == detail.activityDetailMetrics) {
        return [];
    }
    var index = getMetricIndex(detail.metricDescriptors);
    var list = []
    detail.activityDetailMetrics.forEach(function (m) {
        list.push(convertSample(m.metrics,index))
    })
    return list;
}

function getLocalTime(timeLong) {
    return new Date( timeLong + 8 * 3600 * 1000).toISOString().substring(0, 19);
}

function convertSample(metrics, index) {
    var sampl = {};
    sampl.BikeCadence = Number.parseFloat(metrics[index.runCadence])
    sampl.Distance = Number.parseInt(metrics[index.distance])
    sampl.HeartRate = Number.parseInt(metrics[index.hearRate])
    sampl.LocalTime =  getLocalTime(metrics[index.time]);
    sampl.RunningCadence =  Number.parseFloat(metrics[index.doubleCadence])
    sampl.Speed = Number.parseFloat(metrics[index.speed])
    return sampl;
}

function getMetricIndex(descriptors) {
    if (null == descriptors) {
        return null;
    }
    var index = {};
    for (var i = 0; i < descriptors.length; i++) {
        var descriptor = descriptors[i];
        var j = descriptor.metricsIndex;
        switch (descriptor.key) {
            case "directRunCadence":
                index.runCadence = j;
                break;
            case "directHeartRate":
                index.hearRate = j;
                break;
            case "directSpeed":
                index.speed = j;
                break;
            case "directDoubleCadence":
                index.doubleCadence = j;
                break;
            case "directTimestamp":
                index.time = j;
                break;
            case "sumDistance":
                index.distance = j;
                break;
            default:
                break;
        }
    }
    return index
}

module.exports = {
    convertMove,
    convertSimple
}
