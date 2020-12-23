package ru.geekbrains.spring.context.lesson2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


@Component //для того, чтобы бин оказался в контексте надо помечать аннотацией @Component
@Scope(scopeName = "prototype")
public class Cart {


    private List<Product> list = new ArrayList<>();

    public List<Product> getCart() {
        return Collections.unmodifiableList(list);
    }


    public void addToCart(Product product) {
        list.add(product);
    }

    public void deleteFromCart(Long id) {
        Iterator<Product> iter = list.iterator();
        while (iter.hasNext()) {
            Product item = iter.next();
            if (item.getId().equals(id)) {
                iter.remove();
            }
        }

    }

}
