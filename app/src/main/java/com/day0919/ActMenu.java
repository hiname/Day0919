package com.day0919;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class ActMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);

        menu.add(0, 1,  0, "빨강");
        menu.add(0, 2,  0, "빨강");
        menu.add(0, 3,  0, "빨강");

        SubMenu sm = menu.addSubMenu("");
        sm.add("1");
        sm.add("2");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        // int itemId = item.getItemId();
        // Log.e("", "featureId : " + featureId + ", " + itemId);
        // Log.i("", "i");
        // Log.d("", "d");
        // Log.v("", "v");
        // Log.w("", "w");
        return super.onMenuOpened(featureId, menu);
    }
}
