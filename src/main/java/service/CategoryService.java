package service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import model.Category;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        logger.debug("Fetching all categories");
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        logger.debug("Fetching category by id: {}", id);
        return categoryRepository.findById(id);
    }

    public Category save(Category category){
        logger.debug("Saving category");
        return categoryRepository.save(category);
    }

    public void deleteById(Long id){
        logger.debug("Deleting category by id: {}", id);
        categoryRepository.deleteById(id);
    }
}