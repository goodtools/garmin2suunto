package cn.lujiawu.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import cn.lujiawu.app.about.MyAboutFragment;
import cn.lujiawu.app.event.EventHandler;
import cn.lujiawu.app.fitlist.FitListFragment;
import cn.lujiawu.app.settings.SettingFragment;

public class MainActivity extends AppCompatActivity implements EventHandler {

    FitListFragment fitListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fitListFragment = loadFragment(FitListFragment.class);
//        fitListFragment.eventHandler = this;
        loadFragment(MyAboutFragment.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        //force to enter settings
//        loadFragment(SettingFragment.class);
//        return false;
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            loadFragment(SettingFragment.class);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private <T> T loadFragment(Class<T> fragmentClazz) {
        String fragmentTag = fragmentClazz.getSimpleName();
        Fragment showFragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        boolean isExist = true;
        if (showFragment == null) {
            isExist = false;
            showFragment = createFragment(fragmentClazz);
        }
        if (showFragment == null) {
            throw new RuntimeException("fragment not exist " + fragmentClazz.getName());
        }
        if (showFragment.isVisible()) {
            return (T) showFragment;
        }
        Fragment visibleFragment = getVisibleFragment();
        if (isExist) {
            showAndHideFragment(showFragment, visibleFragment, fragmentTag);
        } else {
            addAndHideFragment(showFragment, visibleFragment, fragmentTag);
        }
        return (T) showFragment;
    }

    private Fragment createFragment(Class fragmentClazz) {
        try {
            if (fragmentClazz == SettingFragment.class) {
                SettingFragment settingFragment = new SettingFragment();
                settingFragment.setEventHandler(this);
                return settingFragment;
            }
            return (Fragment) fragmentClazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private Fragment getVisibleFragment() {
        @SuppressLint("RestrictedApi")
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList != null) {
            for (Fragment fragment : fragmentList) {
                if (fragment != null && fragment.isVisible()) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void showAndHideFragment(@NonNull Fragment showFragment, @Nullable Fragment hideFragment, String tagName) {
        if (hideFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(showFragment)
                    .addToBackStack(tagName)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(showFragment)
                    .addToBackStack(tagName)
                    .hide(hideFragment)
                    .commit();
        }

    }

    private void addAndHideFragment(@NonNull Fragment showFragment,
                                    @Nullable Fragment hideFragment, @NonNull String addTag) {
        if (hideFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_layout_content, showFragment, addTag)
//                    .addToBackStack(addTag)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_layout_content, showFragment, addTag)
                    .addToBackStack(addTag)
                    .hide(hideFragment)
                    .commit();
        }
    }

    @Override
    public void openWebView(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void openSettingView() {
        loadFragment(SettingFragment.class);
    }

    @Override
    public void back() {
        this.onBackPressed();
    }

    @Override
    public void refreshFitList() {
        this.fitListFragment.startup();
    }
}
