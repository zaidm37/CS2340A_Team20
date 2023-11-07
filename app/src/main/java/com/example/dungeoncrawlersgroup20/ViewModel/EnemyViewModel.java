package com.example.dungeoncrawlersgroup20.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.dungeoncrawlersgroup20.Model.Enemy;
import com.example.dungeoncrawlersgroup20.Model.EnemyFactory;
import com.example.dungeoncrawlersgroup20.Model.GameEnemy;

public class EnemyViewModel extends ViewModel {
    private EnemyFactory enemyMaker;
    private Enemy easyEnemy;
    private Enemy mediumEnemy;
    private Enemy hardEnemy;
    private Enemy ultimateEnemy;
    public EnemyViewModel() {
        enemyMaker = new GameEnemy();
        easyEnemy = enemyMaker.orderEnemy("easy");
        mediumEnemy = enemyMaker.orderEnemy("medium");
        hardEnemy = enemyMaker.orderEnemy("hard");
        ultimateEnemy = enemyMaker.orderEnemy("ultimate");
    }
    public int spriteEasyEnemy() {
        return easyEnemy.getSprite();
    }
    public int spriteMediumEnemy() {
        return mediumEnemy.getSprite();
    }
    public int spriteHardEnemy() {
        return hardEnemy.getSprite();
    }
    public int spriteUltimateEnemy() {
        return ultimateEnemy.getSprite();
    }
}
