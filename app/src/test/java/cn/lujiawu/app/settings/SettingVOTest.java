package cn.lujiawu.app.settings;

import org.junit.Test;

import static org.junit.Assert.*;

public class SettingVOTest {

    @Test
    public void test() throws CloneNotSupportedException {

        SettingVO settingVO = new SettingVO();
        settingVO.suuntoUserKey = "123";

        SettingVO clone = (SettingVO) settingVO.clone();
        System.out.println(clone);

    }


}