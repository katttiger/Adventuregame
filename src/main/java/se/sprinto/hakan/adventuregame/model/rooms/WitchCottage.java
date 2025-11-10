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
                I stugan står en häxa vid sin kittel.
                """);

        switch (witchDecision(ui)) {
            case "1" -> {
                ui.showMessage("""
                        Häxan hör dig och tittar upp. Hon ser ditt mod och belönar dig..
                        Du återfår 10 HP.
                        """);
                witch.healPlayerNormal(player);
            }
            case "2" -> {
                ui.showMessage("""
                        Häxan känner din närvaro och tittar upp. Din tystnad tolkar hon som vördnad och du belönas.
                        Du återfår 20 HP.
                        """);
                witch.healPlayerBoost(player);
            }
            case "3" -> {
                ui.showMessage("""
                        Du vänder i dörren och hoppas att häxan inte sett dig.
                        """);
            }
            default -> {
                ui.showMessage("""
                        Häxan hör dig och skrattar.
                        Du mår illa och förlorar 10 HP.""");
                witch.attack(player);
            }
        }
        ui.returnToMenuPrompt();
    }

    public String witchDecision(UI ui) {
        return ui.getInput("""
                [1] Fråga om hjälp
                [2] Var tyst
                [3] Ursäkta. Fel dörr
                """);
    }
}
