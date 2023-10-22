package com.example.dungeoncrawlersgroup20;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Leaderboard;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.ViewModel.ConfigViewModel;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

import java.lang.reflect.Field;

public class JoshJUnitTests {
    //Sprint 2 Tests
    @Before
    @After
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Player.class.getDeclaredField("player");
        instance.setAccessible(true);
        instance.set(null, null);
    }
    @Test
    public void testSameSingleton() {
        Player player1 = Player.getPlayer();
        Player player2 = Player.getPlayer();
        assertSame("not same instance", player1, player2);
    }
    @Test
    public void testDifficulty() {
        Difficulty diff = new Difficulty();
        diff.setDiff("Easy");
        assertEquals("Easy", diff.getDiff());
        diff.setDiff("Hard");
        assertEquals("Hard", diff.getDiff());
        diff.setDiff("Medium");
        assertEquals("Medium", diff.getDiff());
    }

    //Sprint 3 Tests
    @Test
    public void testUpMovement() {
        GameViewModel gameViewModel = new GameViewModel();
        float startY = 100;
        int lowerBoundY = 50;
        startY = gameViewModel.up(startY, lowerBoundY);
        assertEquals(90, startY, 0.001);
    }
    @Test
    public void testDownMovement() {
        GameViewModel gameViewModel = new GameViewModel();
        float startY = 0;
        int limitY = 150;
        int spriteHeight = 52;
        startY = gameViewModel.down(startY, limitY, spriteHeight);
        assertEquals(10, startY, 0.001);
    }
}
