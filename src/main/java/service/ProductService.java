package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import model.Product;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        logger.debug("Fetching all products");
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        logger.debug("Fetching product with id: {}", id);
        return productRepository.findById(id);
    }

    public Product save(Product product){
        logger.debug("Saving product");
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        logger.debug("Deleting product with id: {}", id);
        productRepository.deleteById(id);
    }
    
}
