package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

public class Player {
    private Movement movement;
    private String name;
    private int health;
    private Drawable sprite;
    private static volatile Player player;
    private Player() {
        this.name = name;
        this.health = health;
        this.sprite = sprite;
        this.movement = movement;
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
    }
    public float playerMoveUp(float y, int screenHeight) {
        int upperQuart = screenHeight / 3;
        return movement.moveUp(y, upperQuart);
    }
    public float playerMoveDown(float y, int screenHeight, int spriteHeight) {
        return movement.moveDown(y, screenHeight - spriteHeight, spriteHeight);
    }
    public float playerMoveLeft(float x) {
        return movement.moveLeft(x);
    }
    public float playerMoveRight(float x, int border, int spriteHeight) {
        return movement.moveRight(x, border, spriteHeight);
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
