package com.example.dungeoncrawlersgroup20;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.BasePower;
import com.example.dungeoncrawlersgroup20.Model.EasyEnemy;
import com.example.dungeoncrawlersgroup20.Model.Enemy;
import com.example.dungeoncrawlersgroup20.Model.EnemyFactory;
import com.example.dungeoncrawlersgroup20.Model.GameEnemy;
import com.example.dungeoncrawlersgroup20.Model.HardEnemy;
import com.example.dungeoncrawlersgroup20.Model.HealthPower;
import com.example.dungeoncrawlersgroup20.Model.KillPower;
import com.example.dungeoncrawlersgroup20.Model.Leaderboard;
import com.example.dungeoncrawlersgroup20.Model.MediumEnemy;
import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.Model.PowerUp;
import com.example.dungeoncrawlersgroup20.Model.Run;
import com.example.dungeoncrawlersgroup20.Model.ScorePower;
import com.example.dungeoncrawlersgroup20.Model.UltimateEnemy;
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

    //Sprint 4 Tests

    @Test
    public void testFactoryEasy() {
        EnemyFactory ef = new GameEnemy();
        Enemy easy = ef.orderEnemy("easy");
        assertTrue(easy instanceof EasyEnemy);
    }
    @Test
    public void testFactoryMid() {
        EnemyFactory ef = new GameEnemy();
        Enemy mid = ef.orderEnemy("medium");
        assertTrue(mid instanceof MediumEnemy);
    }

    //Sprint 5
    @Test
    public void testScoreDecorator() {
        PowerUp pow = new BasePower();
        assertEquals( pow.getScore(), 0);
        pow = new ScorePower(pow);
        pow = pow.power();

        assertEquals( pow.getScore(), 400);
    }
    @Test
    public void testWipeDecorator() {
        PowerUp pow = new BasePower();
        assertFalse(pow.getWipe());
        pow = new KillPower(pow);
        pow = pow.power();

        assertTrue(pow.getWipe());
    }
}
