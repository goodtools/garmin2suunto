package cn.lujiawu.garmin2suunto.garmin;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AutoLoginInterceptor implements Interceptor {

    private AutoLogin autoLogin;
    private SimpleCookieJar simpleCookieJar;

    public AutoLoginInterceptor(AutoLogin autoLogin, SimpleCookieJar simpleCookieJar) {
        this.autoLogin = autoLogin;
        this.simpleCookieJar = simpleCookieJar;
    }

    private final String TAG = getClass().getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);

        if (response.code() == 403) {

            simpleCookieJar.clear();

            boolean success = autoLogin.autoLogin(request.url().host());

            if (success) {
                response = chain.proceed(request);
            } else {
                System.err.println("auto login fail! ");
            }
        }

        return response;
    }

}