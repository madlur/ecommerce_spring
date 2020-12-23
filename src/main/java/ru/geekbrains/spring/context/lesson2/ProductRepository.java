package ru.geekbrains.spring.context.lesson2;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component(value = "repository") //для того, чтобы бин оказался в контексте надо помечать аннотацией @Component
public class ProductRepository {

    private List<Product> list;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
        list.add(new Product(1L, "product #1", BigDecimal.valueOf(123000)));
        list.add(new Product(2L, "product #2", BigDecimal.valueOf(1000000)));
        list.add(new Product(3L, "product #3", BigDecimal.valueOf(55000)));
        list.add(new Product(4L, "product #4", BigDecimal.valueOf(14019286)));
        list.add(new Product(5L, "product #5", BigDecimal.valueOf(100)));

    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(list);
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public Product getById(long id) {
        for(Product item : list) {
            if(id==item.getId()) {
                return item;
            }
        }
    return null;
    }

}
