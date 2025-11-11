package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class MockStatisticsServiceTest {

    @Mock //parameter till ctor
    private FileStatisticsDao fileStatisticsDao;
    @InjectMocks // det vi vill att MOCKITO ska instansiera och testa
    private StatisticsService statisticsService;
    private List<Statistics> testStatistics;
    private int maxScore = 10;

    @BeforeEach
    void setUp() {
        testStatistics = new ArrayList<>();

        Statistics fakeStat0 = new Statistics("Player11", 4);
        Statistics fakeStat1 = new Statistics("Player22", maxScore);
        Statistics fakestat2 = new Statistics("Player66", 2);

        testStatistics.add(fakeStat0);
        testStatistics.add(fakeStat1);
        testStatistics.add(fakestat2);
    }

    @Test
    @DisplayName("Method loadAll() returns unsorted list")
    void loadStatistics() {
        Mockito.when(fileStatisticsDao.loadAll()).thenReturn(testStatistics);
        List<Statistics> scoreTestList = fileStatisticsDao.loadAll();
        for (int i = 0; i < scoreTestList.size(); i++) {
            Assertions.assertEquals(testStatistics.get(i).getScore(), scoreTestList.get(i).getScore());
        }
    }

    @Test
    @DisplayName("Method getSortedStatistics() returns sorted list.")
    void getSortedStatistics() {
        Mockito.when(fileStatisticsDao.loadAll()).thenReturn(testStatistics);
        List<Statistics> mockStats = statisticsService.getSortedStatistics();
        Assertions.assertEquals(maxScore, mockStats.get(0).getScore());
    }
}