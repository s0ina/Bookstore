package b.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import b.Bookstore.domain.Book;
import b.Bookstore.domain.BookRepository;
import b.Bookstore.domain.Category;
import b.Bookstore.domain.CategoryRepository;



@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}

	@Bean
	public CommandLineRunner Book(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category category1 = new Category("Fiction");
			crepository.save(category1);
			repository.save(new Book("Wuthering Heights", "Emily Bronte", 1847, 1111, 20.0, category1));
			Category category2 = new Category("Horror");
			crepository.save(category2);
			repository.save(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 2222, 15.0, category2 ));	

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}