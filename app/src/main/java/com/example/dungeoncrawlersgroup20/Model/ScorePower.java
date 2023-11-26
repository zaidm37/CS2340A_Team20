package com.example.dungeoncrawlersgroup20.Model;

public class ScorePower extends PowerUpDecorator {
    public ScorePower(PowerUp pow) {
        this.pow = pow;
    }

    public PowerUp power() {
        pow.setScore(400);
        return pow;
    }
}
