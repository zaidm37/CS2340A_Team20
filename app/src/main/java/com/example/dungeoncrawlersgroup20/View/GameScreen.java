package com.example.dungeoncrawlersgroup20.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawlersgroup20.R;
import com.example.dungeoncrawlersgroup20.ViewModel.EnemyViewModel;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private ImageView enemyOne;
    private ImageView enemyTwo;
    private TextView hP;
    private Button move;
    private Timer scoreTime;
    private TextView tvScore;
    private ImageView door;
    private GameViewModel gameViewModel;
    private EnemyViewModel enemyViewModel;
    private int screenHeight;
    private int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        enemyViewModel = new ViewModelProvider(this).get(EnemyViewModel.class);
        Bundle bundle = getIntent().getExtras();
        door = (ImageView) findViewById(R.id.door);
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

        move = (Button) findViewById(R.id.buttonMove);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameViewModel.changeMovement();
            }
        });

        enemyOne = (ImageView) findViewById(R.id.enemy1);
        enemyOne.setImageResource(enemyViewModel.spriteEasyEnemy());
        enemyTwo = (ImageView) findViewById(R.id.enemy2);
        enemyTwo.setImageResource(enemyViewModel.spriteMediumEnemy());

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Rect visibleFrame = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);
            screenHeight = visibleFrame.height();
            screenWidth = visibleFrame.width();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int spriteWidth = characterSprite.getWidth();
        int spriteHeight = characterSprite.getHeight();
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            characterSprite.setX(gameViewModel.left(characterSprite.getX()));
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            characterSprite.setX(
                        gameViewModel.right(characterSprite.getX(),
                                screenWidth, spriteWidth));
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            float newUpY = gameViewModel.up(
                        characterSprite.getY(), (screenHeight / 6) + 100);
            if (newUpY >= 0) {
                characterSprite.setY(newUpY);
            }
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            characterSprite.setY(gameViewModel.down(
                        characterSprite.getY(), screenHeight, spriteHeight));
            break;
        default:
            gameViewModel.playerX();
            gameViewModel.playerY();
            break;
        }
        Rect playerR = new Rect();
        characterSprite.getHitRect(playerR);
        Rect doorR = new Rect();
        door.getHitRect(doorR);
        if (Rect.intersects(playerR, doorR)) {
            characterSprite.setX(-888);
            characterSprite.setY(-888);
            Intent inte = new Intent(GameScreen.this, GameRoom2.class);
            Bundle playerinfo = new Bundle();
            playerinfo.putInt("score", gameViewModel.getPlayerScore());
            inte.putExtras(playerinfo);
            startActivity(inte);
        }
        return true;
    }
}