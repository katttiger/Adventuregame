package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Enemy;
import se.sprinto.hakan.adventuregame.model.characters.Player;

class PlayerTest {

    Player player;
    Enemy enemy;

    @BeforeEach
    void setUp() {
        this.player = new Player.PlayerBuilder()
                .name("TestPlayer")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        this.enemy = new Enemy("Vätte", 20, 0, 5);


    }

    @Test
    void attack() {
        int enemyInitialHealth = enemy.getHealth();
        player.attack(enemy);
        Assertions.assertEquals(enemy.getHealth(), (enemyInitialHealth - player.getStrength()));
    }
}