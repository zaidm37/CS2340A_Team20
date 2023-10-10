package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private TextView hP;
    private Button next;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("user"); //gets the previous name from config screen
        int hp = bundle.getInt("diff"); //gets difficulty
        String diff = "";
        if (hp == 1) {
            hp = 300;
            diff = "Easy";
        } else if (hp == 2) {
            hp = 200;
            diff = "Medium";
        } else if (hp == 3) {
            hp = 100;
            diff = "Hard";
        } // sets hp depending on difficulty, 1 = easy = more health, etc
        int character = bundle.getInt("sprite"); //gets which sprite number in drawable was selected
        userName = (TextView) findViewById(R.id.name);
        userName.setText(name);
        difficulty = (TextView) findViewById(R.id.difficulty);
        difficulty.setText(diff);
        hP = (TextView) findViewById(R.id.health);
        hP.setText(String.valueOf(hp));
        characterSprite = (ImageView) findViewById(R.id.character);
        if (character == 1) {
            characterSprite.setImageResource(R.drawable.sprite1);
        } else if (character == 2) {
            characterSprite.setImageResource(R.drawable.sprite2);
        } else if (character == 3) {
            characterSprite.setImageResource(R.drawable.sprite3);
        }
        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(GameScreen.this, GameRoom2.class);
                startActivity(inte);
            }
        });
    }
}