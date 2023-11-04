package com.example.dungeoncrawlersgroup20.Model;

public class HardEnemy extends Enemy {
    private Player player;
    private HardEnemy() {
        player = Player.getPlayer();
        player.addObserver(this);
        this.sprite = sprite;
        this.movement = movement;
        this.damage = damage;
    }
    @Override
    public void update(Movement movement, float playerX, float playerY) {
        // control enemy placement
    }
}
