package cn.lujiawu.app.settings;

import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.lujiawu.app.R;
import cn.lujiawu.app.databinding.ContentSettingsBinding;
import cn.lujiawu.app.event.EventHandler;

public class SettingFragment extends Fragment {

    private SettingVO mSettingVO;
    private EventHandler eventHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mSettingVO = SettingManager.getInstance();
        ContentSettingsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.content_settings, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        binding.setSettingVO(mSettingVO);

        view.findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingManager.save(mSettingVO);
                eventHandler.back();
                eventHandler.refreshFitList();
            }
        });

        TextView moveAuthLink = view.findViewById(R.id.move_auth_link);
        moveAuthLink.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        moveAuthLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventHandler.openWebView("http://www.movescount.com/settings#connections");
            }
        });

        return view;

    }


    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
}
