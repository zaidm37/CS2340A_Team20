package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.EasyEnemy;
import com.example.dungeoncrawlersgroup20.Model.Enemy;
import com.example.dungeoncrawlersgroup20.Model.EnemyFactory;
import com.example.dungeoncrawlersgroup20.Model.GameEnemy;
import com.example.dungeoncrawlersgroup20.Model.HardEnemy;
import com.example.dungeoncrawlersgroup20.Model.Leaderboard;
import com.example.dungeoncrawlersgroup20.Model.MediumEnemy;
import com.example.dungeoncrawlersgroup20.Model.UltimateEnemy;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

public class MuadhUnitTests {
    //Sprint 2 Tests
    @Test
    public void testTopScoresCompare() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.setBest1(300);
        leaderboard.setBest2(900);
        if (leaderboard.getBest2() > leaderboard.getBest1()) {
            int tmp = leaderboard.getBest1();
            leaderboard.setBest1(leaderboard.getBest2());
            leaderboard.setBest2(tmp);
        }
        assertEquals(900, leaderboard.getBest1());
        assertEquals(300, leaderboard.getBest2());
    }
    @Test
    public void testTopStringsCompare() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.setString1("YO");
        leaderboard.setString2("HI");
        String tmp = leaderboard.getString1();
        leaderboard.setString1(leaderboard.getString2());
        leaderboard.setString2(tmp);
        assertEquals("HI", leaderboard.getString1());
        assertEquals("YO", leaderboard.getString2());
    }

    //Sprint 3 Tests
    @Test
    public void testLeftWallCollision() {
        GameViewModel gameViewModel = new GameViewModel();
        float startX = 1;
        startX = gameViewModel.left(startX);
        assertEquals(0, startX, 0.001);
    }
    @Test
    public void testRightWallCollision() {
        GameViewModel gameViewModel = new GameViewModel();
        float startX = 100;
        int limitX = 150;
        int spriteWidth = 44;
        startX = gameViewModel.right(startX, limitX, spriteWidth);
        assertEquals(limitX - spriteWidth, startX, 0.001);
    }

    //Sprint 4 Tests

    @Test
    public void testFactoryHard() {
        EnemyFactory ef = new GameEnemy();
        Enemy hard = ef.orderEnemy("hard");
        assertTrue(hard instanceof HardEnemy);
    }

    @Test
    public void testFactoryUlt() {
        EnemyFactory ef = new GameEnemy();
        Enemy ult = ef.orderEnemy("ultimate");
        assertTrue(ult instanceof UltimateEnemy);
    }
}
