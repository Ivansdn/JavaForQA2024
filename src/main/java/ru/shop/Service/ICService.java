package ru.shop.Service;

import ru.shop.model.Customer;

import java.util.List;

public interface ICService {
    void save(Customer customer);

    List<Customer> findAll();
}
