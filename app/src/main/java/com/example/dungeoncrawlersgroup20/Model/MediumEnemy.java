package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class MediumEnemy extends Enemy {
    public MediumEnemy() {
        this.player.addObserver(this);
        this.sprite = R.drawable.enemy2;
        this.speed = 2;
        this.damage = 20; // make all enemies deal 10?
        this.enemyX = enemyX;
        this.enemyY = enemyY;
        this.enemyHeight = enemyHeight;
        this.enemyWidth = enemyWidth;
    }
}
