package cn.lujiawu.app.fitlist;

import java.util.List;
import java.util.stream.Collectors;

import cn.lujiawu.garmin2suunto.fitlist.FitItem;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.SuuntoSport;

public class FitConverter {

    public static List<FitVO> convert(List<FitItem> fitItems) {
        return fitItems.stream().map(FitConverter::convert).collect(Collectors.toList());
    }

    public static FitVO convert(FitItem fitItem) {
        FitVO fitVO = new FitVO();
        ActivityItem activity = fitItem.getActivity();
        fitVO.setActivityId(activity.getActivityId());
        if (null != fitItem.getMove()) {
            fitVO.setMoveId(fitItem.getMove().getMoveId().toString());
        }

        fitVO.setTitle(activity.getStartTimeLocal().substring(5, 16) + " " + activity.getActivityName());
//        "running", "cycling"
        String type = activity.getActivityType().getTypeKey();
        if ("running".equals(type)) {
            if (null != activity.getStartLatitude()) {
                fitVO.setType(SuuntoSport.RUN);
            }else {
                fitVO.setType(SuuntoSport.TREADMILL);
            }
        }else if ("treadmill_running".equals(type)) {
            fitVO.setType(SuuntoSport.TREADMILL);
        }else if ("cycling".equals(type)) {
            fitVO.setType(SuuntoSport.CYCLING);
        }else {
            fitVO.setType(SuuntoSport.NOT_SPECIFIED_SPORT);
        }

        fitVO.setDuration(formatDuration(activity.getDuration()));
        fitVO.setDistance(String.format("%.2f", (activity.getDistance() / 1000)));
        fitVO.setCalories(String.format("%.1f", activity.getCalories()));
        fitVO.setSpeed(String.format("%.1f/%.1f", activity.getAverageSpeed() * 3.6, activity.getMaxSpeed() * 3.6));
        fitVO.setHr(String.format("%.1f/%.1f", activity.getAverageHR(), activity.getMaxHR()));
        fitVO.setCadence(String.format("%.1f/%.1f", activity.getAverageRunningCadenceInStepsPerMinute(), activity.getMaxRunningCadenceInStepsPerMinute()));
        return fitVO;
    }

    public static String formatDuration(Double duration) {
        long seconds = duration.longValue();
        long absSeconds = Math.abs(seconds);
        long hour = absSeconds / 3600;
        long minute = (absSeconds % 3600) / 60;
        long second =  absSeconds % 60;

        StringBuffer stringBuffer = new StringBuffer();
        if (hour > 0){
            stringBuffer.append(hour).append(":");
        }
        return stringBuffer.append(String.format("%02d",minute))
                .append(":")
                .append(String.format("%02d",second)).toString();

    }

}
