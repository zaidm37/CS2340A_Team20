package com.example.dungeoncrawlersgroup20.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
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

public class GameRoom3 extends AppCompatActivity {
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private TextView hP;
    private Handler scoreHandler;
    private Handler enemyHandler;
    private Handler playerHandler;
    private Handler handler;
    private Timer gameOver;
    private EnemyViewModel enemyViewModel;
    private int spriteWidth;
    private int spriteHeight;
    private ImageView enemyOne;
    private ImageView enemyTwo;
    private TextView tvScore;
    private GameViewModel gameViewModel;
    private Button move;
    private ImageView door;
    private int screenHeight;
    private int screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_room3);
        Bundle bundle = getIntent().getExtras();
        door = (ImageView) findViewById(R.id.door);
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        enemyViewModel = new ViewModelProvider(this).get(EnemyViewModel.class);
        userName = (TextView) findViewById(R.id.name);
        userName.setText(gameViewModel.getPlayerName());
        characterSprite = (ImageView) findViewById(R.id.character);
        characterSprite.setImageDrawable(gameViewModel.getPLayerSprite());
        hP = (TextView) findViewById(R.id.health);
        hP.setText(String.valueOf(gameViewModel.getPlayerHealth()));
        difficulty = (TextView) findViewById(R.id.difficulty);
        difficulty.setText(gameViewModel.getPlayerDifficulty());
        gameViewModel.setPlayerScore(bundle.getInt("score"));
        tvScore = (TextView) findViewById(R.id.tv_score);

        scoreHandler = new Handler();
        scoreHandler.post(new Runnable() {
            @Override
            public void run() {
                if (gameViewModel.getPlayerHealth() > 0) {
                    gameViewModel.reduceScore();
                    tvScore.setText("Score: " + gameViewModel.getPlayerScore());
                    scoreHandler.postDelayed(this, 5000);
                }
            }
        });

        enemyOne = (ImageView) findViewById(R.id.enemy1);
        enemyOne.setImageResource(enemyViewModel.enemySprite("hard"));
        enemyTwo = (ImageView) findViewById(R.id.enemy2);
        enemyTwo.setImageResource(enemyViewModel.enemySprite("ultimate"));

        gameOver = new Timer();
        gameOver.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gameViewModel.getPlayerHealth() == 0) {
                    playerLose();
                }

            }
        }, 0, 1);

        move = (Button) findViewById(R.id.buttonMove);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameViewModel.changeMovement();
            }
        });
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Rect visibleFrame = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);
            screenHeight = visibleFrame.height();
            screenWidth = visibleFrame.width();

            enemyViewModel.setEnemyBorderW("hard", screenWidth);
            enemyViewModel.setEnemyBorderH("hard", screenHeight);
            enemyViewModel.setEnemyBorderW("ultimate", screenWidth);
            enemyViewModel.setEnemyBorderH("ultimate", screenHeight);

            gameViewModel.setPlayerX(characterSprite.getX());
            gameViewModel.setPlayerY(characterSprite.getY());

            spriteWidth = characterSprite.getWidth();
            spriteHeight = characterSprite.getHeight();
            gameViewModel.setPW(spriteWidth);
            gameViewModel.setPH(spriteHeight);

            enemyViewModel.setEnemyX("hard", enemyOne.getX());
            enemyViewModel.setEnemyY("hard", enemyOne.getY());
            enemyViewModel.setEnemyX("ultimate", enemyTwo.getX());
            enemyViewModel.setEnemyY("ultimate", enemyTwo.getY());

            enemyViewModel.setEnemyWidth("hard", enemyOne.getWidth());
            enemyViewModel.setEnemyHeight("hard", enemyOne.getHeight());
            enemyViewModel.setEnemyWidth("ultimate", enemyTwo.getWidth());
            enemyViewModel.setEnemyHeight("ultimate", enemyTwo.getHeight());

            playerHandler = new Handler();
            playerHandler.post(new Runnable() {
                @Override
                public void run() {

                    gameViewModel.getPlayerX();
                    gameViewModel.getPlayerY();

                    Rect playerR = new Rect();
                    characterSprite.getHitRect(playerR);
                    Rect enemyR = new Rect();
                    enemyOne.getHitRect(enemyR);
                    gameViewModel.checkCollide(playerR, enemyR);

                    enemyTwo.getHitRect(enemyR);
                    gameViewModel.checkCollide(playerR, enemyR);

                    playerHandler.postDelayed(this, 50);
                }
            });


            enemyHandler = new Handler();
            enemyHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (gameViewModel.getPlayerHealth() > 0) {
                        enemyOne.setX(enemyViewModel.getEnemyX("hard"));
                        enemyOne.setY(enemyViewModel.getEnemyY("hard"));
                        enemyTwo.setX(enemyViewModel.getEnemyX("ultimate"));
                        enemyTwo.setY(enemyViewModel.getEnemyY("ultimate"));
                        enemyHandler.postDelayed(this, 1);
                    }
                }
            });


            handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {

                    hP.setText(String.valueOf(gameViewModel.getPlayerHealth()));
                    handler.postDelayed(this, 0);

                }
            });
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int spriteWidth = characterSprite.getWidth();
        int spriteHeight = characterSprite.getHeight();
        switch (keyCode) {
        case KeyEvent.KEYCODE_SHIFT_LEFT:
            gameViewModel.changeMovement();
            break;
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
            break;
        }
        Rect playerR = new Rect();
        characterSprite.getHitRect(playerR);
        Rect doorR = new Rect();
        door.getHitRect(doorR);
        if (Rect.intersects(playerR, doorR)) {
            playerSucceed();
        }
        return true;
    }

    public void playerLose() {
        if (gameViewModel.getPlayerHealth() == 0) {
            gameViewModel.reduceScoreLose();
            Intent inte = new Intent(GameRoom3.this, GameOver.class);
            Bundle playerinfo = new Bundle();
            playerinfo.putInt("score", gameViewModel.getPlayerScore());
            inte.putExtras(playerinfo);
            startActivity(inte);
        }
    }
    public void playerSucceed() {
        characterSprite.setX(-888);
        characterSprite.setY(-888);
        Intent inte = new Intent(GameRoom3.this, EndScreen.class);
        Bundle playerinfo = new Bundle();
        playerinfo.putInt("score", gameViewModel.getPlayerScore());
        inte.putExtras(playerinfo);
        startActivity(inte);
    }
}