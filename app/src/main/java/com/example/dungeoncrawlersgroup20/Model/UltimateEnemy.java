package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class UltimateEnemy extends Enemy {
    private Player player;
    public UltimateEnemy() {
        player = Player.getPlayer();
        player.addObserver(this);
        this.sprite = R.drawable.enemy4;
        this.movement = movement;
        this.damage = 200;
    }
    @Override
    public void update(Movement movement, float playerX, float playerY) {
        // control enemy placement
    }
}
