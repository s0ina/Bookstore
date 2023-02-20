package b.Bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import b.Bookstore.domain.CategoryRepository;
import b.Bookstore.domain.Category;


@SpringBootApplication
public class CategoryApplication {
	private static final Logger log = LoggerFactory.getLogger(CategoryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CategoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner Category(CategoryRepository repository) {
		return (args) -> {
			log.info("save a couple of categories");
			repository.save(new Category("Fiction"));
			repository.save(new Category("Scifi"));	
			repository.save(new Category("Comedy"));
			repository.save(new Category("Horror"));
			repository.save(new Category("Non-fiction"));

			log.info("fetch all books");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			}

		};
	}
}