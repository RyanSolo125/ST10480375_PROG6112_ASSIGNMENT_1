package org.example;


import java.util.Scanner;



///// CHATGPT WAS USED TO HELP FIX ERRORS I DIDN'T UNDERSTAND AND TO HELP CREATE TESTS




public class Main {
    public static void main(String[] args) {
        Series seriesApp = new Series();
        Scanner in = new Scanner(System.in);



        /////starting choice
        while (true) {
            System.out.println();
            System.out.println("LATEST SERIES – 2025");
            System.out.println("***********************************");
            System.out.print("Enter (1) to launch menu or any other key to exit\n> ");
            if (!in.nextLine().trim().equals("1")) {
                seriesApp.ExitSeriesApplication();
            }

            //////menu options
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report 2025");
            System.out.println("(6) Exit Application.");
            String choice = in.nextLine().trim();

            switch (choice) {
                case "1" -> seriesApp.CaptureSeries();
                case "2" -> seriesApp.SearchSeries();
                case "3" -> seriesApp.UpdateSeries();
                case "4" -> seriesApp.DeleteSeries();
                case "5" -> seriesApp.SeriesReport();
                case "6" -> seriesApp.ExitSeriesApplication();
                default -> System.out.println("Invalid menu option");
            }
        }
    }
}

