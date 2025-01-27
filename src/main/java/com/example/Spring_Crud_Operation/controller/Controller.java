package com.example.Spring_Crud_Operation.controller;

import com.example.Spring_Crud_Operation.DTO.CustomerDto;
import com.example.Spring_Crud_Operation.entities.Customer;
import com.example.Spring_Crud_Operation.repository.CustomerRepository;
import com.example.Spring_Crud_Operation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class Controller {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

//        return ResponseEntity.ok(customerService.SaveCustomerDetail(customer));
        Customer savedCustomer = customerService.SaveCustomerDetail(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer!=null ?ResponseEntity.ok(customer): ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllDetails(){
        return ResponseEntity.ok(customerService.getAllDetails());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerDetails(@PathVariable Integer id ,@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomerById(id,customer));
    }

    @DeleteMapping( "/{id}")
    public ResponseEntity<String> deleteCustomerDetails(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        String responseMsg= "Customer with ID " + id + " has been successfully deleted.";
        return ResponseEntity.ok(responseMsg);

    }


}
