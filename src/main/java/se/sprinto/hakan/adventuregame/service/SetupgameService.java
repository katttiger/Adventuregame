package se.sprinto.hakan.adventuregame.service;

import se.sprinto.hakan.adventuregame.dao.AppInfo;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class SetupgameService {
    public static void printGreeting(UI ui) {
        ui.showMessage("Välkommen till Äventyrsspelet!");

        AppInfo appInfo = AppInfo.getInstance();
        ui.showMessage("Version " + appInfo.getProperty("version")
                + " av " + appInfo.getProperty("author"));
    }

    public static Player createPlayer(UI ui) {
        String name = ui.getInput("Ange ditt namn:");
        Player player = new Player.Builder()
                .name(name).health(100).score(0).strength(10).build();
        return player;
    }

}
