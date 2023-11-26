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
    private Handler scoreReduce;
    private Handler animation;
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
        setupViews();
        setupViewModels();

        userName.setText(gameViewModel.getPlayerName());

        characterSprite.setImageDrawable(gameViewModel.getPLayerSprite());

        hP.setText(String.valueOf(gameViewModel.getPlayerHealth()));

        gameViewModel.setPLayerDifficulty(bundle.getString("diff"));
        difficulty.setText(gameViewModel.getPlayerDifficulty());
        gameViewModel.setPlayerScore(bundle.getInt("score"));


        setupScoreUpdater();
        reduceTheScore();


        setupDifficulty();


        gameOver = new Timer();
        gameOver.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gameViewModel.getPlayerHealth() == 0) {
                    playerLose();
                }

            }
        }, 0, 1);


        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameViewModel.changeMovement();
            }
        });
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

            if (gameViewModel.getPlayerDifficulty().equals("Easy")) {
                enemyViewModel.setEnemyBorderW("easy", screenWidth);
                enemyViewModel.setEnemyBorderH("easy", screenHeight);
                enemyViewModel.setEnemyBorderW("medium", screenWidth);
                enemyViewModel.setEnemyBorderH("medium", screenHeight);
            } else if (gameViewModel.getPlayerDifficulty().equals("Medium")) {
                enemyViewModel.setEnemyBorderW("medium", screenWidth);
                enemyViewModel.setEnemyBorderH("medium", screenHeight);
                enemyViewModel.setEnemyBorderW("hard", screenWidth);
                enemyViewModel.setEnemyBorderH("hard", screenHeight);
            } else if (gameViewModel.getPlayerDifficulty().equals("Hard")) {
                enemyViewModel.setEnemyBorderW("hard", screenWidth);
                enemyViewModel.setEnemyBorderH("hard", screenHeight);
                enemyViewModel.setEnemyBorderW("ultimate", screenWidth);
                enemyViewModel.setEnemyBorderH("ultimate", screenHeight);
            }

            gameViewModel.setPlayerX(characterSprite.getX());
            gameViewModel.setPlayerY(characterSprite.getY());

            spriteWidth = characterSprite.getWidth();
            spriteHeight = characterSprite.getHeight();
            gameViewModel.setPW(spriteWidth);
            gameViewModel.setPH(spriteHeight);

            if (gameViewModel.getPlayerDifficulty().equals("Easy")) {
                enemyViewModel.setEnemyX("easy", enemyOne.getX());
                enemyViewModel.setEnemyY("easy", enemyOne.getY());
                enemyViewModel.setEnemyX("medium", enemyTwo.getX());
                enemyViewModel.setEnemyY("medium", enemyTwo.getY());
            } else if (gameViewModel.getPlayerDifficulty().equals("Medium")) {
                enemyViewModel.setEnemyX("medium", enemyOne.getX());
                enemyViewModel.setEnemyY("medium", enemyOne.getY());
                enemyViewModel.setEnemyX("hard", enemyTwo.getX());
                enemyViewModel.setEnemyY("hard", enemyTwo.getY());
            } else if (gameViewModel.getPlayerDifficulty().equals("Hard")) {
                enemyViewModel.setEnemyX("hard", enemyOne.getX());
                enemyViewModel.setEnemyY("hard", enemyOne.getY());
                enemyViewModel.setEnemyX("ultimate", enemyTwo.getX());
                enemyViewModel.setEnemyY("ultimate", enemyTwo.getY());
            }

            if (gameViewModel.getPlayerDifficulty().equals("Easy")) {
                enemyViewModel.setEnemyWidth("easy", enemyOne.getWidth());
                enemyViewModel.setEnemyHeight("easy", enemyOne.getHeight());
                enemyViewModel.setEnemyWidth("medium", enemyTwo.getWidth());
                enemyViewModel.setEnemyHeight("medium", enemyTwo.getHeight());
            } else if (gameViewModel.getPlayerDifficulty().equals("Medium")) {
                enemyViewModel.setEnemyWidth("medium", enemyOne.getWidth());
                enemyViewModel.setEnemyHeight("medium", enemyOne.getHeight());
                enemyViewModel.setEnemyWidth("hard", enemyTwo.getWidth());
                enemyViewModel.setEnemyHeight("hard", enemyTwo.getHeight());
            } else if (gameViewModel.getPlayerDifficulty().equals("Hard")) {
                enemyViewModel.setEnemyWidth("hard", enemyOne.getWidth());
                enemyViewModel.setEnemyHeight("hard", enemyOne.getHeight());
                enemyViewModel.setEnemyWidth("ultimate", enemyTwo.getWidth());
                enemyViewModel.setEnemyHeight("ultimate", enemyTwo.getHeight());
            }

            setupPlayerMovementHandler();
            setupEnemyMovementHandler();
            setupPowerHandler();


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
        case KeyEvent.KEYCODE_Z:
            playerAttacks();
            break;
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
    public void playerAttacks() {
        if (gameViewModel.getSpriteNum() == 1) {
            characterSprite.setImageResource(R.drawable.sprite1attack);
            animation = new Handler();
            animation.postDelayed(new Runnable() {
                public void run() {
                    characterSprite.setImageResource(R.drawable.sprite1);
                }
            }, 500);
        } else if (gameViewModel.getSpriteNum() == 2) {
            characterSprite.setImageResource(R.drawable.sprite2attack);
            animation = new Handler();
            animation.postDelayed(new Runnable() {
                public void run() {
                    characterSprite.setImageResource(R.drawable.sprite2);
                }
            }, 500);
        } else if (gameViewModel.getSpriteNum() == 3) {
            characterSprite.setImageResource(R.drawable.sprite3attack);
            animation = new Handler();
            animation.postDelayed(new Runnable() {
                public void run() {
                    characterSprite.setImageResource(R.drawable.sprite3);
                }
            }, 500);
        }
        if (enemyOneAttacked) {
            enemyOne.animate().alpha(0f).setDuration(1000);
            enemyOneAttacked = false;
            enemyOneStop = true;
            gameViewModel.increaseScoreAttack();
        }
        if (enemyTwoAttacked) {
            enemyTwo.animate().alpha(0f).setDuration(1000);
            enemyTwoAttacked = false;
            enemyTwoStop = true;
            gameViewModel.increaseScoreAttack();
        }
    }
    public void reduceTheScore() {
        scoreReduce = new Handler();
        scoreReduce.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (gameViewModel.getPlayerHealth() > 0) {
                    gameViewModel.reduceScore();
                    scoreReduce.postDelayed(this, SCORE_REDUCE_DELAY);
                }
            }
        }, SCORE_REDUCE_DELAY);
    }
    private void setupPowerHandler() {
        powHandler = new Handler();
        powHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (collect) {
                    Rect playerR = new Rect();
                    characterSprite.getHitRect(playerR);
                    Rect powR = new Rect();
                    pow.getHitRect(powR);
                    if (Rect.intersects(playerR, powR)) {
                        if (gameViewModel.playerCollectWipe()) {
                            pow.animate().alpha(0f).setDuration(500);
                            enemyOneAttacked = true;
                            enemyTwoAttacked = true;
                            collect = false;
                            playerAttacks();
                        }
                    }
                }
                powHandler.postDelayed(this, 1);
            }
        }, 1);
    }
}