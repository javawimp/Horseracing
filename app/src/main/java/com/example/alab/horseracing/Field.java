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

    boolean pause;
    boolean ho1 = false;
    boolean ho2 = false;
    boolean ho3 = false;
    boolean ho4 = false;
    boolean ho5 = false;
    boolean arrive = false;

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

    ImageButton startbt;
    ImageButton resultbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        pause = false;

        resultbt = (ImageButton) findViewById(R.id.resultbutton);
        resultbt.setX(2000);
        resultbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Field.this, Score.class);
                startActivity(intent);
                finish();
            }
        });

        startbt = (ImageButton) findViewById(R.id.startbutton1);
        startbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pause = true;
                startbt.setX(2000);
            }
        });

        rank = (TextView) findViewById(R.id.rankText);
        rank.setText("  1st" +"\n" +"  2nd"+"\n" +"  3rd"+"\n" +"  4th"+"\n" +"  5th");

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
                            addmove = rand.nextInt(30)+1;
                            move1 += addmove;
                            horse1.setX(move1);
                            if (horse1.getX() > 900){
                                horse1.setX(900);
                                ho1 = true;
                            }

                            addmove = rand.nextInt(30)+1;
                            move2 += addmove;
                            horse2.setX(move2);
                            if (horse2.getX() > 900){
                                horse2.setX(900);
                                ho2 = true;
                            }

                            addmove = rand.nextInt(30)+1;
                            move3 += addmove;
                            horse3.setX(move3);
                            if (horse3.getX() > 900){
                                horse3.setX(900);
                                ho3 = true;
                            }

                            addmove = rand.nextInt(30)+1;
                            move4 += addmove;
                            horse4.setX(move4);
                            if (horse4.getX() > 900){
                                horse4.setX(900);
                                ho4 = true;
                            }

                            addmove = rand.nextInt(30)+1;
                            move5 += addmove;
                            horse5.setX(move5);
                            if (horse5.getX() > 900){
                                horse5.setX(900);
                                ho5 = true;
                            }
                            if(ho1 == true &&ho2 == true &&ho3 == true &&ho4 == true &&ho5 == true){
                                pause = false;
                                resultbt.setX(1050);
                            }
                        }
                    }
                });
            }
        }, 0, 100);
    }
}

