package ru.shop.Service;

import ru.shop.model.Customer;
import ru.shop.repository.CRepository;
import ru.shop.repository.CustomerRepository;

import java.util.List;


public class CustomerService implements ICService {
    private final CRepository<Customer> repository;

    public CustomerService(CRepository <Customer> repository) {

        this.repository = repository;
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
