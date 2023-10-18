package com.example.dungeoncrawlersgroup20.ViewModel;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Movement;
import com.example.dungeoncrawlersgroup20.Model.Observable;
import com.example.dungeoncrawlersgroup20.Model.Observer;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.Run;
import com.example.dungeoncrawlersgroup20.Model.Score;
import com.example.dungeoncrawlersgroup20.Model.Walk;

public class GameViewModel extends ViewModel implements Observer {
    private Player player;
    private Difficulty difficulty;
    private Score scoreTrack;
    private Movement walk;
    private Movement run;
    private boolean moveCheck;
    private Observable observable;
    public GameViewModel() {
        player = Player.getPlayer();
        difficulty = new Difficulty();
        scoreTrack = new Score();
        walk = new Walk();
        run = new Run();
        moveCheck = true;
        player.setMovement(walk);
        this.observable = observable;
        this.observable.addObserver(this);
    }
    @Override
    public void update(Movement movement) {
        if (movement.equals(walk)) {
            moveCheck = true;
        } else if (movement.equals(run)) {
            moveCheck = false;
        }
    }
    public String getPlayerName() {
        return player.getName();
    }
    public void setPlayerName(String name) {
        player.setName(name);
    }
    public int getPlayerHealth() {
        return player.getHealth();
    }
    public void setPlayerHealth(int health) {
        player.setHealth(health);
    }
    public Drawable getPLayerSprite() {
        return player.getSprite();
    }
    public void setPlayerSprite(Drawable sprite) {
        player.setSprite(sprite);
    }
    public String getPlayerDifficulty() {
        return difficulty.getDiff();
    }
    public void setPLayerDifficulty(String diff) {
        difficulty.setDiff(diff);
    }
    public int getPlayerScore() {
        return scoreTrack.getScore();
    }
    public void setPlayerScore(int score) {
        scoreTrack.setScore(score);
    }
    public void reduceScore() {
        if (scoreTrack.getScore() > 0) {
            scoreTrack.setScore(scoreTrack.getScore() - 50);
        }
    }
    public void changeMovement() {
        if (moveCheck) {
            player.setMovement(run);
            moveCheck = false;
        } else {
            player.setMovement(walk);
            moveCheck = true;
        }
    }
    public float up(float y, int textHeight) {
        return player.playerMoveUp(y, textHeight);
    }
    public float down(float y, int border, int spriteHeight) {
        return player.playerMoveDown(y, border, spriteHeight);
    }
    public float left(float x) {
        return player.playerMoveLeft(x);
    }
    public float right(float x, int border, int spriteWidth) {
        return player.playerMoveRight(x, border, spriteWidth);
    }
}
