package ru.shop.repository;

import ru.shop.model.Customer;

import java.util.List;

public interface CRepository <T>{
    void save( T entity);

    List<T> findAll();
}
