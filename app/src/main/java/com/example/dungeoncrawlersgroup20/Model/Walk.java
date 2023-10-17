package com.example.dungeoncrawlersgroup20.Model;

public class Walk implements Movement {
    public float moveDown(float y) {
        return y + 10;
    }
    public float moveUp(float y) {
        return y - 10;
    }
    public float moveLeft(float x) {
        return x - 10;
    }
    public float moveRight(float x) {
        return x + 10;
    }
}
