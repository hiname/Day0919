package com.day0919;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ActTetris extends AppCompatActivity {
    FrameLayout playScr = null;

    int way[][] = new int[10][10];

    View tile[][] = new View[10][10];

    int[] userPos = new int[2];

    public void initialTile() {
        way[0][0] = 1;
        way[1][0] = 1;
        way[2][0] = 1;
        way[3][0] = 1;
        way[3][1] = 1;
        way[3][2] = 1;
        way[3][3] = 1;
        way[3][4] = 1;
        way[4][4] = 1;
        way[5][4] = 1;
        way[6][4] = 1;
        way[6][5] = 1;
        way[6][6] = 1;
        way[6][7] = 1;
        way[6][8] = 1;
        way[6][9] = 1;
        way[7][9] = 1;
        way[8][9] = 1;
        way[9][9] = 1;

        tileReady();
        tilePlank();

    }

    public void tileReady() {
        for (int i = 0; i < way.length; i++)
            for (int j = 0; j < way[i].length; j++)
                tile[i][j] = new View(this);
    }

    public void tilePlank() {
        for (int i = 0; i < way.length; i++) {
            for (int j = 0; j < way[i].length; j++) {
                int tileColor = Color.BLACK;
                if (way[j][i] == 1)
                    tileColor = Color.WHITE;

                tile[i][j].setBackgroundColor(tileColor);
            }
        }
    }

    ImageView user = null;
    int tenWidth, tenHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tetris_main);

        initialTile();
        playScr = (FrameLayout) findViewById(R.id.playscreen);

        playScr.post(new Runnable() {
            @Override
            public void run() {
                tenWidth = (int) (playScr.getWidth() / 10);
                tenHeight = (int) (playScr.getHeight() / 10);

                for (int i = 0; i < tile.length; i++) {
                    for (int j = 0; j < tile[i].length; j++) {
                        View nowTile = tile[i][j];
                        FrameLayout.LayoutParams flParam = new FrameLayout.LayoutParams(tenWidth, tenHeight);
                        flParam.leftMargin = i * tenWidth;
                        flParam.topMargin = j * tenHeight;
                        nowTile.setLayoutParams(flParam);
                        playScr.addView(nowTile);
                    }
                }

                leftBtn = (ImageView) findViewById(R.id.leftarrow);
                rightBtn = (ImageView) findViewById(R.id.rightarrow);
                upBtn = (ImageView) findViewById(R.id.uparrow);
                downBtn = (ImageView) findViewById(R.id.downarrow);

                leftBtn.setOnTouchListener(otl);
                rightBtn.setOnTouchListener(otl);
                upBtn.setOnTouchListener(otl);
                downBtn.setOnTouchListener(otl);

                user = new ImageView(ActTetris.this);
                // user.setBackgroundColor(Color.GREEN);
                user.setBackgroundResource(R.mipmap.ic_launcher);
                Log.w("size", "tenWidth : " + tenWidth + ", tenHeight : " + tenHeight);
                FrameLayout.LayoutParams userParam = new FrameLayout.LayoutParams(tenWidth, tenHeight);
                userParam.leftMargin = 0;
                userParam.topMargin = 0;
                user.setLayoutParams(userParam);
                playScr.addView(user);

            }
        });


    }

    ImageView lastBtn = null;

    View.OnTouchListener otl = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            System.out.println("action : " + action);

            if (action == MotionEvent.ACTION_DOWN) {
                clicking = true;
                lastBtn = (ImageView) v;
                handle(v);
                v.setBackgroundColor(Color.RED);
            } else if (action == MotionEvent.ACTION_UP) {
                clicking = false;
                v.setBackgroundColor(Color.TRANSPARENT);
            }
            return true;
        }
    };

    FrameLayout.LayoutParams userParam = null;

    int moveLeft = 0;
    int moveTop = 0;
    boolean aning = false;
    boolean clicking = false;
    TranslateAnimation ani = null;

    public void handle(View v) {
        userParam = (FrameLayout.LayoutParams) user.getLayoutParams();
        int posLeft = 0;
        int posTop = 0;

        moveLeft = 0;
        moveTop = 0;

        if (v == leftBtn) {
            posLeft = -1;
            moveLeft = -tenWidth;
        } else if (v == rightBtn) {
            posLeft = +1;
            moveLeft = +tenWidth;
        } else if (v == upBtn) {
            posTop = -1;
            moveTop = -tenHeight;
        } else if (v == downBtn) {
            posTop = +1;
            moveTop = +tenHeight;
        }

        int tmpCol = userPos[1] + posLeft;
        int tmpRow = userPos[0] + posTop;

        if ((0 <= tmpRow && tmpRow < way.length)
                && (0 <= tmpCol && tmpCol < way[tmpRow].length)
                && way[tmpRow][tmpCol] == 1
                && !aning) {

            ani = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, userPos[1],
                    Animation.RELATIVE_TO_SELF, tmpCol,
                    Animation.RELATIVE_TO_SELF, userPos[0],
                    Animation.RELATIVE_TO_SELF, tmpRow);

            ani.setFillAfter(true);
            ani.setFillEnabled(true);
            ani.setStartOffset(0);
            ani.setStartTime(0);
            ani.setDuration(250);


            ani.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    aning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    aning = false;
                    if (clicking) handle(lastBtn);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            ani.setInterpolator(new LinearInterpolator());
            user.startAnimation(ani);

            aning = true;

            // userParam.leftMargin += moveLeft;
            // userParam.topMargin += moveTop;

            // user.setLayoutParams(userParam);


            userPos[0] = tmpRow;
            userPos[1] = tmpCol;

        }
    }
    int cnt = 0;

    final Handler handler = new Handler() {
        public void handleMessage(Message msg){
            if (cnt++ < 15) {
                anii();

                try {Thread.sleep(66);} catch (InterruptedException e) {}

                new Thread() {
                    public void run() {
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                }.start();
            }

        }
    };


    public ImageView leftBtn, rightBtn, upBtn, downBtn;

    public void anii() {
        userParam.leftMargin += (moveLeft / 14);
        userParam.topMargin += (moveTop / 14);

        user.setLayoutParams(userParam);


    }

    class Anim extends Thread {
        int moveLeft = 0;
        int moveTop = 0;

        public Anim(int moveLeft, int moveTop) {
            this.moveLeft = moveLeft;
            this.moveTop = moveTop;
        }

        @Override
        public void run() {
            super.run();


        }
    }

}
