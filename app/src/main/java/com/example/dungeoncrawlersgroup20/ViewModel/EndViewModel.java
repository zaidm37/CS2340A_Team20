package com.example.dungeoncrawlersgroup20.ViewModel;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.Leaderboard;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.Score;

public class EndViewModel extends ViewModel {
    private Player player;
    private Score scoreTrack;
    private Leaderboard leaderboard;
    public EndViewModel() {
        player = Player.getPlayer();
        scoreTrack = new Score();
        leaderboard = Leaderboard.getLeaderboard();
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
    public int getPlayerScore() {
        return scoreTrack.getScore();
    }
    public void setPlayerScore(int score) {
        scoreTrack.setScore(score);
    }
    public String getCurrentDate() {
        return leaderboard.getDate();
    }
    public int getLFinalScore() {
        return leaderboard.getFinalScore();
    }
    public void setLFinalScore(int finalScore) {
        leaderboard.setFinalScore(finalScore);
    }
    public int getLBest1() {
        return leaderboard.getBest1();
    }
    public void setLBest1(int score) {
        leaderboard.setBest1(score);
    }
    public int getLBest2() {
        return leaderboard.getBest2();
    }
    public void setLBest2(int score) {
        leaderboard.setBest2(score);
    }
    public int getLBest3() {
        return leaderboard.getBest3();
    }
    public void setLBest3(int score) {
        leaderboard.setBest3(score);
    }
    public int getLBest4() {
        return leaderboard.getBest4();
    }
    public void setLBest4(int score) {
        leaderboard.setBest4(score);
    }
    public int getLBest5() {
        return leaderboard.getBest5();
    }
    public void setLBest5(int score) {
        leaderboard.setBest5(score);
    }
    public String getLFinalString() {
        return leaderboard.getFinalString();
    }
    public void setLFinalString(String message) {
        leaderboard.setFinalString(message);
    }
    public String getLString1() {
        return leaderboard.getString1();
    }
    public void setLString1(String message) {
        leaderboard.setString1(message);
    }
    public String getLString2() {
        return leaderboard.getString2();
    }
    public void setLString2(String message) {
        leaderboard.setString2(message);
    }
    public String getLString3() {
        return leaderboard.getString3();
    }
    public void setLString3(String message) {
        leaderboard.setString3(message);
    }
    public String getLString4() {
        return leaderboard.getString4();
    }
    public void setLString4(String message) {
        leaderboard.setString4(message);
    }
    public String getLString5() {
        return leaderboard.getString5();
    }
    public void setLString5(String message) {
        leaderboard.setString5(message);
    }
}
