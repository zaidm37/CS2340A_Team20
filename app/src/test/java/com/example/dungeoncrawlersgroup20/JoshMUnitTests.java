package com.example.dungeoncrawlersgroup20;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Leaderboard;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.Run;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

import java.lang.reflect.Field;

public class JoshMUnitTests {
    //Sprint 2 Tests
    @Before
    @After
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Leaderboard.class.getDeclaredField("leaderboard");
        instance.setAccessible(true);
        instance.set(null, null);
    }
    @Test
    public void testSameSingleton() {
        Leaderboard leaderboard1 = Leaderboard.getLeaderboard();
        Leaderboard leaderboard2 = Leaderboard.getLeaderboard();
        assertSame("not same instance", leaderboard1, leaderboard2);
    }
    @Test
    public void testLeaderboardSetScore() {
        Leaderboard leaderboard1 = Leaderboard.getLeaderboard();
        leaderboard1.setBest1(300);
        assertEquals(300, leaderboard1.getBest1());
    }

    //Sprint 3 Tests
    @Test
    public void testMovementChangeLeft() {
        GameViewModel gameViewModel = new GameViewModel();
        Player.getPlayer().setMovement(new Run());
        float startX = 100;
        startX = gameViewModel.left(startX);
        assertEquals(60, startX, 0.001);
    }
    @Test
    public void testMovementChangeRight() {
        GameViewModel gameViewModel = new GameViewModel();
        Player.getPlayer().setMovement(new Run());
        float startX = 0;
        int limitX = 150;
        int spriteWidth = 44;
        startX = gameViewModel.right(startX, limitX, spriteWidth);
        assertEquals(40, startX, 0.001);
    }
}
