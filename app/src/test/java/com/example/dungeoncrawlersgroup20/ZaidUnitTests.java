package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.ViewModel.ConfigViewModel;
import com.example.dungeoncrawlersgroup20.ViewModel.GameViewModel;

public class ZaidUnitTests {
    //Sprint 2 Tests
    @Test
    public void testPlayerName() {
        ConfigViewModel configViewModel = new ConfigViewModel();
        Player player = Player.getPlayer();
        configViewModel.setPlayerName("Zaid");
        assertEquals("Zaid", configViewModel.getPlayerName());
        assertEquals("Zaid", player.getName());
    }
    @Test
    public void checkPlayerHealth() {
        ConfigViewModel configViewModel = new ConfigViewModel();
        Player player = Player.getPlayer();
        configViewModel.setPlayerHealth(300);
        assertEquals(300, configViewModel.getPlayerHealth());
        assertEquals(300, player.getHealth());
    }

    // Sprint 3 Tests
    @Test
    public void testLeftMovement() {
        GameViewModel gameViewModel = new GameViewModel();
        float startX = 100;
        startX = gameViewModel.left(startX);
        assertEquals(90, startX, 0.001);
    }
    @Test
    public void testRightMovement() {
        GameViewModel gameViewModel = new GameViewModel();
        float startX = 0;
        int limitX = 150;
        int spriteWidth = 44;
        startX = gameViewModel.right(startX, limitX, spriteWidth);
        assertEquals(10, startX, 0.001);
    }
}
