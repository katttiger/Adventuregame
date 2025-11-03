package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Witch;
import se.sprinto.hakan.adventuregame.view.UI;

public class WitchCottage implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {

        Witch witch = new Witch("Witch", 10, 0, 10);
        ui.showMessage("""
                Du har hittat en häxas stuga och stiger in.
                I stugan står en häxa vid sin kittel och tittar på dig.
                """);

        switch (witchDecision(player, ui)) {
            case "1" -> {
                ui.showMessage("""
                        Häxan ser ditt mod och belönar dig.
                        Du återfår 10 HP.
                        """);
                witch.healPlayerNormal(player);
            }
            case "2" -> {
                ui.showMessage("""
                        Häxan uppskattar din respekt och belönar dig.
                        Du återfår 20 HP.
                        """);
                witch.healPlayerBoost(player);
            }
            case "3" -> {
                ui.showMessage("""
                        Du mår illa och hör häxan skratta.
                        Du förlorar 10 HP.""");
                witch.attack(player);
            }
            default -> {
                ui.showMessage("""
                        Du vänder i dörren.
                        """);
            }
        }
    }

    public String witchDecision(Player player, UI ui) {
        return ui.getInput("""
                [1] Fråga om hjälp
                [2] Var tyst
                [3] Ursäkta. Fel dörr
                """);
    }
}
