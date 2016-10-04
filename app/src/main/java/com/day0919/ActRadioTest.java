package com.day0919;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by USER on 2016-09-30.
 */

public class ActRadioTest extends AppCompatActivity {

    int checkedId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio);

        RadioGroup rg = (RadioGroup) findViewById(R.id.raiogroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ActRadioTest.this.checkedId = checkedId;
            }
        });

        Button btn = (Button) findViewById(R.id.openBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = null;
                switch(checkedId){
                    case R.id.rbtn1 :
                        intent = new Intent(ActRadioTest.this, ActTest.class);
                        System.out.println("111");
                        break;

                    case R.id.rbtn2 :
                        System.out.println("222");
                        break;
                }
            }
        });
    }

}
