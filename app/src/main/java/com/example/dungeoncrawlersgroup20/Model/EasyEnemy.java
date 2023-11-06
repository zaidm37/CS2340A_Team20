package com.example.dungeoncrawlersgroup20.Model;

import com.example.dungeoncrawlersgroup20.R;

public class EasyEnemy extends Enemy {
    private Player player;
    public EasyEnemy() {
        player = Player.getPlayer();
        player.addObserver(this);
        this.sprite = R.drawable.enemy1;
        this.movement = movement;
        this.damage = 50;
    }
    @Override
    public void update(Movement movement, float playerX, float playerY) {
        // control enemy placement
    }
}
