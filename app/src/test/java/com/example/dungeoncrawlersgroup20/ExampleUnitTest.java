package com.example.dungeoncrawlersgroup20;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


import java.lang.reflect.Field;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Before
    @After
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Leaderboard.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }
    @Test
    public void testSameSingleton() {
        Leaderboard leaderboard1 = Leaderboard.getInstance();
        Leaderboard leaderboard2 = Leaderboard.getInstance();
        assertSame("not same instance", leaderboard1, leaderboard2);
    }
    @Test
    public void testSameHashCodeSingleton() {
        Leaderboard leaderboard1 = Leaderboard.getInstance();
        Leaderboard leaderboard2 = Leaderboard.getInstance();
        assertEquals(leaderboard1.hashCode(), leaderboard2.hashCode());
    }



}