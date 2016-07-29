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
    ImageView lineEnd;

    int addmove;
    int move1 = 0;
    int move2 = 0;
    int move3 = 0;
    int move4 = 0;
    int move5 = 0;

    double value1 = 0;
    double value2 = 0;
    double value3 = 0;
    double value4 = 0;
    double value5 = 0;

    Random rand;

    String [] rankSt = new String[5];
    int rankNum= 0;

    ImageButton startbt;
    ImageButton resultbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        pause = false;
//        rankSt[5] = new String();

        Bundle bundle = getIntent().getExtras();
        value1 = bundle.getInt("HorseOne");   //horse 1
        value2 = bundle.getInt("HorseTwo");   //horse 2
        value3 = bundle.getInt("HorseThree"); //horse 3
        value4 = bundle.getInt("HorseFour");  //horse 4
        value5 = bundle.getInt("HorseFive");  //horse 5

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
                startbt.setX(2500);
            }
        });

        rank = (TextView) findViewById(R.id.rankText);
        rank.setText("\n" + "  1st" + "\n" +"  2nd"+ "\n" +"  3rd" + "\n" + "  4th"+ "\n" + "  5th");

        a = 1;

        horse1 = (ImageView) findViewById(R.id.racehorse1);
        horse2 = (ImageView) findViewById(R.id.racehorse2);
        horse3 = (ImageView) findViewById(R.id.racehorse3);
        horse4 = (ImageView) findViewById(R.id.racehorse4);
        horse5 = (ImageView) findViewById(R.id.racehorse5);
        lineEnd = (ImageView) findViewById(R.id.endLine);

        lineEnd.setX(900);

        rand = new Random();
        addmove = rand.nextInt(101) + 5;


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                fieldact.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pause == true) {
                            addmove = rand.nextInt(20) + 1;
                            move1 += addmove;
                            horse1.setX(move1);
                            if (ho1 == false) {
                                if (horse1.getX() > 900) {
                                    horse1.setX(900);
                                    ho1 = true;
                                    rankSt[rankNum] = "Horse 01";

                                    if(rankNum == 0)
                                        value1 = value1 * 2;
                                    else if(rankNum == 1)
                                        value1 = value1 * 0.7;
                                    else if(rankNum == 2)
                                        value1 = value1 * 0.3;
                                    else if(rankNum == 3)
                                        value1 = value1 * 0.1;
                                    else if(rankNum == 4)
                                        value1 = 0;

                                    rankNum++;
                                }
                            }else if(horse1.getX() > 900){
                                horse1.setX(900);
                            }

                            addmove = rand.nextInt(20) + 1;
                            move2 += addmove;
                            horse2.setX(move2);
                            if (ho2 == false) {
                                if (horse2.getX() > 900) {
                                    horse2.setX(900);
                                    ho2 = true;
                                    rankSt[rankNum] = "Horse 02";

                                    if(rankNum == 0)
                                        value2 = value2 * 2;
                                    else if(rankNum == 1)
                                        value2 = value2 * 0.7;
                                    else if(rankNum == 2)
                                        value2 = value2 * 0.3;
                                    else if(rankNum == 3)
                                        value2 = value2 * 0.1;
                                    else if(rankNum == 4)
                                        value2 = 0;

                                    rankNum++;
                                }
                            }else if(horse2.getX() > 900){
                                horse2.setX(900);
                            }

                            addmove = rand.nextInt(20) + 1;
                            move3 += addmove;
                            horse3.setX(move3);
                            if (ho3 == false) {
                                if (horse3.getX() > 900) {
                                    horse3.setX(900);
                                    ho3 = true;
                                    rankSt[rankNum] = "Horse 03";

                                    if(rankNum == 0)
                                        value3 = value3 * 2;
                                    else if(rankNum == 1)
                                        value3 = value3 * 0.7;
                                    else if(rankNum == 2)
                                        value3 = value3 * 0.3;
                                    else if(rankNum == 3)
                                        value3 = value3 * 0.1;
                                    else if(rankNum == 4)
                                        value3 = 0;

                                    rankNum++;
                                }
                            }else if(horse3.getX() > 900){
                                horse3.setX(900);
                            }

                            addmove = rand.nextInt(20) + 1;
                            move4 += addmove;
                            horse4.setX(move4);
                            if (ho4 == false) {
                                if (horse4.getX() > 900) {
                                    horse4.setX(900);
                                    ho4 = true;
                                    rankSt[rankNum] = "Horse 04";

                                    if(rankNum == 0)
                                        value4 = value4 * 2;
                                    else if(rankNum == 1)
                                        value4 = value4 * 0.7;
                                    else if(rankNum == 2)
                                        value4 = value4 * 0.3;
                                    else if(rankNum == 3)
                                        value4 = value4 * 0.1;
                                    else if(rankNum == 4)
                                        value4 = 0;

                                    rankNum++;
                                }
                            }else if(horse4.getX() > 900){
                                horse4.setX(900);
                            }

                            addmove = rand.nextInt(20) + 1;
                            move5 += addmove;
                            horse5.setX(move5);
                            if (ho5 == false) {
                                if (horse5.getX() > 900) {
                                    horse5.setX(900);
                                    ho5 = true;
                                    rankSt[rankNum] = "Horse 05";

                                    if(rankNum == 0)
                                        value5 = value5 * 2;
                                    else if(rankNum == 1)
                                        value5 = value5 * 0.7;
                                    else if(rankNum == 2)
                                        value5 = value5 * 0.3;
                                    else if(rankNum == 3)
                                        value5 = value5 * 0.1;
                                    else if(rankNum == 4)
                                        value5 = 0;

                                    rankNum++;
                                }
                            }else if(horse5.getX() > 900){
                                horse5.setX(900);
                            }

                            if(ho1 == true && ho2 == true && ho3 == true && ho4 == true && ho5 == true){
                                pause = false;
                                resultbt.setX(1050);
                                //rank.setText("\n" + "  1st:   " + rankSt[0] + "\n" +"  2nd:  "+ rankSt[1]+ "\n" + "  3rd:   " + rankSt[2]+ "\n" + "  4th:   "+rankSt[3] + "\n" + "  5th:   " + rankSt[4]);
                                rank.setText("\n" + "  1st:   " + value1 + "\n" +"  2nd:  "+ value2+ "\n" + "  3rd:   " + value3+ "\n" + "  4th:   "+value4 + "\n" + "  5th:   " + value5);
                            }
                        }
                    }
                });
            }
        }, 0, 50);
    }
}

