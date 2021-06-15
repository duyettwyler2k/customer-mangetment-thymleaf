package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer findById(int id);
    Customer update(int id,Customer customer);
    void remove(int id);
}
