package com.example.dungeoncrawlersgroup20.Model;

public class Walk implements Movement {
    public float moveDown(float y, int border, int spriteHeight) {
        float newY = y + 10;
        return Math.min(newY, border - spriteHeight);
    }
    public float moveUp(float y, int textHeight) {
        float newY = y - 10;
        return Math.max(newY, textHeight);
    }
    public float moveLeft(float x) {
        float newX = x - 10;
        return Math.max(newX, 0);
    }
    public float moveRight(float x, int border, int spriteWidth) {
        float newX = x + 10;
        return Math.min(newX, border - spriteWidth);
    }
}
