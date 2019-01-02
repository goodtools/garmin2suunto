package cn.lujiawu.app.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.lujiawu.app.R;
import cn.lujiawu.app.databinding.ContentSettingsBinding;

public class SettingFragment extends Fragment implements View.OnClickListener {

    private SettingVO mSettingVO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mSettingVO = SettingManager.getInstance();
        ContentSettingsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.content_settings, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        binding.setSettingVO(mSettingVO);

        view.findViewById(R.id.save_btn).setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View view) {
        SettingManager.save(mSettingVO);
    }
}
