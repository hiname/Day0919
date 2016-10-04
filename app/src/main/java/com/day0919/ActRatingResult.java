package com.day0919;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by USER on 2016-10-04.
 */

public class ActRatingResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingresult);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCnt");
        String[] imageName = intent.getStringArrayExtra("imgName");

        int[] picList = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9,};

        int maxValue = -999;
        int maxIdx = -1;

        for (int i = 0; i < voteResult.length; i++) {
            if (maxValue < voteResult[i]) {
                maxValue = voteResult[i];
                maxIdx = i;
            }
        }

        ((ImageView) findViewById(R.id.ivTop)).setImageResource(picList[maxIdx]);
        ((TextView) findViewById(R.id.tvTop)).setText(imageName[maxIdx]);

        int[] tvList = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9,};
        for (int i = 0; i < tvList.length; i++) ((TextView) findViewById(tvList[i])).setText(imageName[i]);

        int[] rbList = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9,};
        for (int i = 0; i < tvList.length; i++) ((RatingBar) findViewById(rbList[i])).setRating(voteResult[i]);

        ((Button) findViewById(R.id.btnReturn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
