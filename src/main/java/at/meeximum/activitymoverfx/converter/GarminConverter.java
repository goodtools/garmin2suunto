//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.converter;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.gson.garmin.Splits;
import at.meeximum.activitymoverfx.models.json.garmin.ActivityDetail;
import at.meeximum.activitymoverfx.models.json.suunto.Move;
import at.meeximum.activitymoverfx.models.json.suunto.MoveMark;
import at.meeximum.activitymoverfx.models.json.suunto.SampleSet;
import at.meeximum.activitymoverfx.models.json.suunto.TrackPoint;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GarminConverter {

    public static Move convert(Activity activity, Splits splits, ActivityDetail detail) {

        Move move = new Move();
        Long garminActivityId = activity.getActivityId();

        if ("running".equals(activity.getActivityTypeDTO().getTypeKey())) {
            move.setActivityID(3);
        } else if ("cycling".equals(activity.getActivityTypeDTO().getTypeKey())) {
            move.setActivityID(4);
        } else {
            move.setActivityID(1);
        }

        StringBuilder notes = new StringBuilder();
        if (StringUtils.isNotBlank(activity.getActivityName())) {
            notes.append(activity.getActivityName());
            notes.append("\n\n");
            notes.append(activity.getActivityId().toString());
            notes.append("\n\n");
        }

        if (StringUtils.isNotBlank(activity.getDescription())) {
            notes.append(activity.getDescription());
            notes.append("\n\n");
        }
        notes.append("http://connect.garmin.cn/activity/%id%".replaceAll("%id%", garminActivityId.toString()));

        move.setNotes(notes.toString());

        move.setLocalStartTime(activity.getSummaryDTO().getStartTimeLocal());
        Double var9 = activity.getSummaryDTO().getStartLatitude();
        if (var9 != null) {
            move.setStartLatitude(var9);
        }

        Double var10 = activity.getSummaryDTO().getStartLongitude();
        if (var10 != null) {
            move.setStartLongitute(var10);
        }

        Long var13 = 9223372036854775807L;
        Long var14 = -9223372036854775808L;
        ArrayList var16 = new ArrayList();
        Double var18 = null;
        Double var19 = null;
        Double var20 = null;

        Double var25;
        Double var26;
        Double var27;
        Double var28;
        Double var29;
        Double var30;
        Double var31;
        Double var32;
        Double var33;
        Double var34;
        Collections.sort(var16, new Comparator<TrackPoint>() {
            @Override
            public int compare(TrackPoint var1, TrackPoint var2) {
                return var1.getLocalTime().compareTo(var2.getLocalTime());
            }
        });


        //TODO
        Double var49;

        Double var44 = activity.getSummaryDTO().getElevationGain();
        if (var44 != null) {
            move.setAscentAltitude(var44);
        }

        Double var46 = activity.getSummaryDTO().getElevationLoss();
        if (var46 != null) {
            move.setAscentAltitude(var46);
        }

        Double var48 = activity.getSummaryDTO().getDistance();
        if (var48 != null) {
            move.setDistance(var48.intValue());
        } else {
            move.setDistance(0);
        }


        try {
            var49 = activity.getSummaryDTO().getMovingDuration();
            if (Double.valueOf(var49).equals(0.0D)) {
                throw new Exception("SumMovingDuration set but zero!");
            }
        } catch (Exception var41) {
            var49 = activity.getSummaryDTO().getDuration();
        }

        if (var49 == null && var13 != null && var13 < 9223372036854775807L && var14 != null && var14 > -9223372036854775808L) {
            var49 = (double) (var14 - var13) / 1000.0D;
        }

        move.setDuration(var49);
        var25 = activity.getSummaryDTO().getAverageHR();
        if (var25 != null) {
            move.setAvgHR(var25.intValue());
        }

        if (var18 != null) {
            move.setMinHR(var18.intValue());
        }

        var26 = activity.getSummaryDTO().getMaxHR();
        if (var26 != null) {
            move.setPeakHR(var26.intValue());
        }

        var27 = activity.getSummaryDTO().getCalories();
        if (var27 != null) {
            move.setEnergy(var27.intValue());
        }

        var28 = activity.getSummaryDTO().getMaxElevation();
        if (var28 != null) {
            move.setHighAltitude(var28.floatValue());
        }

        var29 = activity.getSummaryDTO().getMinElevation();
        if (var29 != null) {
            move.setLowAltitude(var29.floatValue());
        }

        var30 = activity.getSummaryDTO().getMaxSpeed();
        if (var30 != null) {
            move.setMaxSpeed(var30.floatValue());
        }

        var31 = activity.getSummaryDTO().getAverageMovingSpeed();
        if (var31 != null) {
            move.setAvgSpeed(var31.floatValue());
        }

        var32 = activity.getSummaryDTO().getMaxPower();
        if (var32 != null) {
            move.setMaxPower(var32.floatValue());
        }

        var33 = activity.getSummaryDTO().getAveragePower();
        if (var32 != null) {
            move.setAvgPower(var33.floatValue());
        }

        var34 = activity.getSummaryDTO().getAverageTemperature();
        if (var34 != null) {
            move.setAvgTemp(var34.floatValue());
        }

        Double var35 = activity.getSummaryDTO().getMinTemperature();
        if (var35 == null) {
            var35 = var19;
        }

        if (var35 != null) {
            move.setMinTemp(var35.floatValue());
        }

        Double var36 = activity.getSummaryDTO().getMaxTemperature();
        if (var36 == null) {
            var36 = var20;
        }

        if (var36 != null) {
            move.setMaxTemp(var36.floatValue());
        }

        Double var37 = activity.getSummaryDTO().getAverageBikeCadence();
        if (var37 != null) {
            move.setAvgBikeCadence(var37.floatValue());
        }

        Double var38 = activity.getSummaryDTO().getMaxBikeCadence();
        if (var38 != null) {
            move.setAvgBikeCadence(var38.floatValue());
        }

        Double var39 = activity.getSummaryDTO().getAverageRunCadence();
        if (var39 != null) {
            move.setAvgRunningCadence(var39.floatValue());
        }

        Double var40 = activity.getSummaryDTO().getMaxRunCadence();
        if (var40 != null) {
            move.setAvgRunningCadence(var40.floatValue());
        }


        move.setMarks(convertMoveMarks(splits));
        move.setSamples(convertSampleSet(detail));
        move.setTrack(convertTrackPoint(detail));

        if (move.getAvgTemp() != null && move.getMinTemp() != null && move.getAvgTemp() < move.getMinTemp()) {
            move.setAvgTemp(move.getMinTemp());
        }

        return move;
    }

    private static List<MoveMark> convertMoveMarks(Splits splits) {
        return splits.getLapDTOs().stream().map(lapDTO -> {
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
                .map( m -> GarminConverter.convert(m,index))
                .collect(Collectors.toList());
    }

    private static List<TrackPoint> convertTrackPoint(ActivityDetail detail) {
        if (null == detail.getGeoPolylineDTO() || null == detail.getGeoPolylineDTO().getPolyline()) {
            return Collections.EMPTY_LIST;
        }
        return detail.getGeoPolylineDTO().getPolyline().stream().map(GarminConverter::convert).collect(Collectors.toList());
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
