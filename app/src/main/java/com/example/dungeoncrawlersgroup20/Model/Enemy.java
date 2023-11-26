package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.Rect;
public abstract class Enemy implements Observer {
    int gum;
    int hum;
    int sprite;
    int damage;
    int speed;
    float enemyX;
    float enemyY;
    float enemyHeight;
    float enemyWidth;
    float borderHeight;
    float borderWidth;
    Player player = Player.getPlayer();
    public int getSprite() {
        return sprite;
    }
    public void setBorderHeight(float h) {
        borderHeight = h;
    }
    public void setBorderWidth(float w) {
        borderWidth = w;
    }
    public void attackPlayer() {
        if (player.getHealth() - damage >= 0) {
            player.setHealth(player.getHealth() - damage);
        } else {
            player.setHealth(0);
        }
//        player.setPlayerCollide(false);
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
    @Override
    public void update(Movement movement, float playerX, float playerY, boolean c) {
        if ((this.enemyX > playerX)) { //left
            enemyX = Math.max(enemyX - speed, 0);
        }
        if ((this.enemyX < playerX)) { //right
            enemyX = Math.min(enemyX + speed, borderWidth - enemyWidth);
        }
//        if ((this.enemyX == playerX)) { //equal
//            this.enemyX = playerX;
//        }
        if ((this.enemyY > playerY)) { //up
            enemyY = Math.max(enemyY - speed, ((borderHeight / 6) + 100));
        }
        if ((this.enemyY < playerY)) { //down
            enemyY = Math.min(enemyY + speed, (borderHeight - enemyHeight) - enemyHeight);
        }
        if (c) {
            attackPlayer();
            player.setPlayerCollide(false);
        }
    }
//    public boolean enemyCollision(Rect p, Rect e) {
//        if (Rect.intersects(p, e)) {
//            return true;
//        }
//        return false;
//    }
}
