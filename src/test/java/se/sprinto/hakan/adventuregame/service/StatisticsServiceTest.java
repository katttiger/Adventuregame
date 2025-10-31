package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.FakeFileStatisticDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

class StatisticsServiceTest {

    FakeFileStatisticDao fakeFileStatisticDao = new FakeFileStatisticDao();
    StatisticsService statisticsService = new StatisticsService(fakeFileStatisticDao);
    ArrayList<Statistics> sortedStatistics;

    @BeforeEach
    void setUp() {
        this.sortedStatistics = new ArrayList<>();
    }

    @Test
    @DisplayName("List is not empty")
    void listIsNotEmpty() {
        Assertions.assertFalse(fakeFileStatisticDao.loadAll().isEmpty());
    }

    @Test
    @DisplayName("List returned is unsorted")
    void getUnsortedStatistics() {
        Statistics fakeStat = new Statistics("Player11", 4);
        sortedStatistics.add(fakeStat);
        fakeStat = new Statistics("Player22", 10);
        sortedStatistics.add(fakeStat);
        fakeStat = new Statistics("Player66", 2);
        sortedStatistics.add(fakeStat);

        List<Statistics> mockStats = fakeFileStatisticDao.loadAll();

        for (int i = 0; i < mockStats.size(); i++) {
            assert mockStats.get(i).getScore() == sortedStatistics.get(i).getScore();
        }
    }


    @Test
    @DisplayName("List returned is sorted")
    void getSortedStatistics() {
        Statistics fakeStat = new Statistics("Player22", 10);
        sortedStatistics.add(fakeStat);
        fakeStat = new Statistics("Player11", 4);
        sortedStatistics.add(fakeStat);
        fakeStat = new Statistics("Player66", 2);
        sortedStatistics.add(fakeStat);

        ArrayList<Integer> score = new ArrayList<>();

        for (Statistics stat : statisticsService.getSortedStatistics()) {
            score.add(stat.getScore());
        }

        for (int i = 0; i < score.size(); i++) {
            assert score.get(i) == sortedStatistics.get(i).getScore();
        }
    }
}