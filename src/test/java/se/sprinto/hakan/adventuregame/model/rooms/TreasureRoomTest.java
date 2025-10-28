package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.rooms.mockclasses.FakeUI;

class TreasureRoomTest {
    FakeUI fakeUI;
    Player player;
    TreasureRoom treasureRoom;

    @BeforeEach
    void setUp() {
        this.fakeUI = new FakeUI();
        this.player = new Player.Builder()
                .name("TestPlayer")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        this.treasureRoom = new TreasureRoom();
    }

    @Test
    @DisplayName("Player tries to open without key")
    void enterRoom() {
        fakeUI.setInput("ja");
        player.setFoundKey(false);
        treasureRoom.enterRoom(player, fakeUI);
        Assertions.assertFalse(player.hasOpenedChest());
    }

    @Test
    @DisplayName("Player tries to open with key")
    void enterRoom2() {
        fakeUI.setInput("ja");
        player.setFoundKey(true);
        treasureRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(player.hasOpenedChest());
    }
}