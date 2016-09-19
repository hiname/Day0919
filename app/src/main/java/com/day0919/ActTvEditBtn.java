package com.day0919;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActTvEditBtn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_edit_btn);
        Button btn = (Button) findViewById(R.id.checkBtn);
        EditText input = (EditText) findViewById(R.id.inputBox);

    }
}
