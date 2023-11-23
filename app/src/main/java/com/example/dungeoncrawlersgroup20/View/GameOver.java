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

//        if (endViewModel.getLFinalScore() > endViewModel.getLBest5()) {
//            endViewModel.setLBest5(endViewModel.getLFinalScore());
//            endViewModel.setLString5(endViewModel.getLFinalString());
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("best5", endViewModel.getLBest5());
//            editor.putString("string5", endViewModel.getLString5());
//            editor.apply();
//        }
//        if (endViewModel.getLFinalScore() > endViewModel.getLBest4()) {
//            int tmp = endViewModel.getLBest4();
//            String tmpS = endViewModel.getLString4();
//            endViewModel.setLBest4(endViewModel.getLFinalScore());
//            endViewModel.setLString4(endViewModel.getLFinalString());
//            endViewModel.setLBest5(tmp);
//            endViewModel.setLString5(tmpS);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("best5", endViewModel.getLBest5());
//            editor.putInt("best4", endViewModel.getLBest4());
//            editor.putString("string5", endViewModel.getLString5());
//            editor.putString("string4", endViewModel.getLString4());
//            editor.apply();
//        }
//        if (endViewModel.getLFinalScore() > endViewModel.getLBest3()) {
//            int tmp = endViewModel.getLBest3();
//            String tmpS = endViewModel.getLString3();
//            endViewModel.setLBest3(endViewModel.getLFinalScore());
//            endViewModel.setLString3(endViewModel.getLFinalString());
//            endViewModel.setLBest4(tmp);
//            endViewModel.setLString4(tmpS);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("best4", endViewModel.getLBest4());
//            editor.putInt("best3", endViewModel.getLBest3());
//            editor.putString("string4", endViewModel.getLString4());
//            editor.putString("string3", endViewModel.getLString3());
//            editor.apply();
//        }
//
//        if (endViewModel.getLFinalScore() > endViewModel.getLBest2()) {
//            int tmp = endViewModel.getLBest2();
//            String tmpS = endViewModel.getLString2();
//            endViewModel.setLBest2(endViewModel.getLFinalScore());
//            endViewModel.setLString2(endViewModel.getLFinalString());
//            endViewModel.setLBest3(tmp);
//            endViewModel.setLString3(tmpS);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("best3", endViewModel.getLBest3());
//            editor.putInt("best2", endViewModel.getLBest2());
//            editor.putString("string3", endViewModel.getLString3());
//            editor.putString("string2", endViewModel.getLString2());
//            editor.apply();
//        }
//
//        if (endViewModel.getLFinalScore() > endViewModel.getLBest1()) {
//            int tmp = endViewModel.getLBest1();
//            String tmpS = endViewModel.getLString1();
//            endViewModel.setLBest1(endViewModel.getLFinalScore());
//            endViewModel.setLString1(endViewModel.getLFinalString());
//            endViewModel.setLBest2(tmp);
//            endViewModel.setLString2(tmpS);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("best2", endViewModel.getLBest2());
//            editor.putInt("best1", endViewModel.getLBest1());
//            editor.putString("string2", endViewModel.getLString2());
//            editor.putString("string1", endViewModel.getLString1());
//            editor.apply();
//        }
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