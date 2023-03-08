package b.Bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import b.Bookstore.domain.Book;
import b.Bookstore.domain.BookRepository;
import b.Bookstore.domain.CategoryRepository;


@RestController
public class BookController {

	@Autowired
	private CategoryRepository crepository;

	@Autowired
	BookRepository BookRepository; 
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model){
		List<Book> books =  (List<Book>) BookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";

	}

	@RequestMapping(value="/api/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {	
		return (List<Book>) BookRepository.findAll();
	}

	@RequestMapping(value="/api/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
		return BookRepository.findById(bookId);
	}      


	@PostMapping("/api/books/addbooks")
	Book newBook(@RequestBody Book newBook) {
		return BookRepository.save(newBook);
	}

	@DeleteMapping("/api/books/{id}")
	public Iterable<Book> deleteBook(@PathVariable("id") Long bookId) {
		BookRepository.deleteById(bookId);
		return BookRepository.findAll();
	}


	@PutMapping("/api/books/{id}")
	public Book editBook(@RequestBody Book editedBook, @PathVariable("id") Long bookId) {
		editedBook.setId(bookId);
		return BookRepository.save(editedBook);
	}


	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book()); 
		return "/addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		BookRepository.save(book);
		return "redirect:/booklist";


	}


}





