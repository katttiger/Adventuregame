package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.rooms.StartRoom;
import se.sprinto.hakan.adventuregame.service.SetupgameService;
import se.sprinto.hakan.adventuregame.view.ScannerUI;
import se.sprinto.hakan.adventuregame.view.UI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UI ui = new ScannerUI();
        SetupgameService.printGreeting(ui);
        Player player = SetupgameService.createPlayer(ui);
        new StartRoom().enterRoom(player, ui);
//
//        StatisticsDao dao = new FileStatisticsDao();
//        dao.save(new Statistics(player.getName(), player.getScore()));
//
//        StatisticsService service = new StatisticsService(dao);
//        ui.showMessage("\n--- Topplista ---");
//        for (Statistics s : service.getSortedStatistics()) {
//            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
//        }
    }
}

