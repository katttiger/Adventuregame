package se.sprinto.hakan.adventuregame;

import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticDao implements StatisticsDao {

    ArrayList<Statistics> testStatistics = new ArrayList<>();

    public FakeFileStatisticDao() {
    }

    @Override
    public void save(Statistics stat) {
        testStatistics.add(stat);
    }

    @Override
    public List<Statistics> loadAll() {
        Statistics fakeStat = new Statistics("Player11", 4);
        testStatistics.add(fakeStat);
        fakeStat = new Statistics("Player22", 10);
        testStatistics.add(fakeStat);
        fakeStat = new Statistics("Player66", 2);
        testStatistics.add(fakeStat);
        return testStatistics;
    }
}
