package org.example;

import java.util.ArrayList;
import java.util.List;

public class SeriesManager {
    private List<SeriesModel> database = new ArrayList<>();

    public void addSeries(SeriesModel series) {
        database.add(series);
    }

    public SeriesModel findById(String id) {
        for (SeriesModel s : database) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteSeries(String id) {
        SeriesModel s = findById(id);
        if (s != null) {
            database.remove(s);
            return true;
        }
        return false;
    }

    public List<SeriesModel> getAllSeries() {
        return database;
    }

    public static boolean isAgeValid(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

