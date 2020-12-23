package ru.geekbrains.spring.context.lesson2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component (value = "service")
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }


    public void getProducts() {
       List<Product> products = productRepository.getProducts();
       for(Product item : products) {
           System.out.println(item);
       }
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

}
