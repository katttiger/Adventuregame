package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.rooms.StartRoom;
import se.sprinto.hakan.adventuregame.service.GameService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        GameService.printGreeting(ui);
        Player player = GameService.createPlayer(ui);
        new StartRoom().enterRoom(player, ui);
        GameService.closeApplication(player, ui);
    }
}


