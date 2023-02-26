package b.Bookstore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import b.Bookstore.domain.Category;
import b.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository CategoryRepository; 
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		List<Category> categories =  (List<Category>) CategoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "categorylist";

	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String getNewCategoryForm(Model model) {
		model.addAttribute("category", new Category()); 
		return "/addcategory";
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategoryk(@ModelAttribute Category category) {
		CategoryRepository.save(category);
		return "redirect:/categorylist";
	}

	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId) {
		CategoryRepository.deleteById(categoryId);
		return "redirect:../categorylist";
	}

}
