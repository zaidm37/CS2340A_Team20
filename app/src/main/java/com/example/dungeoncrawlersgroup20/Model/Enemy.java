package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

public abstract class Enemy implements Observer {
    Movement movement;
    int sprite;
    int damage;
    public int getSprite() {
        return sprite;
    }
    public float enemyMoveUp(float y, int textHeight) {
        return movement.moveUp(y, textHeight);
    }
    public float enemyMoveDown(float y, int screenHeight, int spriteHeight) {
        return movement.moveDown(y, screenHeight - spriteHeight, spriteHeight);
    }
    public float enemyMoveLeft(float x) {
        return movement.moveLeft(x);
    }
    public float enemyMoveRight(float x, int border, int spriteWidth) {
        return movement.moveRight(x, border, spriteWidth);
    }
}
