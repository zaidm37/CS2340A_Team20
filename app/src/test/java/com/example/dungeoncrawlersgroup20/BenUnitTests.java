package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.ViewModel.EndViewModel;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

public class BenUnitTests {
    //Sprint 2 Tests
    @Test
    public void checkScoreNotNegative() {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setPlayerScore(1000);
        for (int i = 0; i < 100; i++) {
            gameViewModel.reduceScore();
        }
        assertEquals(0, gameViewModel.getPlayerScore());
    }
    @Test
    public void checkLeaderboardString() {
        EndViewModel endViewModel = new EndViewModel();
        endViewModel.setLFinalString("Ben 04/19/2023 04:05:23");
        endViewModel.setLFinalScore(900);
        assertEquals("900 Ben 04/19/2023 04:05:23", endViewModel.getLFinalScore()
                + " " + endViewModel.getLFinalString());
    }

    //Sprint 3 Tests
    @Test
    public void testUpWallCollision() {
        GameViewModel gameViewModel = new GameViewModel();
        float startY = 51;
        int lowerBoundY = 50;
        startY = gameViewModel.up(startY, lowerBoundY);
        assertEquals(lowerBoundY, startY, 0.001);
    }
    @Test
    public void testDownWallCollision() {
        GameViewModel gameViewModel = new GameViewModel();
        float startY = 100;
        int limitY = 150;
        int spriteHeight = 52;
        startY = gameViewModel.down(startY, limitY, spriteHeight);
        assertEquals((limitY - spriteHeight) - spriteHeight, startY, 0.001);
    }
}
