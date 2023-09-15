package com.senacre.ecommerce.TestConfig;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.senacre.ecommerce.Entities.OrderStatus;
import com.senacre.ecommerce.Model.Category;
import com.senacre.ecommerce.Model.Order;
import com.senacre.ecommerce.Model.Product;
import com.senacre.ecommerce.Model.Usuario;
import com.senacre.ecommerce.Model.Repositories.CategoryRepository;
import com.senacre.ecommerce.Model.Repositories.OrderRepository;
import com.senacre.ecommerce.Model.Repositories.ProductRepository;
import com.senacre.ecommerce.Model.Repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics"); 
        Category cat2 = new Category(null, "Books"); 
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "O filme já é uma chatice imagina o livro kkkk.", 90.5, ""); 
        Product p2 = new Product(null, "Smart TV", "Pra assistir suas séries no fim de semana e esquecer o P.I.", 4190.0, ""); 
        Product p3 = new Product(null, "Macbook Pro", "Vai de Mac, Rwindows é para os pobres.", 14250.0, ""); 
        Product p4 = new Product(null, "PC Gamer", "Divirta-se com games em alta resolução e sem travar", 8200.0, ""); 
        Product p5 = new Product(null, "iphone 14 Pro Max", "Pague caro por 'status' e tenha uma câmera mediocre", 14000.99, ""); 

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Usuario u1 = new Usuario(0, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        Usuario u2 = new Usuario(0, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITTING_PAYMENT, u2); 
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITTING_PAYMENT, u1);



        userRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }


    
}
