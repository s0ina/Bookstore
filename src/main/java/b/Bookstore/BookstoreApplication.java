package b.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import b.Bookstore.domain.Book;
import b.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args); 
			
		}
		
		@Bean
		public CommandLineRunner demo(BookRepository repository) {return (args) -> {
		 
			Book f = new Book ("Dracula", "Bram Stroker", 1897, 11111, 13.00);
			Book f2 = new Book ("The Picture of Dorian Gray", "Oscar Wilde", 1890, 22222, 11.0);
			
			repository.save(f);
			repository.save(f2);
		};
	}

}
	

