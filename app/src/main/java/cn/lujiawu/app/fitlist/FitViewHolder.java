package cn.lujiawu.app.fitlist;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FitViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

    public FitViewHolder(View itemView) {
        super(itemView);
        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        menu.add(Menu.NONE, 1, 1, "Edit");
        menu.add(Menu.NONE, 2, 2, "Delete");
    }


}