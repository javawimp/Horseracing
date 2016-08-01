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

    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;
    int seedMoney = 0;

    int winner = 0;

    double winrate1 = 0;
    double winrate2 = 0;
    double winrate3 = 0;
    double winrate4 = 0;
    double winrate5 = 0;

    double grossRate = 0;

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

        winrate1 = bundle.getDouble("OneRate");
        winrate2 = bundle.getDouble("TwoRate");
        winrate3 = bundle.getDouble("ThreeRate");
        winrate4 = bundle.getDouble("FourRate");
        winrate5 = bundle.getDouble("FiveRate");

        grossRate = winrate1 + winrate2 + winrate3 + winrate4 + winrate5;

        if(grossRate == 0)
            grossRate = 1;

                seedMoney = bundle.getInt("HorseSeed");

        resultbt = (ImageButton) findViewById(R.id.resultbutton);
        resultbt.setX(2000);
        resultbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Field.this, Score.class);

                intent.putExtra("HorseOneRe",value1);
                intent.putExtra("HorseTwoRe",value2);
                intent.putExtra("HorseThreeRe",value3);
                intent.putExtra("HorseFourRe",value4);
                intent.putExtra("HorseFiveRe",value5);
                intent.putExtra("HorseSeedM",seedMoney);

                intent.putExtra("FOneRate",winrate1);
                intent.putExtra("FTwoRate",winrate2);
                intent.putExtra("FThreeRate",winrate3);
                intent.putExtra("FFourRate",winrate4);
                intent.putExtra("FFiveRate",winrate5);

                intent.putExtra("Winner",winner);

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
        rank.setText("\n" + "  No.1" + "\n" +"  No.2" + "\n" +"  No.3" + "\n" + "  No.4" + "\n" + "  No.5");

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

                                    if(rankNum == 0) {
                                        value1 = value1 * (25/10 + (int)((100 - winrate1 / grossRate * 100) * 0.01));
                                        winrate1++;
                                        winner = 1;
                                    }
                                    else if(rankNum == 1)
                                        value1 = value1 * (15/10 + (int)((100 - winrate1 / grossRate * 100) * 0.01));
                                    else if(rankNum == 2)
                                        value1 = value1 * (5/10 + (int)((100 - winrate1 / grossRate * 100) * 0.01));
                                    else if(rankNum == 3)
                                        value1 = value1 * (2/10 + (int)((100 - winrate1 / grossRate * 100) * 0.01));
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

                                    if(rankNum == 0){
                                        value2 = value2 * (25/10 + (int)((100 - winrate2 / grossRate * 100) * 0.01));
                                        winrate2++;
                                        winner = 2;
                                    }
                                    else if(rankNum == 1)
                                        value2 = value2 * (15/10 + (int)((100 - winrate2 / grossRate * 100) * 0.01));
                                    else if(rankNum == 2)
                                        value2 = value2 * (5/10 + (int)((100 - winrate2 / grossRate * 100) * 0.01));
                                    else if(rankNum == 3)
                                        value2 = value2 * (2/10 + (int)((100 - winrate2 / grossRate * 100) * 0.01));
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

                                    if(rankNum == 0){
                                        value3 = value3 * (25/10 + (int)((100 - winrate3 / grossRate * 100) * 0.01));
                                        winrate3++;
                                        winner = 3;
                                    }
                                    else if(rankNum == 1)
                                        value3 = value3 * (15/10 + (int)((100 - winrate3 / grossRate * 100) * 0.01));
                                    else if(rankNum == 2)
                                        value3 = value3 * (5/10 + (int)((100 - winrate3 / grossRate * 100) * 0.01));
                                    else if(rankNum == 3)
                                        value3 = value3 * (2/10 + (int)((100 - winrate3 / grossRate * 100) * 0.01));
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

                                    if(rankNum == 0){
                                        value4 = value4 * (25/10 + (int)((100 - winrate4 / grossRate * 100) * 0.01));
                                        winrate4++;
                                        winner = 4;
                                     }
                                    else if(rankNum == 1)
                                        value4 = value4 * (15/10 + (int)((100 - winrate4 / grossRate * 100) * 0.01));
                                    else if(rankNum == 2)
                                        value4 = value4 * (5/10 + (int)((100 - winrate4 / grossRate * 100) * 0.01));
                                    else if(rankNum == 3)
                                        value4 = value4 * (2/10 + (int)((100 - winrate4 / grossRate * 100) * 0.01));
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

                                    if(rankNum == 0){
                                        value5 = value5 * (25/10 + (int)((100 - winrate5 / grossRate * 100) * 0.01));
                                        winrate5++;
                                        winner = 5;
                                    }
                                    else if(rankNum == 1)
                                        value5 = value5 * (15/10 + (int)((100 - winrate5 / grossRate * 100) * 0.01));
                                    else if(rankNum == 2)
                                        value5 = value5 * (5/10 + (int)((100 - winrate5 / grossRate * 100) * 0.01));
                                    else if(rankNum == 3)
                                        value5 = value5 * (2/10 + (int)((100 - winrate5 / grossRate * 100) * 0.01));
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
                                rank.setText("\n" + "  No.1:  " +  value1  + "\n" +"  No.2:  " +  value2 + "\n" + "  No.3:  " +  value3 + "\n" + "  No.4:  " +  value4 + "\n" + "  No.5:  " +  value5);
                            }

                        }
                    }
                });
            }
        }, 0, 50);
    }
}

