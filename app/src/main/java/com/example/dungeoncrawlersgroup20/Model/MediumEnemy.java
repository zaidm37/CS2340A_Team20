package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class MediumEnemy extends Enemy {
    private Player player;
    public MediumEnemy() {
        player = Player.getPlayer();
        player.addObserver(this);
        this.sprite = R.drawable.enemy2;
        this.movement = movement;
        this.damage = 100;
    }
    @Override
    public void update(Movement movement, float playerX, float playerY) {
        // control enemy placement
    }
}
