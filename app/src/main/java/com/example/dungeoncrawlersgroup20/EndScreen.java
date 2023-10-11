package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EndScreen extends AppCompatActivity {
    private Button restart;
    private TextView tv_score;
    private String userName;
    private String date;
    private Calendar calender;
    private SimpleDateFormat dateFormat;
    private Leaderboard leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
        Bundle bundle = getIntent().getExtras();
        leaderboard = Leaderboard.getInstance();

        userName = bundle.getString("user");
        calender = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        date = dateFormat.format(calender.getTime());


        int finalScore = bundle.getInt("score");
        String finalString = userName + " " + date;

        leaderboard.updateScores(finalScore, finalString);


        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText("Final score: " + finalScore + " " + finalString + "\n"
                + "1: " + leaderboard.getBest1() + " " + leaderboard.getString1() + "\n"
                + "2: " + leaderboard.getBest2() + " " + leaderboard.getString2() + "\n"
                + "3: " + leaderboard.getBest3() + " " + leaderboard.getString3() + "\n"
                + "4: " + leaderboard.getBest4() + " " + leaderboard.getString4() + "\n"
                + "5: " + leaderboard.getBest5() + " " + leaderboard.getString5() + "\n"
        );

        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(EndScreen.this, MainActivity.class);
                startActivity(move);
            }
        });
    }
}