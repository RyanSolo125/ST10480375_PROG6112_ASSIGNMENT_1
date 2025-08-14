package org.example;

import java.util.Scanner;

/// library app


///// CHATGPT WAS USED TO HELP FIX ERRORS I DIDNT UNDERSTAND AND TO HELP CREATE TESTS

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /// library object
        Library library = new Library();


        int choice;

        /// menu
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Show Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                ///borrow book
                case 1 -> {
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    var m = library.findMemberById(mid);
                    var b = library.findBookById(bid);
                    if (m != null && b != null && m.borrowBook(b)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Borrow failed!");
                    }
                }

                ///return book
                case 2 -> {
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    var m = library.findMemberById(mid);
                    var b = library.findBookById(bid);
                    if (m != null && b != null && m.returnBook(b)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Return failed!");
                    }
                }

                ///create report
                case 3 -> library.generateReport();

                /// exit menu
                case 0 -> System.out.println("Exiting...");

                /// not a real choice
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}
