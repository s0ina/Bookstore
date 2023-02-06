package b.Bookstore.webcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import b.Bookstore.domain.Book;

@Controller

public class BookController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = new ArrayList<Book>(); 
		books.add(new Book("Dracula", "Bram Stroker", 1897, 11111, 13.00)); 
		books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 22222, 11.0)); 
		model.addAttribute("books", books); 
		return "bookindex"; 
	
	}
}
