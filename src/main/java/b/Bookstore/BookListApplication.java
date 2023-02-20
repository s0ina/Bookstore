package b.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import b.Bookstore.domain.Book;
import b.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}

	@Bean
	public CommandLineRunner Book(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Wuthering Heights", "Emily Bronte", 1847, 1111, 20.0));
			repository.save(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 2222, 15.0));	

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}