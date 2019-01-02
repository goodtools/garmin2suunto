package cn.lujiawu.app;

import android.app.Application;

import cn.lujiawu.app.settings.SettingManager;

public class SyncApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SettingManager.init(this);

    }
}
