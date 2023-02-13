package b.Bookstore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import b.Bookstore.domain.Book;
import b.Bookstore.domain.BookRepository;

@Controller
public class BookController {


	@Autowired
	BookRepository BookRepository; 
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books =  (List<Book>) BookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";

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

	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		BookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//@PostMapping(value = "/editbook")
	//public String editBookForm(@ModelAttribute(Book book, Model model) {
		//model.addAttribute("book", book);
		//return  "redirect:/booklist";

	
	}
	




