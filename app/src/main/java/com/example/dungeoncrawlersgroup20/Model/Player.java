package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Player implements Observable {
    private Movement movement;
    private String name;
    private int health;
    private Drawable sprite;
    private ArrayList<Observer> observers;
    private static volatile Player player;
    private Player() {
        this.name = name;
        this.health = health;
        this.sprite = sprite;
        this.movement = movement;
//        this.observers = new ArrayList<Observer>();
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
//        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
//        int i = observers.indexOf(observer);
//        if (i >= 0) {
//            observers.remove(i);
//        }
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
//            observer.update(this.movement);
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
    public void setMovement(Movement movement) {
        this.movement = movement;
//        notifyObservers();
    }
    public float playerMoveUp(float y, int textHeight) {
        return movement.moveUp(y, textHeight);
    }
    public float playerMoveDown(float y, int screenHeight, int spriteHeight) {
        return movement.moveDown(y, screenHeight - spriteHeight, spriteHeight);
    }
    public float playerMoveLeft(float x) {
        return movement.moveLeft(x);
    }
    public float playerMoveRight(float x, int border, int spriteWidth) {
        return movement.moveRight(x, border, spriteWidth);
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
}
