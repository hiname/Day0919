package com.day0919;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActCJ extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn1;
    int num = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // MenuInflater mInflater = getMenuInflater();
        // mInflater.inflate(R.menu.menu1,menu);
        menu.add(0, 1, 0, "메뉴1");
        menu.add(0, 2, 0, "메뉴2");
        menu.add(0, 3, 0, "메뉴3");

        SubMenu smenu = menu.addSubMenu("서브");
        smenu.add(0, 4, 0, "서브 내 1");
        smenu.add(0, 5, 0, "서브 내 2");

        int positionOfMenuItem = 0; // or whatever...
        MenuItem item = smenu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString(item.getTitle());
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
        item.setTitle(s);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setTitle("XML없이 컨텍스트");
        // baseLayout = (LinearLayout) findViewById(R.id.linear);
        // btn1 = (Button) findViewById(R.id.btn);
    }
}

