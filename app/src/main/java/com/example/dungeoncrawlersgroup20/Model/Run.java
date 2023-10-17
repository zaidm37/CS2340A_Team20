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
    }
}
