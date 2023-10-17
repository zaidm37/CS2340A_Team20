package com.example.dungeoncrawlersgroup20.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawlersgroup20.R;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private TextView hP;
    private Button next;
    private Timer scoreTime;
    private TextView tvScore;
    private GameViewModel gameViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        Bundle bundle = getIntent().getExtras();
        gameViewModel.setPLayerDifficulty(bundle.getString("diff"));
        userName = (TextView) findViewById(R.id.name);
        userName.setText(gameViewModel.getPlayerName());
        characterSprite = (ImageView) findViewById(R.id.character);
        characterSprite.setImageDrawable(gameViewModel.getPLayerSprite());
        hP = (TextView) findViewById(R.id.health);
        hP.setText(String.valueOf(gameViewModel.getPlayerHealth()));
        difficulty = (TextView) findViewById(R.id.difficulty);
        difficulty.setText(gameViewModel.getPlayerDifficulty());
        gameViewModel.setPlayerScore(1000);
        tvScore = (TextView) findViewById(R.id.tv_score);
        scoreTime = new Timer();
        scoreTime.schedule(new TimerTask() {
            @Override
            public void run() {
                gameViewModel.reduceScore();
                tvScore.setText("Score: " + gameViewModel.getPlayerScore());

            }
        }, 0, 5000);

        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(GameScreen.this, GameRoom2.class);
                Bundle playerinfo = new Bundle();
                playerinfo.putInt("score", gameViewModel.getPlayerScore());
                inte.putExtras(playerinfo);
                startActivity(inte);
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                characterSprite.setX(gameViewModel.left(characterSprite.getX()));
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                characterSprite.setX(gameViewModel.right(characterSprite.getX()));
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                characterSprite.setY(gameViewModel.up(characterSprite.getY()));
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                characterSprite.setY(gameViewModel.down(characterSprite.getY()));
                break;
        }
        return true;
    }

}