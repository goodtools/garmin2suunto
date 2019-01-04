//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.util;

import cn.lujiawu.garmin2suunto.garmin.api.Activity;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityDetail;
import cn.lujiawu.garmin2suunto.garmin.api.ActivitySplits;
import cn.lujiawu.garmin2suunto.move.api.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Act2MoveConverter {

    public static Move convert(Activity activity, ActivitySplits splits, ActivityDetail detail) {

        Move move = new Move();

        move.setNotes(getNotes(activity));

        Activity.SummaryDTO summaryDTO = activity.getSummaryDTO();
        move.setLocalStartTime(summaryDTO.getStartTimeLocal());
        move.setStartLatitude(summaryDTO.getStartLatitude());
        move.setStartLongitute(summaryDTO.getStartLongitude());

        move.setAscentAltitude(summaryDTO.getElevationGain());
        if (summaryDTO.getElevationLoss() != null) {
            move.setAscentAltitude(summaryDTO.getElevationLoss());
        }

        Double distance = summaryDTO.getDistance();
        move.setDistance(null == distance ? 0 : distance.intValue());

        move.setDuration(summaryDTO.getDuration());
        if (null != summaryDTO.getAverageHR()) {
            move.setAvgHR(summaryDTO.getAverageHR().intValue());
        }
        if (null != summaryDTO.getMaxHR()) {
            move.setPeakHR(summaryDTO.getMaxHR().intValue());
        }
        if (summaryDTO.getCalories() != null) {
            move.setEnergy(summaryDTO.getCalories().intValue());
        }
        if (summaryDTO.getMaxElevation() != null) {
            move.setHighAltitude(summaryDTO.getMaxElevation().floatValue());
        }
        if (summaryDTO.getMinElevation() != null) {
            move.setLowAltitude(summaryDTO.getMinElevation().floatValue());
        }
        if (summaryDTO.getMaxSpeed() != null) {
            move.setMaxSpeed(summaryDTO.getMaxSpeed().floatValue());
        }
        if (summaryDTO.getAverageMovingSpeed() != null) {
            move.setAvgSpeed(summaryDTO.getAverageMovingSpeed().floatValue());
        }
        if (summaryDTO.getMaxPower() != null) {
            move.setMaxPower(summaryDTO.getMaxPower().floatValue());
        }
        if (summaryDTO.getAveragePower() != null) {
            move.setAvgPower(summaryDTO.getAveragePower().floatValue());
        }
        if (summaryDTO.getAverageTemperature() != null) {
            move.setAvgTemp(summaryDTO.getAverageTemperature().floatValue());
        }
        if (summaryDTO.getMinTemperature() != null) {
            move.setMinTemp(summaryDTO.getMinTemperature().floatValue());
        }
        if (summaryDTO.getMaxTemperature() != null) {
            move.setMaxTemp(summaryDTO.getMaxTemperature().floatValue());
        }
        if (summaryDTO.getAverageTemperature() != null) {
            move.setAvgTemp(summaryDTO.getAverageTemperature().floatValue());
        }
        //设置cadence 重要
        if (summaryDTO.getAverageBikeCadence() != null) {
            move.setAvgBikeCadence(summaryDTO.getAverageBikeCadence().floatValue());
        }
        if (summaryDTO.getMaxBikeCadence() != null) {
            move.setMaxBikeCadence(summaryDTO.getMaxBikeCadence().floatValue());
        }
        if (summaryDTO.getAverageRunCadence() != null) {
            move.setAvgRunningCadence(summaryDTO.getAverageRunCadence().floatValue());
        }
        if (summaryDTO.getMaxRunCadence() != null) {
            move.setMaxRunningCadence(summaryDTO.getMaxRunCadence().floatValue());
        }

        move.setMarks(convertMoveMarks(splits));
        move.setSamples(new Move.Samples(convertSampleSet(detail)));
        List<TrackPoint> trackPoints = convertTrackPoint(detail);
        move.setTrack(new Move.Track(trackPoints));

        //TODO
        move.setActivityID(getActivityType(activity,!trackPoints.isEmpty()));

        return move;
    }

    private static int getActivityType(Activity activity, boolean hasTrack) {
        if ("running".equals(activity.getActivityTypeDTO().getTypeKey())) {
            if (hasTrack) {
                return SuuntoSport.RUN.getId();
            }
            return SuuntoSport.TREADMILL.getId();
        } else if ("cycling".equals(activity.getActivityTypeDTO().getTypeKey())) {
            return SuuntoSport.CYCLING.getId();
        }
        return SuuntoSport.NOT_SPECIFIED_SPORT.getId();
    }

    private static String getNotes(Activity activity) {
        StringBuilder notes = new StringBuilder();
        Long garminActivityId = activity.getActivityId();
        notes.append(activity.getActivityId().toString());
        notes.append("\n\n");
        if (StringUtils.isNotBlank(activity.getActivityName())) {
            notes.append(activity.getActivityName());
            notes.append("\n\n");
        }

        if (StringUtils.isNotBlank(activity.getDescription())) {
            notes.append(activity.getDescription());
            notes.append("\n\n");
        }
        notes.append("http://connect.garmin.cn/activity/%id%".replaceAll("%id%", garminActivityId.toString()));
        return notes.toString();
    }

    private static List<MoveMark> convertMoveMarks(ActivitySplits splits) {
        return splits.getLaps().stream().map(lapDTO -> {
            MoveMark moveMark = new MoveMark();
            moveMark.setType(0);
            moveMark.setSplitTimeFromPrevious(lapDTO.getDuration());
            moveMark.setDistanceFromPrevious(lapDTO.getDistance().intValue());
            return moveMark;
        }).collect(Collectors.toList());
    }

    private static List<SampleSet> convertSampleSet(ActivityDetail detail) {
        if (null == detail.getActivityDetailMetrics()) {
            return Collections.EMPTY_LIST;
        }
        ActivityDetail.MetricIndex index = new ActivityDetail.MetricIndex(detail.getMetricDescriptors());
        return detail.getActivityDetailMetrics()
                .stream()
                .map(m -> Act2MoveConverter.convert(m, index))
                .collect(Collectors.toList());
    }

    private static List<TrackPoint> convertTrackPoint(ActivityDetail detail) {
        if (null == detail.getGeoPolylineDTO() || null == detail.getGeoPolylineDTO().getPolyline()) {
            return Collections.EMPTY_LIST;
        }
        return detail.getGeoPolylineDTO().getPolyline().stream().map(Act2MoveConverter::convert).collect(Collectors.toList());
    }

    private static SampleSet convert(ActivityDetail.ActivityDetailMetric activityDetailMetric, ActivityDetail.MetricIndex index) {
        SampleSet sampleSet = new SampleSet();
        sampleSet.setBikeCadence(activityDetailMetric.getCadence(index));
        sampleSet.setDistance(activityDetailMetric.getDistance(index));
        sampleSet.setHeartRate(activityDetailMetric.getHeartRate(index));
        sampleSet.setLocalTime(activityDetailMetric.getLocalTime(index));
        sampleSet.setRunningCadence(activityDetailMetric.getRunningCadence(index));
        sampleSet.setSpeed(activityDetailMetric.getSpeed(index));
        return sampleSet;
    }

    private static TrackPoint convert(ActivityDetail.Track track) {
        TrackPoint tp = new TrackPoint();
        tp.setAltitude(track.getAltitude());
        tp.setLatitude(track.getLat());
        tp.setLocalTime(track.getTimeLocale());
        tp.setLongitude(track.getLon());
        tp.setSpeed(track.getSpeed());
        return tp;
    }

}
