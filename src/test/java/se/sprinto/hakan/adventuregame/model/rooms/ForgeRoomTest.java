package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Smith;

class ForgeRoomTest {

    Player player;
    Smith smith;

    @BeforeEach
    void setUp() {
        player = new Player.PlayerBuilder().name("Player").score(0).health(100).strength(10).build();
        smith = new Smith("Smith", 15, 0, 80);
    }

    @Test
    @DisplayName("Player strength is increased.")
    void enterRoom() {
        int initialStrength = player.getStrength();
        smith.increasePlayerStrength(player);
        Assertions.assertTrue(player.getStrength() > initialStrength);
    }
}