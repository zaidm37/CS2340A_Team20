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
        }
    }
    public void setEnemyX(String type, float x) {
        if (type.equals("easy")) {
            easyEnemy.setX(x);
        } else if (type.equals("medium")) {
            mediumEnemy.setX(x);
        } else if (type.equals("hard")) {
            hardEnemy.setX(x);
        } else if (type.equals("ultimate")) {
            ultimateEnemy.setX(x);
        }
    }
    public void setEnemyY(String type, float y) {
        if (type.equals("easy")) {
            easyEnemy.setY(y);
        } else if (type.equals("medium")) {
            mediumEnemy.setY(y);
        } else if (type.equals("hard")) {
            hardEnemy.setY(y);
        } else if (type.equals("ultimate")) {
            ultimateEnemy.setY(y);
        }
    }
    public float getEnemyX(String type) {
        if (type.equals("easy")) {
            return easyEnemy.getX();
        } else if (type.equals("medium")) {
            return mediumEnemy.getX();
        } else if (type.equals("hard")) {
            return hardEnemy.getX();
        } else if (type.equals("ultimate")) {
            return ultimateEnemy.getX();
        } else {
            return -1;
        }
    }
    public float getEnemyY(String type) {
        if (type.equals("easy")) {
            return easyEnemy.getY();
        } else if (type.equals("medium")) {
            return mediumEnemy.getY();
        } else if (type.equals("hard")) {
            return hardEnemy.getY();
        } else if (type.equals("ultimate")) {
            return ultimateEnemy.getY();
        } else {
            return -1;
        }
    }
}
