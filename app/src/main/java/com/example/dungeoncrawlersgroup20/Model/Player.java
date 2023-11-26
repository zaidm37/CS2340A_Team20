package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Player implements Observable {
    private Movement movement;
    private String name;
    private int health;
    private Drawable sprite;
    private float playerX;
    private float playerY;
    private int playerWidth;
    private int playerHeight;
    private boolean c;
    private int spriteNum;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private static volatile Player player;

    private Player() {
        this.name = name;
        this.health = health;
        this.sprite = sprite;
        this.movement = movement;
        this.c = false;
    }

    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }
            }
        }
        return player;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.movement, this.playerX, this.playerY, this.c);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Drawable getSprite() {
        return sprite;
    }


    //public void attackEnemy() {
    //    if (checkCollision) {
    //      enemyHealth -= 10;
    //    }
    //    enemyHealth
    // }
    public void setMovement(Movement movement) {
        this.movement = movement;
        notifyObservers();
    }
    public float playerMoveUp(float y, int textHeight) {
        playerY = movement.moveUp(y, textHeight);
        notifyObservers();
        return playerY;
    }
    public float playerMoveDown(float y, int screenHeight, int spriteHeight) {
        playerY = movement.moveDown(y, screenHeight - spriteHeight, spriteHeight);
        notifyObservers();
        return playerY;
    }
    public float playerMoveLeft(float x) {
        playerX = movement.moveLeft(x);
        notifyObservers();
        return playerX;
    }
    public float playerMoveRight(float x, int border, int spriteWidth) {
        playerX = movement.moveRight(x, border, spriteWidth);
        notifyObservers();
        return playerX;
    }
    public float getPlayerX() {
        notifyObservers();
        return playerX;
    }
    public float getPlayerY() {
        notifyObservers();
        return playerY;
    }
    public void setPlayerX(float x) {
        playerX = x;
    }
    public void setPlayerY(float y) {
        playerY = y;
    }
    public boolean checkPlayerCollide(Rect p, Rect e) {
        if (Rect.intersects(p, e)) {
            c = true;
        }
        return c;
    }
    public void setPlayerCollide(boolean c) {
        this.c = c;
    }
    public boolean getPlayerC() {
        return c;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setSprite(Drawable sprite) {
        this.sprite = sprite;
    }
    public int getPlayerHeight() {
        return playerHeight;
    }
    public int getPlayerWidth() {
        return playerWidth;
    }
    public void setPlayerHeight(int h) {
        playerHeight = h;
    }
    public void setPlayerWidth(int w) {
        playerWidth = w;
    }
    public int getSpriteNum() {
        return this.spriteNum;
    }
    public void setSpriteNum(int num) {
        this.spriteNum = num;
    }
}
