package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.StartRoom;
import se.sprinto.hakan.adventuregame.service.GameService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UI ui = new ScannerUI();
        GameService.printGreeting(ui);
        Player player = GameService.createPlayer(ui);
        new StartRoom().enterRoom(player, ui);
        GameService.saveScore(player);
        GameService.printScore(ui);
    }
}


