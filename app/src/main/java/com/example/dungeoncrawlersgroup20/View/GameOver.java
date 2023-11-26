package com.example.dungeoncrawlersgroup20.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dungeoncrawlersgroup20.R;
import com.example.dungeoncrawlersgroup20.ViewModel.EndViewModel;

public class GameOver extends AppCompatActivity {
    private Button restart;
    private TextView tvScore;
    private String userName;
    private EndViewModel endViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        endViewModel = new ViewModelProvider(this).get(EndViewModel.class);
        Bundle bundle = getIntent().getExtras();
        userName = endViewModel.getPlayerName();
        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(GameOver.this, MainActivity.class);
                startActivity(move);
            }
        });

        tvScore = (TextView) findViewById(R.id.tv_score);
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        endViewModel.setLFinalScore(preferences.getInt(
                "finalScore", bundle.getInt("score")));
        endViewModel.setLFinalString(preferences.getString("finalString",
                userName + " " + endViewModel.getCurrentDate()));
        endViewModel.setLBest1(preferences.getInt("best1", 0));
        endViewModel.setLBest2(preferences.getInt("best2", 0));
        endViewModel.setLBest3(preferences.getInt("best3", 0));
        endViewModel.setLBest4(preferences.getInt("best4", 0));
        endViewModel.setLBest5(preferences.getInt("best5", 0));
        endViewModel.setLString1(preferences.getString("string1", ""));
        endViewModel.setLString2(preferences.getString("string2", ""));
        endViewModel.setLString3(preferences.getString("string3", ""));
        endViewModel.setLString4(preferences.getString("string4", ""));
        endViewModel.setLString5(preferences.getString("string5", ""));

        tvScore.setText("Final score: " + endViewModel.getLFinalScore() + " "
                + endViewModel.getLFinalString() + "\n"
                + "1: " + endViewModel.getLBest1() + " " + endViewModel.getLString1() + "\n"
                + "2: " + endViewModel.getLBest2() + " " + endViewModel.getLString2() + "\n"
                + "3: " + endViewModel.getLBest3() + " " + endViewModel.getLString3() + "\n"
                + "4: " + endViewModel.getLBest4() + " " + endViewModel.getLString4() + "\n"
                + "5: " + endViewModel.getLBest5() + " " + endViewModel.getLString5() + "\n"
        );
    }
}