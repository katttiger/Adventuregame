package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.rooms.mockclasses.FakeUI;

class DungeonRoomTest {

    FakeUI fakeUI;
    DungeonRoom dungeonRoom;

    Player player;

    @BeforeEach
    void setUp() {
        this.fakeUI = new FakeUI();
        this.player = new Player.Builder()
                .name("TestPlayer")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        this.dungeonRoom = new DungeonRoom();
    }

    @Test
    @DisplayName("Player attacks enemy and kills it")
    void enterRoom() {
        fakeUI.setInput("a");
        dungeonRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(player.hasDefeatedEnemy());
    }
}