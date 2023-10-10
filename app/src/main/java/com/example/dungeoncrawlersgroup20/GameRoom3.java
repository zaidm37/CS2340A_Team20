package com.example.dungeoncrawlersgroup20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameRoom3 extends AppCompatActivity {
    private Button next;
    private TextView scoreDisplay;
    private TextView scoreMessage;
    private Timer scoreTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_room3);
        next = (Button) findViewById(R.id.room3next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(GameRoom3.this, EndScreen.class);
                startActivity(inte);
            }
        });

        Bundle bundle = getIntent().getExtras();

        scoreMessage = (TextView) findViewById(R.id.score);
        scoreDisplay = (TextView) findViewById(R.id.score1_1);

        String text = bundle.getString("score");
        scoreMessage.setText(text);

        //while (Integer.parseInt(scoreDisplay.getText().toString()) > 0) {
            //decrementScore();
        //}
    }
    public void decrementScore() {
        String currScore = scoreDisplay.getText().toString();
        final int[] i = {Integer.parseInt(currScore)};
        scoreTime = new Timer();
        scoreTime.schedule(new TimerTask() {
            @Override
            public void run() {
                i[0] -= 50;
            }
        }, 0, 1000);
        String result = new Integer(i[0]).toString();
    }
}