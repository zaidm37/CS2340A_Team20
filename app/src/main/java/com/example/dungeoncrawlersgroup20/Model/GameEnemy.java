package com.example.dungeoncrawlersgroup20.Model;

public class GameEnemy extends EnemyFactory {
    Enemy createEnemy(String type) {
        if (type.equals("easy")) {
            return new EasyEnemy();
        } else if (type.equals("medium")) {
            return new MediumEnemy();
        } else if (type.equals("hard")) {
            return new HardEnemy();
        } else if (type.equals("ultimate")) {
            return new UltimateEnemy();
        } else {
            return null;
        }
    }
}
