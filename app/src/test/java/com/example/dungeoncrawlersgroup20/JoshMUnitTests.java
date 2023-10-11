package com.example.dungeoncrawlersgroup20;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Leaderboard;

import java.lang.reflect.Field;

public class JoshMUnitTests {
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
}
