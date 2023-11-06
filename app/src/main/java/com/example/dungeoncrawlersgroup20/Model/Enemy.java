package com.example.dungeoncrawlersgroup20.Model;

import android.graphics.drawable.Drawable;

public abstract class Enemy implements Observer {
    int sprite;
    int damage;
    int speed;
    public int getSprite() {
        return sprite;
    }
}
