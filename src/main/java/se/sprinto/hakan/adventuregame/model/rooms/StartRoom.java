package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class StartRoom implements Room {

    public String printMenu(UI ui) {
        return ui.getInput(""" 
                Vilken dörr vill du ta?
                [1] Skog                [4] Värdshus
                [2] Fängelse            [5] Smedja
                [3] Skattkammare        [6] Stuga
                
                [q] Avsluta             [p] Stats
                """);
    }

    public void checkForestdoor(Player player, UI ui) {
        if (!player.hasFoundKey()) {
            new ForestRoom().enterRoom(player, ui);
        } else {
            ui.showMessage("Du har redan hittat och plockat upp nyckeln.");
        }
    }

    public void checkDungeonRoom(Player player, UI ui) {
        new DungeonRoom().enterRoom(player, ui);
    }

    public void checkTreasureroom(Player player, UI ui) {
        if (!player.hasOpenedChest()) {
            new TreasureRoom().enterRoom(player, ui);
        } else {
            ui.showMessage("Du har redan hittat och öppnat kistan");
        }
    }


    public void showPlayerStats(Player player, UI ui) {
        ui.showMessage("NAME: " + player.getName() +
                "\nHP: " + player.getHealth() + "\t\t | \tSTR: " + player.getStrength());
        ui.getInput("Tryck enter för att återvända till menyn.");
    }

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du befinner dig i start-rummet. Du ser sex dörrar framför dig.");
        boolean exit = false;
        while (!exit) {
            String choice = printMenu(ui);
            switch (choice) {
                case "1" -> checkForestdoor(player, ui);
                case "2" -> checkDungeonRoom(player, ui);
                case "3" -> checkTreasureroom(player, ui);
                case "4" -> new TavernRoom().enterRoom(player, ui);
                case "5" -> new ForgeRoom().enterRoom(player, ui);
                case "6" -> new WitchCottage().enterRoom(player, ui);
                case "q" -> exit = true;
                case "p" -> showPlayerStats(player, ui);
                default -> ui.showMessage("Ogiltigt val.");
            }
            if (player.hasWon()) {
                ui.showMessage("Grattis! Du har klarat spelet!");
                exit = true;
            } else if (player.getHealth() <= 0) {
                ui.showMessage(("""
                        Din hälsa är kritisk.
                        Du vacklar till och dör!
                        """));
                exit = true;
            }
        }
    }
}

