package servless;

import com.google.gson.Gson;
import com.qcloud.scf.runtime.Context;
import io.reactivex.Observable;

import java.util.List;

/**
 * @author wuzhong
 * servless.Main::sync
 */
public class Main {


    public String test(String arg) {
        return arg + String.valueOf(System.currentTimeMillis());
    }

    public String test2() {
        return "test2" + String.valueOf(System.currentTimeMillis());
    }

    public String sync(Config config, Context context) {

        Observable<String> stringObservable = SyncExecutor.startSyncFlowable(
                config.getGarminUserName(), config.getGarminPasswd(),
                config.getSuuntoUserName(), config.getSuuntoUserKey());

        List<String> strings = stringObservable.toList().blockingGet();

        Gson gson = new Gson();
        return gson.toJson(strings);

    }


}
