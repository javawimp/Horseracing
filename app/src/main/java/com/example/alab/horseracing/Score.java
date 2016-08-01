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
                startActivity(intent);
                finish();
            }
        });
    }
}
