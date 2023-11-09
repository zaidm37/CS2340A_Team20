package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

public abstract class Enemy implements Observer {
    int sprite;
    int damage;
    int speed;
    float enemyX;
    float enemyY;
    float enemyHeight;
    float enemyWidth;
    Player player = Player.getPlayer();
    public int getSprite() {
        return sprite;
    }
    public void attackPlayer() {
        if (player.getHealth() - damage >= 0) {
            player.setHealth(player.getHealth() - damage);
        } else {
            player.setHealth(0);
        }
        return;
    }
    public float getX() {
        return enemyX;
    }
    public float getY() {
        return enemyY;
    }
    public float getWidth() {
        return enemyWidth;
    }
    public float getHeight() {
        return enemyHeight;
    }
    public void setX(float x) {
        enemyX = x;
    }
    public void setY(float y) {
        enemyY = y;
    }
    public void setWidth(float w) {
        enemyWidth = w;
    }
    public void setHeight(float h) {
        enemyHeight = h;
    }
}
