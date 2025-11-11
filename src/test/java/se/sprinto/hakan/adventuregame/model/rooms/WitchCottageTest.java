package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.FakeUI;
import se.sprinto.hakan.adventuregame.model.characters.Enemy;
import se.sprinto.hakan.adventuregame.model.characters.Player;

class WitchCottageTest {

    Player fakePlayer;
    Enemy witch;

    FakeUI fakeUI;

    WitchCottage witchCottage;

    @BeforeEach
    void setUp() {
        this.fakeUI = new FakeUI();
        this.fakePlayer = new Player.PlayerBuilder()
                .name("TestPlayer")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        this.witch = new Enemy("Witch", 10, 0, 10);
        this.witchCottage = new WitchCottage();

    }

    @Test
    @DisplayName("Player enters room and asks for help. Health is increased.")
    void enterRoomAndAskForHelp() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("1");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth + 10);
    }

    @Test
    @DisplayName("Player enters room and is silent. Health is increased.")
    void enterRoomAndBeSilent() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("2");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth + 20);
    }

    @Test
    @DisplayName("Player turns at the door. Health is not affected.")
    void enterRoomAndTurnAtTheDoor() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("3");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth);

    }

    @Test
    @DisplayName("Player enters invalid input and is attacked. Health decreases.")
    void enterRoomAndChoseWrongInput() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("x");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), (fakePlayerInitialHealth - witch.getStrength()));
    }

    @Test
    void witchDecision() {
    }
}