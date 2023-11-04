package com.example.dungeoncrawlersgroup20.Model;

public class UltimateEnemy extends Enemy {
    private Player player;
    private UltimateEnemy() {
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
