package ru.geekbrains.spring.context.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean("service", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);
        System.out.println("Проверка на скоуп корзины: ");
        System.out.print(cart == cart2);
        System.out.println("=======");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду");
            String command = scanner.nextLine();
            if (command.equals("/getlist")) {

                productService.getProducts();
            } else if (command.equals("/getproduct")) {
                System.out.println("Type ID");
                Long id = Long.valueOf(scanner.nextLine());
                System.out.println(productService.getProductById(id));
            } else if (command.equals("/showcart")) {
                System.out.println(cart.getCart());
            } else if (command.equals("/addcart")) {
                System.out.println("Type ID of product for adding to cart");
                Long id = Long.valueOf(scanner.nextLine());
                cart.addToCart(productService.getProductById(id));
            } else if (command.equals("/deletecart")) {
                System.out.println("Type ID of product to delete from cart");
                Long id = Long.valueOf(scanner.nextLine());
                cart.deleteFromCart(id);
            } else if (command.equals("/exit")) {
                System.out.println("goodbye");
                break;
            } else System.out.println("Unknown command");
        }

        context.close();
    }

}
