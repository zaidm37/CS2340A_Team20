package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class UltimateEnemy extends Enemy {
    public UltimateEnemy() {
        player.addObserver(this);
        this.sprite = R.drawable.enemy4;
        this.speed = 5;
        this.damage = 200;
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
