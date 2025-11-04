package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.FakeUI;
import se.sprinto.hakan.adventuregame.model.characters.Player;

class TavernRoomTest {

    Player player;
    FakeUI fakeUI;

    TavernRoom tavernRoom;

    @BeforeEach
    void setUp() {
        player = new Player.PlayerBuilder().name("player").score(0).health(100).strength(10).build();
        fakeUI = new FakeUI();
        tavernRoom = new TavernRoom();

    }

    @Test
    @DisplayName("The player asks for a good meal and health is increased.")
    void enterRoom() {
        fakeUI.setInput("1");
        int initialHealth = player.getHealth();
        tavernRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(initialHealth < player.getHealth());
    }

    @Test
    @DisplayName("The player asks for food and health is decreased.")
    void enterRoom2() {
        fakeUI.setInput("2");
        int initialHealth = player.getHealth();
        tavernRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(initialHealth > player.getHealth());
    }

    @Test
    @DisplayName("Player turns at the door and health is not affected")
    void enterRoom3() {
        fakeUI.setInput("3");
        int initialHealth = player.getHealth();
        tavernRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(initialHealth == player.getHealth());
    }
}