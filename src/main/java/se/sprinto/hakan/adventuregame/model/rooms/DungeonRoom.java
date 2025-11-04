package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Enemy;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsehåla. En vätte står i vägen!");
        Enemy goblin = new Enemy("Vätte", 20, 0, 5);

        while (player.isAlive() && goblin.isAlive()) {
            ui.showMessage("""
                    Dina värden | Fiendens värden
                    ---------------------------------
                    HP: """ + player.getHealth() + "\t\t| HP: " + goblin.getHealth() +
                    "\nSTR: " + player.getStrength() + "\t\t| STR: " + goblin.getStrength() +
                    "\n---------------------------------");
            String choice = ui.getInput("Vill du [a]ttackera eller [r]etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(goblin);
                ui.showMessage("Du attackerar vätten!\nVättens HP minskar till: " + goblin.getHealth());
                if (goblin.isAlive()) {
                    goblin.attack(player);
                    ui.showMessage("Vätten attackerar dig!\nDitt HP minskar till: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade vätten!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            } else {
                ui.showMessage("Du fumlar och vätten attackerar dig.\nDtt HP minskar till: " + player.getHealth());
            }
        }
    }
}

