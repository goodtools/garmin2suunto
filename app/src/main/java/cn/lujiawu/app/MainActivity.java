package cn.lujiawu.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import cn.lujiawu.app.fitlist.FitListFragment;
import cn.lujiawu.app.settings.SettingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(FitListFragment.class);

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


    private void loadFragment(Class fragmentClazz) {
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
            return;
        }

        Fragment visibleFragment = getVisibleFragment();
        if (isExist) {
            showAndHideFragment(showFragment, visibleFragment, fragmentTag);
        } else {
            addAndHideFragment(showFragment, visibleFragment, fragmentTag);
        }

    }

    private Fragment createFragment(Class fragmentClazz) {
        try {
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
}
