package com.example.alab.horseracing;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Field extends AppCompatActivity {

    TextView rank;
    int a = 1;
    Field fieldact = this;
    boolean pause = true;

    ImageView horse1;
    ImageView horse2;
    ImageView horse3;
    ImageView horse4;
    ImageView horse5;

    int addmove;
    int move1 =0;
    int move2 =0;
    int move3 =0;
    int move4 =0;
    int move5 =0;

    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        ImageButton button1 = (ImageButton) findViewById(R.id.resultbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Field.this, Score.class);
                startActivity(intent);
                finish();
            }
        });

        rank = (TextView) findViewById(R.id.rankText);
        a = 1;

        horse1 = (ImageView) findViewById(R.id.racehorse1);
        horse2 = (ImageView) findViewById(R.id.racehorse2);
        horse3 = (ImageView) findViewById(R.id.racehorse3);
        horse4 = (ImageView) findViewById(R.id.racehorse4);
        horse5 = (ImageView) findViewById(R.id.racehorse5);

        rand = new Random();
        addmove = rand.nextInt(10)+6;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                fieldact.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pause == true) {
                            a += 1;
                            rank.setText("" + a + horse1.getX());
                            addmove = rand.nextInt(30)+1;
                            move1 += addmove;
                            horse1.setX(move1);
                            if (horse1.getX() > 900){
                                pause = false;
                            }

                            addmove = rand.nextInt(30)+1;
                            move2 += addmove;
                            horse2.setX(move2);
                            if (horse2.getX() > 900){
                                pause = false;
                            }

                            addmove = rand.nextInt(30)+1;
                            move3 += addmove;
                            horse3.setX(move3);
                            if (horse3.getX() > 900){
                                pause = false;
                            }

                            addmove = rand.nextInt(30)+1;
                            move4 += addmove;
                            horse4.setX(move4);
                            if (horse4.getX() > 900){
                                pause = false;
                            }

                            addmove = rand.nextInt(30)+1;
                            move5 += addmove;
                            horse5.setX(move5);
                            if (horse5.getX() > 900){
                                pause = false;
                            }
                        }
                    }
                });
            }
        }, 0, 100);
    }
}

