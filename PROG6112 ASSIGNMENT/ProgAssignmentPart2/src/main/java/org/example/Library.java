package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    /// initializing array lists
    ///
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    /// adding values to lists
    public void addBook(Book book) { books.add(book); }
    public void addMember(Member member) { members.add(member); }

    public Book findBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public Member findMemberById(int id) {
        return members.stream().filter(m -> m.getMemberId() == id).findFirst().orElse(null);
    }


    ///generating library report
    public void generateReport() {
        System.out.println("========= Library Report =========");
        System.out.println("Total Books: " + books.size());

        long available = books.stream().filter(Book::isAvailable).count();

        System.out.println("Available Books: " + available);
        System.out.println("Borrowed Books: " + (books.size() - available));
        System.out.println("\nMembers:");
        members.forEach(m -> System.out.println("- " + m + " | Borrowed: " + m.listBorrowedBooks()));
        System.out.println("=================================");
    }
}
