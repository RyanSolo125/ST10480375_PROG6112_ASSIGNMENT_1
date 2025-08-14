package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Member {
    ///initializing variables and arrarylist
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;

    /// constructor for members details and arraylist
    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    /// getMaxBooks is abstract to allow students and staff members to borrow different amounts of books
    public abstract int getMaxBooks();

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < getMaxBooks() && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    public String listBorrowedBooks() {
        if (borrowedBooks.isEmpty()) return "None";
        return String.join(", ", borrowedBooks.stream().map(Book::getTitle).toList());
    }

    ///  student and staffmember subclasses
    public static class StudentMember extends Member {
        private String gradeLevel;
        public StudentMember(int id, String name, String gradeLevel) {
            super(id, name);
            this.gradeLevel = gradeLevel;
        }
        @Override
        public int getMaxBooks() { return 3; }
        @Override
        public String toString() { return "Student: " + getName() + " (Grade " + gradeLevel + ")"; }
    }

    public static class StaffMember extends Member {
        private String department;
        public StaffMember(int id, String name, String dept) {
            super(id, name);
            this.department = dept;
        }
        @Override
        public int getMaxBooks() { return 5; }
        @Override
        public String toString() { return "Staff: " + getName() + " (Dept: " + department + ")"; }
    }
}
