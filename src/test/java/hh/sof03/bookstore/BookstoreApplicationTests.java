package hh.sof03.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.bookstore.webcontrol.BookController;
import hh.sof03.bookstore.webcontrol.BookRestController;
import hh.sof03.bookstore.webcontrol.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	@Autowired
	private BookRestController bookRestController;
	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() {
		Assertions.assertThat(bookController).isNotNull();
		Assertions.assertThat(bookRestController).isNotNull();
		Assertions.assertThat(categoryController).isNotNull();
	}

}
