package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.GarminConfiguration;
import cn.lujiawu.garmin2suunto.garmin.api.ConnectApi;
import cn.lujiawu.garmin2suunto.move.api.MoveApi;
import cn.lujiawu.garmin2suunto.util.RetrofitHelper;

public class ApiManager {

    public static String suuntoEmail;
    public static String suuntoKey;

    private static ConnectApi garminConnectApi;
    private static MoveApi moveApi;

    public static void init(String email, String key) {
        if (null != garminConnectApi) {
            return;
        }
        garminConnectApi = RetrofitHelper.createApi(GarminConfiguration.GARMIN_CN, ConnectApi.class);
        moveApi = RetrofitHelper.createApi(MoveApi.HOST, MoveApi.class);
        updateSuunto(email, key);
    }

    public static void updateSuunto(String email, String key) {
        suuntoEmail = email;
        suuntoKey = key;
    }

    public static ConnectApi getGarminConnectApi() {
        return garminConnectApi;
    }

    public static MoveApi getMoveApi() {
        return moveApi;
    }
}
