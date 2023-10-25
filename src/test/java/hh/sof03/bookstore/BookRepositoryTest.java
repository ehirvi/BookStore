package hh.sof03.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createNewBook() {
        Book book = new Book("Testbook", "Tester", 2023, "1234", 20, null);
        bookRepository.save(book);
        Assertions.assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = new Book("Testbook", "Tester", 2023, "1234", 20, null);
        bookRepository.save(book);
        long id = book.getId();
        bookRepository.delete(book);
        Assertions.assertThat(bookRepository.existsById(id)).isFalse();
    }

    @Test
    public void searchForBook() {
        Book book = bookRepository.findByTitle("The Hobbit");
        Assertions.assertThat(book.getAuthor()).isEqualTo("J.R.R. Tolkien");
    }

}
