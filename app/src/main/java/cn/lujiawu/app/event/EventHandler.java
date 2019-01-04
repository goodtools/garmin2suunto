package cn.lujiawu.app.event;

public interface EventHandler {

    public void openWebView(String url);

    public void openSettingView();

    public void back();

    public void refreshFitList();

}
