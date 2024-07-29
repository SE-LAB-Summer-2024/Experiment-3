package classes;

import classes.Book;
import classes.Library;
import classes.SearchByType;
import classes.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class LibraryTest {
    private Library library;
    private Book book;
    private Student student;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("Book Title", "Book Author", 12345);
        student = new Student("John Doe", 12345);
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
            // TODO: Write test case for displayBooks method
        }

        @Test
        void displayStudents() {
            // TODO: Write test case for displayStudents method
        }
}