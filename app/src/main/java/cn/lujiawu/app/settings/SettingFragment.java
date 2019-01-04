package cn.lujiawu.app.settings;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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

                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

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
