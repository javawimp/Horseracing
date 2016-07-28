package com.example.alab.horseracing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Horseselect extends AppCompatActivity {
    int moneyText1 = 0;
    int moneyText2 = 0;
    int moneyText3 = 0;
    int moneyText4 = 0;
    int moneyText5 = 0;

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;

    TextView seedText;

    int seedM = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horseselect);

        ImageButton button2 = (ImageButton) findViewById(R.id.nextbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Horseselect.this, Field.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton plus1 = (ImageButton) findViewById(R.id.plusbutton1);
        ImageButton plus2 = (ImageButton) findViewById(R.id.plusbutton2);
        ImageButton plus3 = (ImageButton) findViewById(R.id.plusbutton3);
        ImageButton plus4 = (ImageButton) findViewById(R.id.plusbutton4);
        ImageButton plus5 = (ImageButton) findViewById(R.id.plusbutton5);

        ImageButton min1 = (ImageButton) findViewById(R.id.minusbutton1);
        ImageButton min2 = (ImageButton) findViewById(R.id.minusbutton2);
        ImageButton min3 = (ImageButton) findViewById(R.id.minusbutton3);
        ImageButton min4 = (ImageButton) findViewById(R.id.minusbutton4);
        ImageButton min5 = (ImageButton) findViewById(R.id.minusbutton5);

        text1 = (TextView) findViewById(R.id.money1);
        text2 = (TextView) findViewById(R.id.money2);
        text3 = (TextView) findViewById(R.id.money3);
        text4 = (TextView) findViewById(R.id.money4);
        text5 = (TextView) findViewById(R.id.money5);

        seedText = (TextView) findViewById(R.id.total);
        seedText.setText(""+seedM+"$");

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seedM > 0) {
                    moneyText1 += 100;
                    seedM -= 100;
                    text1.setText("" + moneyText1 + "$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seedM > 0) {
                    moneyText2 += 100;
                    seedM -= 100;
                    text2.setText("" + moneyText2 + "$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seedM > 0) {
                    moneyText3 += 100;
                    seedM -= 100;
                    text3.setText("" + moneyText3 + "$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });


        plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seedM > 0) {
                    moneyText4 += 100;
                    seedM -= 100;
                    text4.setText("" + moneyText4 + "$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });


        plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seedM > 0) {
                    moneyText5 += 100;
                    seedM -= 100;
                    text5.setText("" + moneyText5 + "$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });


        min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyText1 > 0) {
                    moneyText1 -= 100;
                    seedM += 100;
                    text1.setText(""+moneyText1+"$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyText2 > 0) {
                    moneyText2 -= 100;
                    seedM += 100;
                    text2.setText(""+moneyText2+"$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });
        min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyText3 > 0) {
                    moneyText3 -= 100;
                    seedM += 100;
                    text3.setText(""+moneyText3+"$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        min4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyText4 > 0) {
                    moneyText4 -= 100;
                    seedM += 100;
                    text4.setText(""+moneyText4+"$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        min5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyText5 > 0) {
                    moneyText5 -= 100;
                    seedM += 100;
                    text5.setText(""+moneyText5+"$");
                    seedText.setText(""+seedM+"$");
                }
            }
        });

        TextView textInfo1 = (TextView) findViewById(R.id.stats1);
        TextView textInfo2 = (TextView) findViewById(R.id.stats2);
        TextView textInfo3 = (TextView) findViewById(R.id.stats3);
        TextView textInfo4 = (TextView) findViewById(R.id.stats4);
        TextView textInfo5 = (TextView) findViewById(R.id.stats5);
        Random rand = new Random();
        int speed1 = (rand.nextInt(5)+6)*10;
        int stamina1 = (rand.nextInt(5)+6)*10;
        int condition = (rand.nextInt(5)+6)*10;
        int winRate = 10 ;

        textInfo1.setText("\n"+"   Spd        "+speed1+"\n"+"   Stm        "+stamina1+"\n"+"   Con        "+condition+"\n"+" Win Rate  "+winRate+"%");
        speed1 = (rand.nextInt(5)+6)*10;
        stamina1 = (rand.nextInt(5)+6)*10;
        condition = (rand.nextInt(5)+6)*10;
        textInfo2.setText("\n"+"   Spd        "+speed1+"\n"+"   Stm        "+stamina1+"\n"+"   Con        "+condition+"\n"+" Win Rate  "+winRate+"%");
        speed1 = (rand.nextInt(5)+6)*10;
        stamina1 = (rand.nextInt(5)+6)*10;
        condition = (rand.nextInt(5)+6)*10;
        textInfo3.setText("\n"+"   Spd        "+speed1+"\n"+"   Stm        "+stamina1+"\n"+"   Con        "+condition+"\n"+" Win Rate  "+winRate+"%");
        speed1 = (rand.nextInt(5)+6)*10;
        stamina1 = (rand.nextInt(5)+6)*10;
        condition = (rand.nextInt(5)+6)*10;
        textInfo4.setText("\n"+"   Spd        "+speed1+"\n"+"   Stm        "+stamina1+"\n"+"   Con        "+condition+"\n"+" Win Rate  "+winRate+"%");
        speed1 = (rand.nextInt(5)+6)*10;
        stamina1 = (rand.nextInt(5)+6)*10;
        condition = (rand.nextInt(5)+6)*10;
        textInfo5.setText("\n"+"   Spd        "+speed1+"\n"+"   Stm        "+stamina1+"\n"+"   Con        "+condition+"\n"+" Win Rate  "+winRate+"%");




   }
}
