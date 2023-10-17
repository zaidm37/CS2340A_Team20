package com.example.dungeoncrawlersgroup20.Model;

public class Walk implements Movement {
    public float moveDown(float y, int border) {
        if (y + 10 >= border) {
            return (float) border;
        }
        return y + 10;
    }
    public float moveUp(float y) {
        if (y - 10 <= 0) {
            return 0;
        }
        return y - 10;
    }
    public float moveLeft(float x) {
        if (x - 10 <= 0) {
            return 0;
        }
        return x - 10;
    }
    public float moveRight(float x, int border) {
        if (x + 10 >= border) {
            return (float) border;
        }
        return x + 10;
    }
}
