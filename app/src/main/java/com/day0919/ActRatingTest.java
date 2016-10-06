package com.day0919;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 2016-10-04.
 */

public class ActRatingTest extends AppCompatActivity {

    ImageView[] imgView = new ImageView[9];
    TextView[] voteView = new TextView[9];

    int[] voteCnt = new int[9];
    final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
            "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
            "해변에서" };

    final int[] voteTvId = {
            R.id.vote1,
            R.id.vote2,
            R.id.vote3,
            R.id.vote4,
            R.id.vote5,
            R.id.vote6,
            R.id.vote7,
            R.id.vote8,
            R.id.vote9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        int[] imgId = {
                R.id.img1,
                R.id.img2,
                R.id.img3,
                R.id.img4,
                R.id.img5,
                R.id.img6,
                R.id.img7,
                R.id.img8,
                R.id.img9,
        };

        //

        for (int i = 0; i < imgId.length; i++) {
            final int index = i;
            imgView[i] = (ImageView) findViewById(imgId[i]);
            voteView[i] = (TextView) findViewById(voteTvId[i]);

            imgView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCnt[index]++;
                    voteView[index].setText(voteCnt[index] + "");
                    Toast.makeText(ActRatingTest.this, imgName[index] + " " + voteCnt[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });


        }

        Button btn = (Button) findViewById(R.id.voteBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteResult();
            }
        });


    }

    public void voteResult() {
        Intent intent = new Intent(this, ActRatingResult.class);
        intent.putExtra("imgName", imgName);
        intent.putExtra("voteCnt", voteCnt);
        startActivity(intent);
    }
}
