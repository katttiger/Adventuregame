package se.sprinto.hakan.adventuregame.model.rooms;

import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public interface Room {
    void enterRoom(Player player, UI ui);
}

