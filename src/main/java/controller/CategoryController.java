package controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import model.Category;
import service.CategoryService;

@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping
    public Optional<Category> getCategoryById(Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public void createCategory(Category category){
        categoryService.save(category);
    }

    @DeleteMapping
    public void deleteById(Long id){
        categoryService.deleteById(id);
    }

}
