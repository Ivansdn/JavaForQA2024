package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        System.out.println(ProductType.SERVICE.name());

        Product ladakalina = new Product(UUID.randomUUID(), "Lada Kalina", 100, ProductType.GOOD);
        productRepository.save(ladakalina);
        Product bmw = new Product(UUID.randomUUID(), "BMW", 1000, ProductType.GOOD);
        productRepository.save(bmw);
        Product opel = new Product(UUID.randomUUID(), "Opel", 500, ProductType.GOOD);
        productRepository.save(opel);
        for (Product product : productRepository.findAll()) {
            System.out.println(product);
        }


        Customer ivan = new Customer(UUID.randomUUID(), "Ivanushka", "123456", 16);
        customerRepository.save(ivan);
        Customer vlad = new Customer(UUID.randomUUID(), "Vladislav", "001335", 19);
        customerRepository.save(vlad);
        Customer alex = new Customer(UUID.randomUUID(), "Alexander", "99999", 48);
        customerRepository.save(alex);
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }

    }

}