package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer findById(int id);
    Customer update(int id,Customer customer);
    void remove(int id);
}
