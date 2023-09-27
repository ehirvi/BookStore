package hh.sof03.bookstore.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping(value="/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "categorylist";
    }
    

    @GetMapping(value="/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping(value="/savecategory")
    public String saveCategory(Category category) {
        categoryRepo.save(category);
        return "redirect:/categorylist";
    }

}
