package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepo, CategoryRepository categoryRepo, UserRepository userRepo) {
		return (args) -> {
			categoryRepo.save(new Category("Sci-fi"));
			categoryRepo.save(new Category("Fantasy"));

			bookRepo.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1955, "9780618640157", 24.0, categoryRepo.findByName("Fantasy")));
			bookRepo.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "9780547928241", 19.8, categoryRepo.findByName("Fantasy")));

			User user_1 = new User("user", "$2a$10$.cdYRVfrZhBbmwlN5qsWQ.6WXxGH53TT4lZ4hcCrTzBtpRWRnBDEG", "pekka@outlook.com", "USER");
			User user_2 = new User("admin", "$2a$10$g7LYNNvVePos9SFcMlsSKOtUbEMhBnm/uRUr3EWDXw36E5sEfGfbm", "tanja@outlook.com", "ADMIN");
			userRepo.save(user_1);
			userRepo.save(user_2);


			log.info("succesful");
		};
	}

}
