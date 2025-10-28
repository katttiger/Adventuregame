package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Tavernowner;
import se.sprinto.hakan.adventuregame.view.UI;

public class TavernRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("""
                You enter a Tavern. 
                An old man greets you and asks if you want to have something to eat.""");

        Tavernowner tavernowner = new Tavernowner("Owner", 10, 0, 10);

        switch (answerServingRequest(ui)) {
            case "1" -> tavernowner.servePlayerGoodMeal(player);
            case "2" -> tavernowner.servePlayerLessGoodMeal(player);
            case "3" -> ui.showMessage("Stick härifrån.");
            default -> ui.showMessage("You turn at the door.");
        }
    }

    public String answerServingRequest(UI ui) {
        return ui.getInput("""
                [1] En måltid.
                [2] Mat.
                [3] Ursäkta. Fel dörr.
                """
        );
    }
}
