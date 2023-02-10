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
	
	@RequestMapping(value = "/localhost:8080", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = new ArrayList<Book>();  
		model.addAttribute("books", books); 
		return "bookindex"; 
	
	}
}
