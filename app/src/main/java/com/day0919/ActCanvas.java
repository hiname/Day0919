package com.day0919;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by USER on 2016-09-28.
 */

public class ActCanvas extends AppCompatActivity {

    public static final int LINE = 0, CIRCLE = 1, RECT = 2;
    public int selShape = LINE;

    public CanvasTest ct = null;
    public ArrayList<Shaper> shapeList = new ArrayList<Shaper>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ct = new CanvasTest(this);
        setContentView(ct);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "선");
        menu.add(0, 2, 0, "원");
        menu.add(0, 3, 0, "네모");

        SubMenu submenu = menu.addSubMenu("색상");
        submenu.add(0, 4, 0, "빨강");
        submenu.add(0, 5, 0, "파랑");
        submenu.add(0, 6, 0, "초록");

        menu.add(0, 7, 0, "모두 지우기");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                selShape = LINE;
                Toast.makeText(this, "선", Toast.LENGTH_LONG).show();
                break;

            case 2:
                selShape = CIRCLE;
                Toast.makeText(this, "원", Toast.LENGTH_LONG).show();
                break;

            case 3:
                selShape = RECT;
                Toast.makeText(this, "네모", Toast.LENGTH_LONG).show();
                break;

            case 4:
                ct.setDrawColor(Color.RED);
                break;

            case 5:
                ct.setDrawColor(Color.BLUE);
                break;

            case 6:
                ct.setDrawColor(Color.GREEN);
                break;

            case 7:
                shapeList.clear();
                ct.clear();
                break;
        }

        return false;
    }

    class CanvasTest extends View {

        Paint paint = new Paint();


        RectF rectf = new RectF(160, 250, 300, 400);
        public CanvasTest(Context context) {
            super(context);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5.0f);
            paint.setStyle(Paint.Style.STROKE);


        }

        public void clear() {
            standX = -1;
            standY = -1;
            nowX = -1;
            nowY = -1;
            invalidate();
        }

        boolean chkStartX = false;
        boolean chkStartY = false;

        public void setDrawColor(int color) {
            paint.setColor(color);
        }

        @Override
        protected void onDraw(Canvas c) {
            super.onDraw(c);

            // c.drawCircle(230, 300, 150, paint);
            // c.drawCircle(180, 250, 25, paint2);
            // c.drawCircle(280, 250, 25, paint2);
            // c.drawArc(rectf, 0, 180, false, paint2);
            // c.drawArc(180, 250, 280, 400, 0, 180, false, paint2);

            // c.drawLine(standX, standY, nowX, nowY, paint2);

            for(int i = 0; i < shapeList.size(); i++){
                float startX = shapeList.get(i).startX;
                float startY = shapeList.get(i).startY;
                float endX = shapeList.get(i).endX;
                float endY = shapeList.get(i).endY;
                drawShape(c, shapeList.get(i).shape, startX, startY, endX, endY, shapeList.get(i).paint);
            }

            drawShape(c, selShape, standX, standY, nowX, nowY, paint);

        }

        public void drawShape(Canvas c, int shape, float standX, float standY, float nowX, float nowY, Paint paint) {

            switch(shape) {
                case LINE:
                    c.drawLine(standX, standY, nowX, nowY, paint);
                    break;

                case CIRCLE:
                    float calcX = (float) Math.pow((standX - nowX), 2);
                    float calcY = (float) Math.pow((standY - nowY), 2);
                    float radius = (float) Math.sqrt((calcX + calcY));
                    c.drawCircle(standX, standY, radius, paint);
                    break;

                case RECT:
                    float startX = standX, startY = standY;
                    float endX = nowX, endY = nowY;

                    if (standX > nowX) {
                        startX = nowX;
                        endX = standX;
                    }

                    if (standY > nowY) {
                        startY = nowY;
                        endY = standY;
                    }

                    c.drawRect(startX, startY, endX, endY, paint);
                    break;
            }
        }

        float standX = 0, standY = 0;
        float nowX = 0, nowY = 0;

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            int action = event.getAction();
            switch(action) {
                case MotionEvent.ACTION_DOWN:
                    standX = event.getX();
                    standY = event.getY();
                    nowX = event.getX();
                    nowY = event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    nowX = event.getX();
                    nowY = event.getY();
                    break;

                case MotionEvent.ACTION_UP:
                    Paint tmpPaint = new Paint();
                    tmpPaint.setColor(paint.getColor());
                    tmpPaint.setStrokeWidth(paint.getStrokeWidth());
                    tmpPaint.setStyle(paint.getStyle());
                    shapeList.add(new Shaper(selShape, standX, standY, nowX, nowY, tmpPaint));
                    break;
            }

            invalidate();
            return true;
        }

    }

    class Shaper {
        int shape;
        float startX, startY;
        float endX, endY;
        Paint paint;

        public Shaper(int shape, float startX, float startY, float endX, float endY, Paint paint) {
            this.shape = shape;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.paint = paint;
        }
    }
}
