package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class HardEnemy extends Enemy {
    public HardEnemy() {
        player.addObserver(this);
        this.sprite = R.drawable.enemy3;
        this.speed = 3;
        this.damage = 150;
        this.enemyX = enemyX;
        this.enemyY = enemyY;
        this.enemyHeight = enemyHeight;
        this.enemyWidth = enemyWidth;
    }
    @Override
    public void update(Movement movement, float playerX, float playerY) {
        // control enemy placement
    }
}
