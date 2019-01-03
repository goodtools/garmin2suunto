package cn.lujiawu.app.fitlist;

import java.util.List;
import java.util.stream.Collectors;

import cn.lujiawu.garmin2suunto.fitlist.FitItem;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;

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
        fitVO.setType(activity.getActivityType().getTypeKey());
        fitVO.setDuration(String.format("%.1f", (activity.getDuration() / 60)));
        fitVO.setDistance(String.format("%.1f", (activity.getDistance() / 1000)));
        fitVO.setCalories(String.format("%.1f", activity.getCalories()));
        fitVO.setSpeed(String.format("%.1f/%.1f", activity.getAverageSpeed() * 3.6, activity.getMaxSpeed() * 3.6));
        fitVO.setHr(String.format("%.1f/%.1f", activity.getAverageHR(), activity.getMaxHR()));
        fitVO.setCadence(String.format("%.1f/%.1f", activity.getAverageRunningCadenceInStepsPerMinute(), activity.getMaxRunningCadenceInStepsPerMinute()));
        return fitVO;
    }

}
