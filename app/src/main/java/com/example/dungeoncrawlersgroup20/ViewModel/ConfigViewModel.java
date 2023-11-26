package com.example.dungeoncrawlersgroup20.ViewModel;

import android.graphics.drawable.Drawable;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Player;

public class ConfigViewModel extends ViewModel {
    private Player player;
    private Difficulty difficulty;
    public ConfigViewModel() {
        player = Player.getPlayer();
        difficulty = new Difficulty();
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
    public boolean isValidInput() {
        return (player.getName().trim().length() > 0)
                && (difficulty.getDiff().trim().length() > 0)
                && (player.getSprite() != null);
    }
    public void setSpriteNum(int num) {
        player.setSpriteNum(num);
    }
}
