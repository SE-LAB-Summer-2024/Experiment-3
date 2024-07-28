package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
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
        // TODO: Write test cases for searchStudents method
    }

    @Test
    void searchBooks() {
        // TODO: Write test cases for searchBooks method
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