package com.example.dungeoncrawlersgroup20.Model;

public class Run implements Movement {
    public float moveDown(float y, int border) {
        if (y + 40 >= border) {
            return (float) border;
        }
        return y + 40;
    }
    public float moveUp(float y) {
        if (y - 40 <= 0) {
            return 0;
        }
        return y - 40;
    }
    public float moveLeft(float x) {
        if (x - 40 <= 0) {
            return 0;
        }
        return x - 40;
    }
    public float moveRight(float x, int border) {
        if (x + 40 >= border) {
            return (float) border;
        }
        return x + 40;
    }
}
