package com.example.dungeoncrawlersgroup20.Model;

public class HealthPower extends PowerUpDecorator {
    public HealthPower(PowerUp pow) {
        this.pow = pow;
    }

    public PowerUp power() {
        pow.setHealth(1000);
        return pow;
    }
}
