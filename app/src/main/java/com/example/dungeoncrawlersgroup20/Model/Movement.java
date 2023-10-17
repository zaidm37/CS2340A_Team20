package com.example.dungeoncrawlersgroup20.Model;

public interface Movement {
    //do something
    abstract float moveUp(float y);
    abstract float moveDown(float y);
    abstract float moveLeft(float x);
    abstract float moveRight(float x);
}
