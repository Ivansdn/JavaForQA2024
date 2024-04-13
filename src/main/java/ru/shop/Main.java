package ru.shop;

import ru.shop.Service.CustomerService;
import ru.shop.Service.OrderService;
import ru.shop.Service.ProductService;
import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductService(new ProductRepository());
        CustomerService customerService = new CustomerService(new CustomerRepository());
        OrderService orderService = new OrderService(new OrderRepository());

        System.out.println(ProductType.SERVICE.name());

        Product ladakalina = new Product(UUID.randomUUID(), "Lada Kalina", 100, ProductType.GOOD);
        productService.save(ladakalina);
        Product bmw = new Product(UUID.randomUUID(), "BMW", 1000, ProductType.GOOD);
        productService.save(bmw);
        Product carWashing = new Product(UUID.randomUUID(), "Car washing", 500, ProductType.SERVICE);
        productService.save(carWashing);
        for (Product product : productService.findAll()) {
            System.out.println(product);
        }


        Customer ivan = new Customer(UUID.randomUUID(), "Ivanushka", "123456", 16);
        customerService.save(ivan);
        Customer vlad = new Customer(UUID.randomUUID(), "Vladislav", "001335", 19);
        customerService.save(vlad);
        Customer alex = new Customer(UUID.randomUUID(), "Alexander", "99999", 48);
        customerService.save(alex);
        System.out.println("-- ALL CUSTOMERS --");


        orderService.add(vlad, bmw, 2);
        orderService.add(ivan, ladakalina, 5);
        orderService.add(alex, carWashing, 1);


        for (Customer customer : customerService.findAll()) {
            System.out.println(customer);
        }
        try {
            orderService.add(alex, bmw, 0);
        } catch (BadOrderCountException ex) {
            System.out.println("BadOrderException");
        }
        System.out.println("---Ivan's orders");
        for (Order order : orderService.findByCustomer(alex)) {
            System.out.println("order");
        }
        System.out.println("customer count: " + customerService.findAll().size());
        System.out.println("order count = " + orderService.findAll().size());
        for (Order order : orderService.findByCustomer(alex)) {
            System.out.println(orderService.findByCustomer(ivan) + "total sum = " + orderService.getTotalCustomerAmount(ivan));
        }
    }
}