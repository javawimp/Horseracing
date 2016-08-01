package com.example.alab.horseracing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    int value1 = 0;
    int value2 = 0;
    int value3 = 0;
    int value4 = 0;
    int value5 = 0;

    double winrate1 = 0;
    double winrate2 = 0;
    double winrate3 = 0;
    double winrate4 = 0;
    double winrate5 = 0;

    int result;

    int seedM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle bundle = getIntent().getExtras();
        value1 = bundle.getInt("HorseOneRe");   //horse 1
        value2 = bundle.getInt("HorseTwoRe");   //horse 2
        value3 = bundle.getInt("HorseThreeRe"); //horse 3
        value4 = bundle.getInt("HorseFourRe");  //horse 4
        value5 = bundle.getInt("HorseFiveRe");  //horse 5
        seedM = bundle.getInt("HorseSeedM");

        winrate1 = bundle.getDouble("FOneRate");
        winrate2 = bundle.getDouble("FTwoRate");
        winrate3 = bundle.getDouble("FThreeRate");
        winrate4 = bundle.getDouble("FFourRate");
        winrate5 = bundle.getDouble("FFiveRate");

        TextView earnM = (TextView) findViewById(R.id.earnedmoney);
        result = value1 + value2 + value3 + value4 + value5;

        earnM.setText("" + result);
        ImageButton button1 = (ImageButton) findViewById(R.id.againbutton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, Horseselect.class);
                intent.putExtra("HorseRe", result);
                intent.putExtra("HorseSeedMoney", seedM);

                intent.putExtra("SOneRate", winrate1);
                intent.putExtra("STwoRate", winrate2);
                intent.putExtra("SThreeRate", winrate3);
                intent.putExtra("SFourRate", winrate4);
                intent.putExtra("SFiveRate", winrate5);

                startActivity(intent);
                finish();
            }
        });
    }
}
