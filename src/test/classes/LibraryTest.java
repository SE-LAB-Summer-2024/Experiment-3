package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Library library;
    private Book book;
    private Student student;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("Book Title", "Book Author", 12345);
        student = new Student("John Doe", 12345);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void lendBook() {
        //Arrange
        library.addBook(book);
        library.addStudent(student);
        Student newStudent = new Student("Mohammad", 12346);
        //Act
        boolean notRegisteredStudent = library.lendBook(book, newStudent);
        boolean result = library.lendBook(book, student);
        //Assert
        Assertions.assertFalse(notRegisteredStudent);
        Assertions.assertTrue(result);
        Assertions.assertFalse(library.getBooks().contains(book));
        Assertions.assertTrue(student.getBooks().contains(book));
    }

    @Test
    void returnBook() {
        //Arrange
        library.addBook(book);
        library.addStudent(student);
        library.lendBook(book, student);
        //Act
        boolean result = library.returnBook(book, student);
        boolean returnBookAgain = library.returnBook(book, student);
        //Assert
        Assertions.assertTrue(result);
        Assertions.assertFalse(returnBookAgain);
        Assertions.assertTrue(library.getBooks().contains(book));
        Assertions.assertFalse(student.getBooks().contains(book));
    }

    @Test
    void searchStudents() {
        //Arrange
        Student[] students = {
            new Student("John Doe", 1),
            new Student("Tom Doe", 2),
            new Student("Max Doe", 3),
        };
        library.addStudent(students[0]);
        library.addStudent(students[1]);
        library.addStudent(students[2]);
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
        //Act
        boolean result = library.searchStudents(SearchByType.ID, keys).contains(students[0]);
        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    void searchBooks() {
        //Arrange
        Book[] books = {
            new Book("Book Title", "Book Author", 1),
            new Book("Book Title", "Book Author", 2),
            new Book("Book Title", "Book Author", 3),
        };

        library.addBook(books[0]);
        library.addBook(books[1]);
        library.addBook(books[2]);
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
        //Act
        boolean result = library.searchBooks(SearchByType.ID, keys).contains(books[0]);
        //Assert
        Assertions.assertTrue(result);
    }


    @Test
    void displayBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        library.setBooks(books);

        library.displayBooks();

        String expectedOutput = "Available books in library:\n"
                + "Book 1 by Author 1\n"
                + "Book 2 by Author 2";
        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void displayStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Student 1", 1));
        students.add(new Student("Student 2", 2));
        library.setStudents(students);

        library.displayStudents();

        String expectedOutput = "Registered students:\n"
                + "Student 1|1\n"
                + "Student 2|2";

        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }

       
}
