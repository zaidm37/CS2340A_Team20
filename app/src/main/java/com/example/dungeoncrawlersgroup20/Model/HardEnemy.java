package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class HardEnemy extends Enemy {
    public HardEnemy() {
        this.player.addObserver(this);
        this.sprite = R.drawable.enemy3;
        this.speed = 8;
        this.damage = 150;
        this.enemyX = enemyX;
        this.enemyY = enemyY;
        this.enemyHeight = enemyHeight;
        this.enemyWidth = enemyWidth;
    }
}
