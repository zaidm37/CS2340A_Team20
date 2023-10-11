package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.ViewModel.EndViewModel;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

public class BenUnitTests {
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
}
