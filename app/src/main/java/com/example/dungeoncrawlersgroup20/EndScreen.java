package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class EndScreen extends AppCompatActivity {
    private Button restart;
    private TextView tv_score;
    private int finalScore;
    private String userName;
    private String date;
    private Calendar calender;
    private String time;
    private int best1, best2, best3, best4, best5;
    private String finalString, string1, string2, string3, string4, string5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
        Bundle bundle = getIntent().getExtras();
        userName = bundle.getString("user");
        calender = Calendar.getInstance();
        date = DateFormat.getDateInstance(DateFormat.FULL).format(calender);
        time = DateFormat.getTimeInstance().format(calender);
        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(EndScreen.this, MainActivity.class);
                startActivity(move);
            }
        });

        tv_score = (TextView) findViewById(R.id.tv_score);
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        finalScore = preferences.getInt("finalScore", bundle.getInt("score"));
        finalString = preferences.getString("finalString", finalScore
                + " " + userName + " " + date + " " + time);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);
        best4 = preferences.getInt("best4", 0);
        best5 = preferences.getInt("best5", 0);
        string1 = preferences.getString("string1", "");
        string2 = preferences.getString("string2", "");
        string3 = preferences.getString("string3", "");
        string4 = preferences.getString("string4", "");
        string5 = preferences.getString("string5", "");

        if (finalScore > best5) {
            best5 = finalScore;
            string5 = finalString;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.putString("string5", string5);
            editor.apply();
        }
        if (finalScore > best4) {
            int tmp = best4;
            String tmpS = string4;
            best4 = finalScore;
            string4 = finalString;
            best5 = tmp;
            string5 = tmpS;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.putInt("best4", best4);
            editor.putString("string5", string5);
            editor.putString("string4",string4);
            editor.apply();
        }
        if (finalScore > best3) {
            int tmp = best3;
            String tmpS = string3;
            best3 = finalScore;
            string3 = finalString;
            best4 = tmp;
            string4 = tmpS;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best4", best4);
            editor.putInt("best3", best3);
            editor.putString("string4", string4);
            editor.putString("string3",string3);
            editor.apply();
        }

        if (finalScore > best2) {
            int tmp = best2;
            String tmpS = string2;
            best2 = finalScore;
            string2 = finalString;
            best3 = tmp;
            string3 = tmpS;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.putString("string3", string3);
            editor.putString("string2",string2);
            editor.apply();
        }

        if (finalScore > best1) {
            int tmp = best1;
            String tmpS = string1;
            best1 = finalScore;
            string1 = finalString;
            best2 = tmp;
            string2 = tmpS;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.putString("string2", string2);
            editor.putString("string1",string1);
            editor.apply();
        }
        tv_score.setText("Final score: " + finalString + "\n"
                + "1: " + string1 + "\n"
                + "2: " + string2 + "\n"
                + "3: " + string3 + "\n"
                + "4: " + string4 + "\n"
                + "5: " + string5 + "\n"
        );

    }
}