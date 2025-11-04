package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Tavernowner;
import se.sprinto.hakan.adventuregame.view.UI;

public class TavernRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("""
                Du går in i ett värdshus.
                Värdshusvärden hälsar dig och frågar om du vill ha någonting att äta.""");

        Tavernowner tavernowner = new Tavernowner("Owner", 10, 0, 10);

        switch (answerServingRequest(ui)) {
            case "1" -> {
                ui.showMessage(
                        "Värdshusvärden serverar dig en väldigt god måltid. Du får 10 HP"
                );
                tavernowner.servePlayerGoodMeal(player);
            }
            case "2" -> {
                ui.showMessage(
                        "Maten du får är inte god. Du förlorar 10 HP"
                );
                tavernowner.servePlayerLessGoodMeal(player);
            }
            case "3" -> ui.showMessage("Värdshusvärden säger \"Stick härifrån\"." +
                    "Du lyder.");
            default -> ui.showMessage("Du vänder i dörren.");
        }
        ui.returnToMenuPrompt();
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
