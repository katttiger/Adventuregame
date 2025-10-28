package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Witch;
import se.sprinto.hakan.adventuregame.view.UI;

public class WitchCottage implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {

        Witch witch = new Witch("Witch", 10, 0, 10);
        ui.showMessage("""
                You've entered a Witch Cottage.
                The witch looks at you with cunning eyes.
                """);

        switch (witchDecision(player, ui)) {
            case "1" -> witch.healPlayerNormal(player);
            case "2" -> witch.healPlayerBoost(player);
            case "3" -> witch.attack(player);
        }
    }

    public String witchDecision(Player player, UI ui) {
        return ui.getInput("""
                [1] Ask for help
                [2] Remain silent 
                [3] Wrong door
                """);
    }
}
