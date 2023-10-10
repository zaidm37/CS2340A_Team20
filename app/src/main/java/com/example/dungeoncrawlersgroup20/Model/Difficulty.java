package com.example.dungeoncrawlersgroup20.Model;

public class Difficulty {
    private String diff;
    private int diffLvl;
    public Difficulty() {
        this.diff = diff;
        this.diffLvl = diffLvl;
    }
    public String getDiff() {
        return diff;
    }
    public int getDiffLvl() {
        return diffLvl;
    }
    public void setEasy() {
        this.diff = "Easy";
        this.diffLvl = 1;
    }
    public void setMedium() {
        this.diff = "Medium";
        this.diffLvl = 2;
    }
    public void setHard() {
        this.diff = "Hard";
        this.diffLvl = 3;
    }
}
