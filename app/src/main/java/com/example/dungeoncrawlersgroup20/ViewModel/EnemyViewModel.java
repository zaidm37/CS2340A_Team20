package com.example.dungeoncrawlersgroup20.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.EnemyFactory;
import com.example.dungeoncrawlersgroup20.Model.GameEnemy;

public class EnemyViewModel extends ViewModel {
    private EnemyFactory enemyMaker;
    public EnemyViewModel() {
        enemyMaker = new GameEnemy();
    }
}
