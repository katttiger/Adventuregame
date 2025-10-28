package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

public class FakeFileStatisticDao implements StatisticsDao {

    Statistics fakeStat;

    List<Statistics> statistics;

    public void setStatistics() {
        this.fakeStat = new Statistics("Player1", 22);
        this.statistics.add(fakeStat);
        this.fakeStat = new Statistics("Player2", 16);
        this.statistics.add(fakeStat);
        this.fakeStat = new Statistics("Player3", 99);
        this.statistics.add(fakeStat);
        this.fakeStat = new Statistics("Player4", 2);
        this.statistics.add(fakeStat);
    }

    @Override
    public void save(Statistics stat) {
        statistics.add(stat);
    }

    @Override
    public List<Statistics> loadAll() {
        return List.of();
    }
}
