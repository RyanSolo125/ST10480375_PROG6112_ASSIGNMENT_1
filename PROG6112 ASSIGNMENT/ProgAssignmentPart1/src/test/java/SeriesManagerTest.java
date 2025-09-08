import org.example.SeriesManager;
import org.example.SeriesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesManagerTest {

    private SeriesManager manager;
    private SeriesModel sampleSeries;

    @BeforeEach
    void setUp() {
        manager = new SeriesManager();
        // FIXED: pass 4 arguments to match your SeriesModel constructor
        sampleSeries = new SeriesModel("S01", "Breaking Code", "16", "10");
        manager.addSeries(sampleSeries);
    }

    @Test
    void TestSearchSeries() {
        SeriesModel found = manager.findById("S01");
        assertNotNull(found, "Series should be found");
        assertEquals("Breaking Code", found.SeriesName, "Series name should match");
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = manager.findById("INVALID");
        assertNull(found, "No series should be found with invalid ID");
    }

    @Test
    void TestUpdateSeries() {
        SeriesModel toUpdate = manager.findById("S01");
        assertNotNull(toUpdate);

        toUpdate.SeriesName = "Breaking Code: Reloaded";
        SeriesModel updated = manager.findById("S01");

        assertEquals("Breaking Code: Reloaded", updated.SeriesName, "Series should be updated");
    }

    @Test
    void TestDeleteSeries() {
        boolean deleted = manager.deleteSeries("S01");
        assertTrue(deleted, "Series should be deleted");

        SeriesModel afterDelete = manager.findById("S01");
        assertNull(afterDelete, "Series should not exist after deletion");
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = manager.deleteSeries("INVALID");
        assertFalse(deleted, "Deletion should fail for invalid ID");
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(SeriesManager.isAgeValid("12"), "Age 12 should be valid");
        assertTrue(SeriesManager.isAgeValid("2"), "Lower boundary age 2 should be valid");
        assertTrue(SeriesManager.isAgeValid("18"), "Upper boundary age 18 should be valid");
    }

    @Test
    void TestSeriesAgeRestriction_AgeInValid() {
        assertFalse(SeriesManager.isAgeValid("1"), "Age 1 should be invalid");
        assertFalse(SeriesManager.isAgeValid("19"), "Age 19 should be invalid");
        assertFalse(SeriesManager.isAgeValid("abc"), "Non-numeric input should be invalid");
    }
}
