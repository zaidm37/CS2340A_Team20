package com.example.dungeoncrawlersgroup20.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
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
import android.util.Log;

public class GameScreen extends AppCompatActivity {
    private TextView userName;
    private TextView difficulty;
    private ImageView characterSprite;
    private TextView hP;
//    private Button next;
    private Button move;
    private Timer scoreTime;
    private TextView tvScore;
    private ImageView door;
    private GameViewModel gameViewModel;
    private int screenHeight;
    private int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
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

//        next = (Button) findViewById(R.id.buttonNext);
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent inte = new Intent(GameScreen.this, GameRoom2.class);
//                Bundle playerinfo = new Bundle();
//                playerinfo.putInt("score", gameViewModel.getPlayerScore());
//                inte.putExtras(playerinfo);
//                startActivity(inte);
//            }
//        });
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
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int spriteWidth = characterSprite.getWidth();
        int spriteHeight = characterSprite.getHeight();
        int doorWidth = door.getWidth();
        int doorHeight = door.getHeight();
        RectF spriteRect = new RectF(spriteWidth - 100, spriteHeight - 100, spriteWidth + 100, spriteHeight + 100);
        RectF doorRect = new RectF(doorWidth - 100, doorHeight - 100, doorWidth + 100, doorHeight + 100);
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                characterSprite.setX(gameViewModel.left(characterSprite.getX()));
                spriteRect.left = characterSprite.getX() - 100;
                spriteRect.top = characterSprite.getY() - 100;
                spriteRect.right = characterSprite.getX() + 100;
                spriteRect.bottom = characterSprite.getY() + 100;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                characterSprite.setX(
                        gameViewModel.right(characterSprite.getX(),
                                screenWidth, spriteWidth));
                spriteRect.left = characterSprite.getX() - 100;
                spriteRect.top = characterSprite.getY() - 100;
                spriteRect.right = characterSprite.getX() + 100;
                spriteRect.bottom = characterSprite.getY() + 100;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                float newUpY = gameViewModel.up(
                        characterSprite.getY(), (screenHeight / 6) + 100);
                if (newUpY >= 0) {
                    characterSprite.setY(newUpY);
                    spriteRect.left = characterSprite.getX() - 100;
                    spriteRect.top = characterSprite.getY() - 100;
                    spriteRect.right = characterSprite.getX() + 100;
                    spriteRect.bottom = characterSprite.getY() + 100;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                characterSprite.setY(gameViewModel.down(
                        characterSprite.getY(), screenHeight, spriteHeight));
                spriteRect.left = characterSprite.getX() - 100;
                spriteRect.top = characterSprite.getY() - 100;
                spriteRect.right = characterSprite.getX() + 100;
                spriteRect.bottom = characterSprite.getY() + 100;
                break;
            default:
                break;
        }
        if (spriteRect.intersect(doorRect)) {
            Intent inte = new Intent(GameScreen.this, GameRoom2.class);
            Bundle playerinfo = new Bundle();
            playerinfo.putInt("score", gameViewModel.getPlayerScore());
            inte.putExtras(playerinfo);
            startActivity(inte);
        }
        return true;
    }
}