package com.example.dungeoncrawlersgroup20.Model;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Leaderboard {
    private int finalScore;
    private String date;
    private Calendar calender;
    private SimpleDateFormat dateFormat;
    private int best1;
    private int best2;
    private int best3;
    private int best4;
    private int best5;
    private String finalString;
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private static volatile Leaderboard leaderboard;
    private Leaderboard() {
    }
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }
    public String getDate() {
        calender = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        date = dateFormat.format(calender.getTime());
        return date;
    }
    public int getFinalScore() {
        return this.finalScore;
    }
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
    public int getBest1() {
        return this.best1;
    }
    public void setBest1(int score) {
        this.best1 = score;
    }
    public int getBest2() {
        return this.best2;
    }
    public void setBest2(int score) {
        this.best2 = score;
    }
    public int getBest3() {
        return this.best3;
    }
    public void setBest3(int score) {
        this.best3 = score;
    }
    public int getBest4() {
        return this.best4;
    }
    public void setBest4(int score) {
        this.best4 = score;
    }
    public int getBest5() {
        return this.best5;
    }
    public void setBest5(int score) {
        this.best5 = score;
    }
    public String getFinalString() {
        return this.finalString;
    }
    public void setFinalString(String message) {
        this.finalString = message;
    }
    public String getString1() {
        return this.string1;
    }
    public void setString1(String message) {
        this.string1 = message;
    }
    public String getString2() {
        return this.string2;
    }
    public void setString2(String message) {
        this.string2 = message;
    }
    public String getString3() {
        return this.string3;
    }
    public void setString3(String message) {
        this.string3 = message;
    }
    public String getString4() {
        return this.string4;
    }
    public void setString4(String message) {
        this.string4 = message;
    }
    public String getString5() {
        return this.string5;
    }
    public void setString5(String message) {
        this.string5 = message;
    }
}
