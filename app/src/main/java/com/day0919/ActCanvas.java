package com.day0919;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by USER on 2016-09-28.
 */

public class ActCanvas extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CanvasTest(this));

    }

    class CanvasTest extends View {

        Paint paint = new Paint();
        Paint paint2 = new Paint();
        RectF rectf = new RectF(160, 250, 300, 400);
        public CanvasTest(Context context) {
            super(context);
            paint.setColor(Color.YELLOW);
            paint2.setColor(Color.BLACK);
            paint2.setStrokeWidth(5.0f);
            paint2.setStyle(Paint.Style.STROKE);
        }

        boolean chkStartX = false;
        boolean chkStartY = false;

        @Override
        protected void onDraw(Canvas c) {
            super.onDraw(c);

            // c.drawCircle(230, 300, 150, paint);
            // c.drawCircle(180, 250, 25, paint2);
            // c.drawCircle(280, 250, 25, paint2);
            // c.drawArc(rectf, 0, 180, false, paint2);
            // c.drawArc(180, 250, 280, 400, 0, 180, false, paint2);

            // c.drawLine(startX, startY, endX, endY, paint2);

            if (startX > endX && !chkStartX) {
                chkStartX = true;
                startX = endX;
            }


            c.drawRect(startX, startY, endX, endY, paint2);

        }

        float startX = 0, startY = 0;
        float endX = 0, endY = 0;

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();
            switch(action) {
                case MotionEvent.ACTION_DOWN:
                    startX = event.getX();
                    startY = event.getY();
                    endX = event.getX();
                    endY = event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    endX = event.getX();
                    endY = event.getY();
                    break;

                case MotionEvent.ACTION_UP:
                    break;


            }
            invalidate();
            return true;
        }
    }
}
