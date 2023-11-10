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
    public int enemySprite(String type) {
        if (type.equals("easy")) {
            return easyEnemy.getSprite();
        } else if (type.equals("medium")) {
            return mediumEnemy.getSprite();
        } else if (type.equals("hard")) {
            return hardEnemy.getSprite();
        } else if (type.equals("ultimate")) {
            return ultimateEnemy.getSprite();
        } else {
            return -1;
        }
    }
    public void enemyAttack(String type) {
        if (type.equals("easy")) {
            easyEnemy.attackPlayer();
        } else if (type.equals("medium")) {
            mediumEnemy.attackPlayer();
        } else if (type.equals("hard")) {
            hardEnemy.attackPlayer();
        } else if (type.equals("ultimate")) {
            ultimateEnemy.attackPlayer();
        } else {
            return;
        }
    }
}
