package cn.lujiawu.garmin2suunto;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    @Test
    public void test(){

        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher("50360706\n\n跑步\n\nhttp://connect.garmin.cn/activity/50360706");
        matcher.find();
        String string = matcher.group();//提取匹配到的结果
        System.out.println(string);

        matcher = compile.matcher("activity 50360706 123123.tcx");
        matcher.find();
        string = matcher.group();//提取匹配到的结果
        System.out.println(string);

    }

}
