package b.Bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findById(Long categoryId);
}
