package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

public abstract class Enemy implements Observer {
    Movement movement;
    Drawable sprite;
    int damage;
    public Drawable getSprite() {
        return sprite;
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
    public void setSprite(Drawable sprite) {
        this.sprite = sprite;
    }
}
