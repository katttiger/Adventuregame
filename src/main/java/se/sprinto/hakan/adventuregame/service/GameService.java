package se.sprinto.hakan.adventuregame.service;

import se.sprinto.hakan.adventuregame.dao.AppInfo;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.model.characters.Player;
import se.sprinto.hakan.adventuregame.view.UI;

public class GameService {
    private static StatisticsDao dao = new FileStatisticsDao();

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

    public static void saveScore(Player p) {
        dao.save(new Statistics(p.getName(), p.getScore()));
    }

    public static void printScore(UI ui) {
        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}
