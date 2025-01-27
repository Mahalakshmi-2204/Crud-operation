package com.example.Spring_Crud_Operation.service;

import com.example.Spring_Crud_Operation.DTO.CustomerDto;
import com.example.Spring_Crud_Operation.entities.Customer;
import com.example.Spring_Crud_Operation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer SaveCustomerDetail(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public List<Customer> getAllDetails() {
        return customerRepository.findAll();

    }

    @Override
    public Customer getCustomerById(int id) {
        return  customerRepository.findById(id)
                .orElse(null);

        }

    @Override
    public Customer updateCustomerById(int id, Customer customer) {

        if (customerRepository.existsById(id)) {
            // Retrieve the existing customer from the database
            Customer existingCustomer = customerRepository.findById(id).orElse(null);

                  if (existingCustomer != null) {
                // Update the existing customer with the new details
                existingCustomer.setCustomerName(customer.getCustomerName());
                existingCustomer.setMobile(customer.getMobile());
                existingCustomer.setEmail(customer.getEmail());

                // Save the updated customer back to the database
                return customerRepository.save(existingCustomer);
            }
        }

           return null;
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);

    }
}



