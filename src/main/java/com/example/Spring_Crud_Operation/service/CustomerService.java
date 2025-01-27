package com.example.Spring_Crud_Operation.service;

import com.example.Spring_Crud_Operation.DTO.CustomerDto;
import com.example.Spring_Crud_Operation.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer SaveCustomerDetail(Customer customer);
    List<Customer> getAllDetails();
    Customer getCustomerById(int id);
    Customer updateCustomerById(int id, Customer customer);
    void deleteCustomerById(int id);

}
