package com.example.dungeoncrawlersgroup20.Model;

public abstract class PowerUp {
    protected int health;
    protected boolean wipe;
    protected int score;
    public abstract PowerUp power();
    public void setHealth(int h) {
        health = h;
    }
    public void setWipe(boolean w) {
        wipe = w;
    }
    public void setScore(int s) {
        score = s;
    }
    public int getHeath() {
        return health;
    }
    public boolean getWipe() {
        return wipe;
    }
    public int getScore() {
        return score;
    }
}
