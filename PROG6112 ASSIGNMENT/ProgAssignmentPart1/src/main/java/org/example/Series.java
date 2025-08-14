package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    private List<SeriesModel> database = new ArrayList<>();
    private Scanner in = new Scanner(System.in);


    //////////inputs
    public void CaptureSeries() {
        System.out.println();
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("***********************************");

        System.out.print("Enter the series id: ");
        String id = in.nextLine().trim();

        System.out.print("Enter the series name: ");
        String name = in.nextLine().trim();

        String age = readValidAge();

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = in.nextLine().trim();

        database.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }


    /////////////series search
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = in.nextLine().trim();
        SeriesModel s = findById(id);
        if (s == null) {
            System.out.println("-----------------------------------");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("-----------------------------------");
        } else {
            displaySeries(s);
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }



    ///////////update
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = in.nextLine().trim();
        SeriesModel s = findById(id);
        if (s == null) {
            System.out.println("Series with Series Id: " + id + " was not found!");
        } else {
            System.out.print("Enter the series name: ");
            s.SeriesName = in.nextLine().trim();

            s.SeriesAge = readValidAge();

            System.out.print("Enter the number of episodes: ");
            s.SeriesNumberOfEpisodes = in.nextLine().trim();
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }



    ///////delete
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = in.nextLine().trim();
        SeriesModel s = findById(id);
        if (s == null) {
            System.out.println("Series with Series Id: " + id + " was not found!");
        } else {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
            if (in.nextLine().trim().equalsIgnoreCase("y")) {
                database.remove(s);
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
            }
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }





    //////print report
    public void SeriesReport() {
        int count = 1;
        for (SeriesModel s : database) {
            System.out.println("Series " + count);
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            count++;
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }


    ////////exit
    public void ExitSeriesApplication() {
        System.out.println("Goodbye!");
        System.exit(0);
    }



    ////////verify age
    private String readValidAge() {
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String input = in.nextLine().trim();
            try {
                int age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) {
                    return String.valueOf(age);
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.println("Please re-enter the series age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.println("Please re-enter the series age >> ");
            }
        }
    }

    private SeriesModel findById(String id) {
        for (SeriesModel s : database) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    //////display series
    private void displaySeries(SeriesModel s) {
        System.out.println("-----------------------------------");
        System.out.println("SERIES ID: " + s.SeriesId);
        System.out.println("SERIES NAME: " + s.SeriesName);
        System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
        System.out.println("SERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
        System.out.println("-----------------------------------");
    }
}

