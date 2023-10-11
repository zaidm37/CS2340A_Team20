package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameRoom3 extends AppCompatActivity {
    private Button next;
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private TextView hP;
    private Timer scoreTime;
    private TextView tv_score;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_room3);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("user"); //gets the previous name from config screen
        int hp = bundle.getInt("diff"); //gets difficulty
        difficulty = (TextView) findViewById(R.id.difficulty);
        int trueHp = 0;
        if (hp == 1) {
            trueHp = 300;
            String diffE = "Easy";
            difficulty.setText(diffE);
        } else if (hp == 2) {
            trueHp = 200;
            String diffM = "Medium";
            difficulty.setText(diffM);
        } else if (hp == 3) {
            trueHp = 100;
            String diffH = "Hard";
            difficulty.setText(diffH);
        } // sets hp depending on difficulty, 1 = easy = more health, etc
        int character = bundle.getInt("sprite"); //gets which sprite number in drawable was selected
        userName = (TextView) findViewById(R.id.name);
        userName.setText(name);
        hP = (TextView) findViewById(R.id.health);
        hP.setText(String.valueOf(trueHp));
        characterSprite = (ImageView) findViewById(R.id.character);
        if (character == 1) {
            characterSprite.setImageResource(R.drawable.sprite1);
        } else if (character == 2) {
            characterSprite.setImageResource(R.drawable.sprite2);
        } else if (character == 3) {
            characterSprite.setImageResource(R.drawable.sprite3);
        }
        score = bundle.getInt("score");
        tv_score = (TextView) findViewById(R.id.tv_score);
        scoreTime = new Timer();
        scoreTime.schedule(new TimerTask() {
            @Override
            public void run() {
                score -= 50;
                tv_score.setText("Score: " + score);

            }
        }, 0, 5000);
        next = (Button) findViewById(R.id.room3next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(GameRoom3.this, EndScreen.class);
                startActivity(inte);
            }
        });
    }
}