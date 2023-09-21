package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    TextView UserName;
    TextView Difficulty;
    ImageView Character;
    TextView HP;
    Button Next;

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
        UserName = (TextView) findViewById(R.id.name);
        UserName.setText(name);
        Difficulty = (TextView) findViewById(R.id.difficulty);
        Difficulty.setText(diff);
        HP = (TextView) findViewById(R.id.health);
        HP.setText(String.valueOf(hp));
        Character = (ImageView) findViewById(R.id.character);
        if (character == 1) {
            Character.setImageResource(R.drawable.sprite1);
        } else if (character == 2) {
            Character.setImageResource(R.drawable.sprite2);
        } else if (character == 3) {
            Character.setImageResource(R.drawable.sprite3);
        }
        Next = (Button) findViewById(R.id.buttonNext);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(GameScreen.this, EndScreen.class);
                startActivity(inte);
            }
        });
    }
}