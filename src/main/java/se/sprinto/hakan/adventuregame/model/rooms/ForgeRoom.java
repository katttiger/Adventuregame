package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.model.characters.Smith;
import se.sprinto.hakan.adventuregame.view.UI;

public class ForgeRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        Smith smith = new Smith("Smith", 10, 0, 10);
        smith.increasePlayerStrength(player);
        ui.showMessage("The smith forges you a better weapon. Your strengths increases by 10.");
    }
}
