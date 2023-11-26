package com.example.dungeoncrawlersgroup20.Model;

public class KillPower extends PowerUpDecorator {
    public KillPower(PowerUp pow) {
        this.pow = pow;
    }

    public PowerUp power() {
        pow.setWipe(true);
        return pow;
    }
}
