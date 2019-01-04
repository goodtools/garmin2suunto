package cn.lujiawu.garmin2suunto;

import org.junit.Test;

import java.util.UUID;

public class UUIdTest {
    @Test
    public void test(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }

}
