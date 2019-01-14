package servless;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;
import io.reactivex.Observable;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author wuzhong
 * servless.Main::sync
 */
public class AliyunMain implements StreamRequestHandler {

    public String sync() {

        String garminUserName = System.getenv("garminUserName");
        String garminPasswd = System.getenv("garminPasswd");
        String suuntoUserName = System.getenv("suuntoUserName");
        String suuntoUserKey = System.getenv("suuntoUserKey");

        System.out.println(garminUserName);

        Observable<String> stringObservable = SyncExecutor.startSyncFlowable(
                garminUserName, garminPasswd,
                suuntoUserName, suuntoUserKey);

        List<String> strings = stringObservable.toList().blockingGet();

        return StringUtils.join(strings, "\r\n");

    }


    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        outputStream.write(sync().getBytes());
    }
}
