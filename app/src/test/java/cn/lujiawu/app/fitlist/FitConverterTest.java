package cn.lujiawu.app.fitlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class FitConverterTest {

    @Test
    public void convert() {

        System.out.println(String.format("%8s %s", "2018-12-29 07:06:22".substring(5,16),"杭州市 跑步"));

        Double duraing = 1986.9859619140625D;
        System.out.println(String.format("%.1f/%.1f", (duraing / 60),(duraing / 60)));
        System.out.println(String.format("%.1f", null));

        System.out.println(String.format("%.1f", (2.5759999752044673 * 3.6)));
        System.out.println(String.format("%.1f", (4.255000114440918 * 3.6)));
        System.out.println(String.format("%.1f", (4.255000114440918 * 3.6)));

    }
}