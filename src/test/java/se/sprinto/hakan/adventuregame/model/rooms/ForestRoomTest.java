package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.FakeUI;
import se.sprinto.hakan.adventuregame.model.characters.Player;

class ForestRoomTest {

    FakeUI fakeUI;

    Player player;

    ForestRoom forestRoom;

    @BeforeEach
    void setUp() {
        this.fakeUI = new FakeUI();
        this.player = new Player.PlayerBuilder()
                .name("TestPlayer")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        this.forestRoom = new ForestRoom();
    }

    @Test
    @DisplayName("User finds key when entering 'ja' ")
    void enterRoom() {
        fakeUI.setInput("ja");
        forestRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(player.hasFoundKey());

    }
}