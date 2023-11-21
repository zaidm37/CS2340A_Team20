package com.example.dungeoncrawlersgroup20.Model;

public abstract class EnemyFactory {
    public Enemy orderEnemy(String type) {
        Enemy enemy;

        enemy = createEnemy(type);

        return enemy;
    }

    //factory method
    abstract Enemy createEnemy(String type);
}
