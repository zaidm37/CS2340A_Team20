package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Difficulty;
import com.example.dungeoncrawlersgroup20.Model.Leaderboard;

public class MuadhUnitTests {
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
}
