package com.example.dungeoncrawlersgroup20.ViewModel;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Movement;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.Score;
import com.example.dungeoncrawlersgroup20.Model.Walk;

public class GameViewModel extends ViewModel {
    private Player player;
    private Difficulty difficulty;
    private Score scoreTrack;
    public GameViewModel() {
        player = Player.getPlayer();
        difficulty = new Difficulty();
        scoreTrack = new Score();
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
    public void up() {
        Movement walk = new Walk();
        player.setMovement(walk);
        player.playerMoveUp();
    }
    public void down() {
        Movement walk = new Walk();
        player.setMovement(walk);
        player.playerMoveDown();
    }
    public void left() {
        Movement walk = new Walk();
        player.setMovement(walk);
        player.playerMoveLeft();
    }
    public void right() {
        Movement walk = new Walk();
        player.setMovement(walk);
        player.playerMoveRight();
    }
}
