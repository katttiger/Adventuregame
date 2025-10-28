package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.FakeFileStatisticDao;

class StatisticsServiceTest {

    FakeFileStatisticDao fakeFileStatisticDao;

    @BeforeEach
    void setUp() {
        this.fakeFileStatisticDao = new FakeFileStatisticDao();
        fakeFileStatisticDao.setStatistics();
    }

    @Test
    @DisplayName("Loading")
    void getSortedStatistics() {
        Assertions.assertNotNull(fakeFileStatisticDao.loadAll());
    }
}