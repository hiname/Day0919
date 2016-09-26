package com.day0919;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        final Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("log", "log");
                test2();
            }
        });

    }

    public void test1() {
        final Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder adlg = new AlertDialog.Builder(ActDialog.this);
//                adlg.setTitle("타이틀");
//                adlg.setMessage("메세지");
//                adlg.setIcon(R.mipmap.ic_launcher);
//                adlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "확인 클릭", Toast.LENGTH_LONG).show();
//                    }
//                });
//                adlg.show();

                final String arr[] = {"a0", "a1", "a2"};
                new AlertDialog.Builder(ActDialog.this)
                        .setTitle("타이틀")
                        // .setMessage("메세지")
                        .setIcon(R.mipmap.ic_launcher)
//                        .setItems(arr, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                btn1.setText(arr[which]);
//                            }
//                        })
                        .setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btn1.setText(arr[which]);
                            }
                        })

                        // .setMultiChoiceItems(arr, new boolean[]{true})
                        // .setMultiChoiceItems()

                        .setPositiveButton("닫기", null)
                        .show();
            }
        });
    }

    public void test2() {
        AlertDialog.Builder adlg = new AlertDialog.Builder(this);
        adlg.setTitle("타이틀");
        adlg.setMessage("메세지");

        adlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast to = new Toast(ActDialog.this);
                View toastView = (View) View.inflate(ActDialog.this, R.layout.toastview, null);
                toastView.setBackgroundColor(Color.RED);
                Button btn = (Button) toastView.findViewById(R.id.btn1toas);
                btn.setText("취소");
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "누름", Toast.LENGTH_LONG).show();
                    }
                });
                to.setView(toastView);
                to.show();
            }
        });

        adlg.show();
    }
}
