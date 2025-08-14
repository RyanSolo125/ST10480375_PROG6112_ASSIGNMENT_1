package org.example;

public class LibraryTest {

    public static void main(String[] args) {
        LibraryTest tester = new LibraryTest();
        tester.testAddBookAndFind();
        tester.testAddMemberAndFind();
        tester.testBorrowBookSuccess();
        tester.testBorrowBookFailIfAlreadyBorrowed();
        tester.testReturnBook();
        tester.testMaxBooksLimit();
    }

    private void check(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName);
        }
    }

    public void testAddBookAndFind() {
        Library lib = new Library();
        Book b = new Book(1, "Test Book", "Author");
        lib.addBook(b);

        Book found = lib.findBookById(1);
        check("testAddBookAndFind", found != null && "Test Book".equals(found.getTitle()));
    }

    public void testAddMemberAndFind() {
        Library lib = new Library();
        Member m = new Member.StudentMember(101, "Alice", "Grade 10");
        lib.addMember(m);

        Member found = lib.findMemberById(101);
        check("testAddMemberAndFind", found != null && "Alice".equals(found.getName()));
    }

    public void testBorrowBookSuccess() {
        Library lib = new Library();
        Book b = new Book(2, "Java Basics", "Smith");
        Member m = new Member.StudentMember(102, "Bob", "Grade 11");
        lib.addBook(b);
        lib.addMember(m);

        boolean borrowed = m.borrowBook(b);
        check("testBorrowBookSuccess", borrowed && b.isBorrowed() && m.getBorrowedBooks().size() == 1);
    }

    public void testBorrowBookFailIfAlreadyBorrowed() {
        Library lib = new Library();
        Book b = new Book(3, "Algorithms", "Knuth");
        Member m1 = new Member.StudentMember(103, "Charlie", "Grade 12");
        Member m2 = new Member.StaffMember(201, "Prof. Smith", "CS");
        lib.addBook(b);
        lib.addMember(m1);
        lib.addMember(m2);

        boolean first = m1.borrowBook(b);
        boolean second = m2.borrowBook(b); // should fail
        check("testBorrowBookFailIfAlreadyBorrowed", first && !second);
    }

    public void testReturnBook() {
        Library lib = new Library();
        Book b = new Book(4, "Databases", "Stonebraker");
        Member m = new Member.StaffMember(202, "Dr. Lee", "IT");
        lib.addBook(b);
        lib.addMember(m);

        m.borrowBook(b);
        boolean returned = m.returnBook(b);
        check("testReturnBook", returned && !b.isBorrowed() && m.getBorrowedBooks().isEmpty());
    }

    public void testMaxBooksLimit() {
        Member student = new Member.StudentMember(301, "Dana", "Grade 9");
        Book b1 = new Book(10, "Book1", "A");
        Book b2 = new Book(11, "Book2", "B");
        Book b3 = new Book(12, "Book3", "C");
        Book b4 = new Book(13, "Book4", "D");

        boolean first = student.borrowBook(b1);
        boolean second = student.borrowBook(b2);
        boolean third = student.borrowBook(b3);
        boolean fourth = student.borrowBook(b4); // should fail

        check("testMaxBooksLimit", first && second && third && !fourth);
    }
}
