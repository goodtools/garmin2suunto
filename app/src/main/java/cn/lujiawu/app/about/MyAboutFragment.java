package cn.lujiawu.app.about;

import android.content.Context;

import com.danielstone.materialaboutlibrary.MaterialAboutFragment;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import androidx.core.content.ContextCompat;
import cn.lujiawu.app.R;

public class MyAboutFragment extends MaterialAboutFragment {

    private MaterialAboutActionItem createDynamicItem(String subText, final Context c) {
        final MaterialAboutActionItem item = new MaterialAboutActionItem.Builder()
                .text("Dynamic UI")
                .subText(subText)
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_refresh)
                        .color(ContextCompat.getColor(c, R.color.mal_color_icon_light_theme)
                        ).sizeDp(18))
                .build();
        item.setOnClickAction(new MaterialAboutItemOnClickAction() {
            @Override
            public void onClick() {
                item.setSubText("Random number: " + ((int) (Math.random() * 10)));
                refreshMaterialAboutList();
            }
        });
        return item;

    }

    public static final int THEME_LIGHT_LIGHTBAR = 0;
    public static final int THEME_LIGHT_DARKBAR = 1;
    public static final int THEME_DARK_LIGHTBAR = 2;
    public static final int THEME_DARK_DARKBAR = 3;
    public static final int THEME_CUSTOM_CARDVIEW = 4;

    @Override
    protected MaterialAboutList getMaterialAboutList(final Context c) {

        MaterialAboutList list = MyAbouts.createMaterialAboutList(c, R.color.mal_color_icon_light_theme, 0);

        return list;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected int getTheme() {
        return R.style.AppTheme_MaterialAboutActivity_Light;
    }
}
