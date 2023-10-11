package com.example.dungeoncrawlersgroup20;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawlersgroup20.Model.Player;
import com.example.dungeoncrawlersgroup20.ViewModel.ConfigViewModel;

public class ZaidUnitTests {
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
}
