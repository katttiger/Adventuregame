package se.sprinto.hakan.adventuregame.model.rooms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    void enterRoomAndAskForHelp() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("1");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth + 10);
    }

    @Test
    void enterRoomAndBeSilent() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("2");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth + 20);
    }

    @Test
    void enterRoomAndTurnAtTheDoor() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("3");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertEquals(fakePlayer.getHealth(), fakePlayerInitialHealth);

    }

    @Test
    void enterRoomAndChoseWrongInput() {
        int fakePlayerInitialHealth = fakePlayer.getHealth();
        fakeUI.setInput("x");
        witchCottage.enterRoom(fakePlayer, fakeUI);
        Assertions.assertTrue(fakePlayer.getHealth() < fakePlayerInitialHealth);


    }

    @Test
    void witchDecision() {
    }
}