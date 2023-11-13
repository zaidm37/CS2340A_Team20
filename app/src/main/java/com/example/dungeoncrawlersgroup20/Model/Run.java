package com.example.dungeoncrawlersgroup20.Model;

public class Run implements Movement {

    public float moveDown(float y) {
        return y + 40;
    }
    public float moveUp(float y) {
        return y - 40;
    }
    public float moveLeft(float x) {
        return x - 40;
    }
    public float moveRight(float x) {
        return x + 40;

    public float moveDown(float y, int border, int spriteHeight) {
        float newY = y + 40;
        return Math.min(newY, border - spriteHeight);
    }
    public float moveUp(float y, int textHeight) {
        float newY = y - 40;
        return Math.max(newY, textHeight);
    }
    public float moveLeft(float x) {
        float newX = x - 40;
        return Math.max(newX, 0);
    }
    public float moveRight(float x, int border, int spriteWidth) {
        float newX = x + 40;
        return Math.min(newX, border - spriteWidth);

    }
}
