package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class EasyEnemy extends Enemy {
    public EasyEnemy() {
        player.addObserver(this);
        this.sprite = R.drawable.enemy1;
        this.speed = 1;
        this.damage = 50;
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
