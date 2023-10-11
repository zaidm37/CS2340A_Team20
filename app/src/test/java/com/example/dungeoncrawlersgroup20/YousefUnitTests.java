package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Score;

public class YousefUnitTests {
    @Test
    public void startScoreCheck() {
        Score score = new Score();
        score.setScore(1000);
        assertEquals(1000, score.getScore());
    }
    @Test
    public void scoreDecreaseCheck() {
        Score score = new Score();
        score.setScore(1000);
        score.setScore(score.getScore() - 50);
        assertEquals(950, score.getScore());
    }
}
