package cn.lujiawu.garmin2suunto.fitlist;

import org.junit.Test;

import cn.lujiawu.garmin2suunto.SyncBaseTest;

import static org.junit.Assert.*;

public class FitListServiceTest extends SyncBaseTest {

    @Test
    public void getActivityPaged() {

        FitListService fitListService = new FitListService();

        fitListService.getActivityPaged(0,20)
                .subscribe(list -> {
                    System.out.println(list.size());
                });


    }

    @Test
    public void getMoves() {
    }
}