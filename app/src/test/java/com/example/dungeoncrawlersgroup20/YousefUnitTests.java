package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.Run;
import com.example.dungeoncrawlersgroup20.Model.Score;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

public class YousefUnitTests {
    //Sprint 2 Tests
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

    //Sprint 3 Tests
    @Test
    public void testMovementChangeUp() {
        GameViewModel gameViewModel = new GameViewModel();
        Player.getPlayer().setMovement(new Run());
        float startY = 100;
        int lowerBoundY = 50;
        startY = gameViewModel.up(startY, lowerBoundY);
        assertEquals(60, startY, 0.001);
    }
    @Test
    public void testMovementChangeDown() {
        GameViewModel gameViewModel = new GameViewModel();
        Player.getPlayer().setMovement(new Run());
        float startY = 0;
        int limitY = 150;
        int spriteHeight = 52;
        startY = gameViewModel.down(startY, limitY, spriteHeight);
        assertEquals(40, startY, 0.001);
    }
}
