package com.day0919;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ActViewClassTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewclasstest);
        final EditText input = (EditText) findViewById(R.id.inputBox);
        final EditText input2 = (EditText) findViewById(R.id.inputBox2);

        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);

        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(String.valueOf(input.getText()));
                int num2 = Integer.parseInt(String.valueOf(input2.getText()));
                String result = (num1 + num2) + "";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(String.valueOf(input.getText()));
                int num2 = Integer.parseInt(String.valueOf(input2.getText()));
                String result = (num1 - num2) + "";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(String.valueOf(input.getText()));
                int num2 = Integer.parseInt(String.valueOf(input2.getText()));
                String result = (num1 * num2) + "";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(String.valueOf(input.getText()));
                int num2 = Integer.parseInt(String.valueOf(input2.getText()));
                String result = (num1 / num2) + "";
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean isNumber(String str){

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
