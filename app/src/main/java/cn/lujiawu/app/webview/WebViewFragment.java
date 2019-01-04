package cn.lujiawu.app.webview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;
import cn.lujiawu.app.R;

public class WebViewFragment extends Fragment {

    public WebView mWebView;
    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        WebView.setWebContentsDebuggingEnabled(true);

        View fragmentView = inflater.inflate(R.layout.content_webview, container, false);

        mWebView = (WebView) fragmentView.findViewById(R.id.webview);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAllowContentAccess(true);

        // Force links and redirects to open in the WebView instead of in a browser
//        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());

        if (!TextUtils.isEmpty(url)) {
            mWebView.loadUrl(url);
        }

        return fragmentView;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        if (!TextUtils.isEmpty(url)) {
//            mWebView.loadUrl(url);
//        }
//    }

    public void openUrl(String url) {
        this.url = url;
        if (null != mWebView) {
            mWebView.loadUrl(url);
        }
    }


}
