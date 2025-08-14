package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeriesManagerTest {

    private SeriesManager manager;

    @BeforeEach
    public void setUp() {
        manager = new SeriesManager();
        manager.addSeries(new SeriesModel("101", "Extreme Sports", "12", "10"));
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel result = manager.findById("101");
        assertNotNull(result);
        assertEquals("Extreme Sports", result.SeriesName);
        assertEquals("12", result.SeriesAge);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel result = manager.findById("999");
        assertNull(result);
    }

    @Test
    public void TestUpdateSeries() {
        SeriesModel s = manager.findById("101");
        assertNotNull(s);

        s.SeriesName = "Updated Name";
        s.SeriesAge = "15";
        s.SeriesNumberOfEpisodes = "20";

        SeriesModel updated = manager.findById("101");
        assertEquals("Updated Name", updated.SeriesName);
        assertEquals("15", updated.SeriesAge);
        assertEquals("20", updated.SeriesNumberOfEpisodes);
    }

    @Test
    public void TestDeleteSeries() {
        assertTrue(manager.deleteSeries("101"));
        assertNull(manager.findById("101"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        assertFalse(manager.deleteSeries("999"));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(SeriesManager.isAgeValid("12"));
        assertTrue(SeriesManager.isAgeValid("2"));
        assertTrue(SeriesManager.isAgeValid("18"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        assertFalse(SeriesManager.isAgeValid("1"));   // too low
        assertFalse(SeriesManager.isAgeValid("19"));  // too high
        assertFalse(SeriesManager.isAgeValid("abc")); // not a number
    }
}
