package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {
    private Button restart;
    private TextView tv_score;
    private int finalScore;
    private int best1, best2, best3, best4, best5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
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
        finalScore = preferences.getInt("finalScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);
        best4 = preferences.getInt("best4", 0);
        best5 = preferences.getInt("best5", 0);

        if (finalScore > best5) {
            best5 = finalScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.apply();
        }
        if (finalScore > best4) {
            int tmp = best4;
            best4 = finalScore;
            best5 = tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.putInt("best4", best4);
            editor.apply();
        }
        if (finalScore > best3) {
            int tmp = best3;
            best3 = finalScore;
            best4 = tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best4", best4);
            editor.putInt("best3", best3);
            editor.apply();
        }

        if (finalScore > best2) {
            int tmp = best2;
            best2 = finalScore;
            best3 = tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();
        }

        if (finalScore > best1) {
            int tmp = best1;
            best1 = finalScore;
            best2 = tmp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();
        }
        tv_score.setText("Final score: " + finalScore + "\n" +
                "1: " + best1 + "\n" +
                "2: " + best2 + "\n" +
                "3: " + best3 + "\n" +
                        "4: " + best4 + "\n" +
                        "5: " + best5 + "\n"
                );

    }
}