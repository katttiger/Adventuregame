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

    @Mock
    private FileStatisticsDao fileStatisticsDao;

    @InjectMocks
    private StatisticsService statisticsService;
    private List<Statistics> testStatistics;

    @BeforeEach
    void setUp() {
        testStatistics = new ArrayList<>();
        //Add the below to list testStatistics
        Statistics fakeStat0 = new Statistics("Player11", 4);
        Statistics fakeStat1 = new Statistics("Player22", 10);
        Statistics fakestat2 = new Statistics("Player66", 2);

        testStatistics.add(fakeStat0);
        testStatistics.add(fakeStat1);
        testStatistics.add(fakestat2);
    }

    @Test
    @DisplayName("loadAll-method returns unsorted list")
    void loadStatistics() {

        //Returnera en hårdkodad lista med statistics-object (osorterad)
        Mockito.when(fileStatisticsDao.loadAll()).thenReturn(testStatistics);
        List<Statistics> scoreTestList = fileStatisticsDao.loadAll();
        if (scoreTestList.isEmpty()) {
            Assertions.fail();
        }
        for (int i = 0; i < scoreTestList.size(); i++) {
            assert scoreTestList.get(i).getScore() == testStatistics.get(i).getScore() && scoreTestList.get(i).getPlayerName() == testStatistics.get(i).getPlayerName();
        }


    }

    @Test
    @DisplayName("Method getSortedStatistics returns sorted list.")
    void getSortedStatistics() {


    }
}