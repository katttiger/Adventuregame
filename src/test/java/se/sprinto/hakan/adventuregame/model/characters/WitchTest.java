package se.sprinto.hakan.adventuregame.model.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WitchTest {

    Player player;
    Witch witch;

    @BeforeEach
    void setUp() {
        player = new Player.Builder().name("Player1").strength(10).health(100).score(0).build();
        witch = new Witch("Witch", 25, 0, 10);
    }

    @Test
    void healPlayerNormal() {
        int playerInitialHealth = player.getHealth();
        witch.healPlayerNormal(player);
        Assertions.assertTrue(playerInitialHealth < player.getHealth());
    }

    @Test
    void healPlayerBoost() {
        int playerInitialHealth = player.getHealth();
        witch.healPlayerBoost(player);
        Assertions.assertTrue(playerInitialHealth < player.getHealth());
    }

    @Test
    void attack() {
        int playerInitialHealth = player.getHealth();
        witch.attack(player);
        Assertions.assertTrue(player.getHealth() < playerInitialHealth);
    }
}