//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.converter;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.gson.garmin.LapDTO;
import at.meeximum.activitymoverfx.models.gson.garmin.Splits;
import at.meeximum.activitymoverfx.models.json.garmin.GActivityDetails;
import at.meeximum.activitymoverfx.models.json.suunto.Move;
import at.meeximum.activitymoverfx.models.json.suunto.MoveMark;
import at.meeximum.activitymoverfx.models.json.suunto.SampleSet;
import at.meeximum.activitymoverfx.models.json.suunto.TrackPoint;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class GarminConverter {

    public static Move convert(Activity activity, Splits splits, GActivityDetails detail) {

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

        String var8 = detail.getTimeStamp(0);
        if (StringUtils.isBlank(var8)) {
            var8 = activity.getSummaryDTO().getStartTimeLocal();
        }

        move.setLocalStartTime(var8);
        Double var9 = activity.getSummaryDTO().getStartLatitude();
        if (var9 != null) {
            move.setStartLatitude(var9);
        }

        Double var10 = activity.getSummaryDTO().getStartLongitude();
        if (var10 != null) {
            move.setStartLongitute(var10);
        }

        Double var11 = move.getStartLatitude();
        Double var12 = move.getStartLongitute();
        Long var13 = 9223372036854775807L;
        Long var14 = -9223372036854775808L;
        ArrayList var15 = new ArrayList();
        ArrayList var16 = new ArrayList();
        ArrayList var17 = new ArrayList();
        Double var18 = null;
        Double var19 = null;
        Double var20 = null;

        SampleSet var24;
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
        for (int var21 = 0; var21 < detail.getMetrics().size(); ++var21) {
            String var22 = detail.getTimeStamp(var21);
            if (detail.getTimeStampMS(var21) < var13) {
                var13 = detail.getTimeStampMS(var21);
            }

            if (detail.getTimeStampMS(var21) > var14) {
                var14 = detail.getTimeStampMS(var21);
            }

            try {
                var24 = new SampleSet();
                var24.setLocalTime(var22);
                var25 = detail.getElevationInM(var21);
                if (var25 != null && var25 != 0.0D) {
                    var24.setAltitude(var25.floatValue());
                }

                var26 = detail.getBikeCadence(var21);
                if (var26 != null && var26 != 0.0D) {
                    var24.setBikeCadence(var26.floatValue());
                }

                var27 = detail.getDistanceInKM(var21);
                if (var27 != null && var27 != 0.0D) {
                    var24.setDistance((int) (var27 * 1000.0D));
                }

                var28 = detail.getHeartRate(var21);
                if (var18 == null || var28 < var18) {
                    var18 = var28;
                }

                if (var28 != null && var28 != 0.0D) {
                    var24.setHeartRate(var28.intValue());
                }

                var29 = detail.getPower(var21);
                if (var29 != null && var29 != 0.0D) {
                    var24.setPower(var29.intValue());
                }

                var30 = detail.getRunCadence(var21);
                if (var30 != null && var30 != 0.0D) {
                    var24.setBikeCadence(var30.floatValue());
                }

                var31 = detail.getSpeedInMPS(var21);
                if (var31 != null && var31 != 0.0D) {
                    var24.setSpeed(var31.floatValue());
                }

                var32 = detail.getAirTemperature(var21);
                if (var19 == null || var32 < var19) {
                    var19 = var32;
                }

                if (var20 == null || var32 > var20) {
                    var20 = var32;
                }

                if (var32 != null && var32 != 0.0D) {
                    var24.setTemperature(var32.floatValue());
                }

                var15.add(var24);
                TrackPoint var23 = new TrackPoint();
                var23.setLocalTime(detail.getTimeStamp(var21));
                var23.setAltitude(var24.getAltitude());
                var33 = detail.getLongitude(var21);
                if (var33 != null && var33 != 0.0D) {
                    var23.setLongitude(var33);
                    var12 = var33;
                } else {
                    var23.setLongitude(var12);
                }

                var34 = detail.getLatitude(var21);
                if (var34 != null && var34 != 0.0D) {
                    var23.setLatitude(var34);
                    var11 = var34;
                } else {
                    var23.setLatitude(var11);
                }

                if (var23.getLatitude() != null && var23.getLongitude() != null) {
                    var16.add(var23);
                }
            } catch (Exception var42) {
                var42.printStackTrace();
            }
        }

        Collections.sort(var16, new Comparator<TrackPoint>() {
            @Override
            public int compare(TrackPoint var1, TrackPoint var2) {
                return var1.getLocalTime().compareTo(var2.getLocalTime());
            }
        });
        Collections.sort(var15, new Comparator<SampleSet>() {
            @Override
            public int compare(SampleSet var1, SampleSet var2) {
                return var1.getLocalTime().compareTo(var2.getLocalTime());
            }
        });
        Iterator var43 = splits.getLapDTOs().iterator();

        Double var49;
        while (var43.hasNext()) {
            LapDTO var45 = (LapDTO) var43.next();
            MoveMark var47 = new MoveMark();
            var49 = var45.getDuration();
            if (var49 != null) {
                var47.setSplitTimeFromPrevious(var49);
                var17.add(var47);
            }
        }

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

        var24 = null;

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

        if (var17.size() > 0) {
            move.setMarks(var17);
        }

        if (var15.size() > 0) {
            move.setSamples(var15);
        }

        if (var16.size() > 0) {
            move.setTrack(var16);
        }

        if (move.getAvgTemp() != null && move.getMinTemp() != null && move.getAvgTemp() < move.getMinTemp()) {
            move.setAvgTemp(move.getMinTemp());
        }

        return move;
    }


}
