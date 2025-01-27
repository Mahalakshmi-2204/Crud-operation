package com.example.Spring_Crud_Operation.service;

import com.example.Spring_Crud_Operation.entities.Customer;
import com.example.Spring_Crud_Operation.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    void setup(){
        customer=Customer.builder().customerName("maha").mobile("3423535656").email("maha123@gmail.com").build();
    }

    @Test
    void saveCustomerDetailTest() {
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);
        Customer saveCustomer = customerService.SaveCustomerDetail(customer);
        Assertions.assertThat(saveCustomer).isNotNull();

    }

    @Test
    void getAllDetailsTest() {
    }
//
//    @Test
//    void getCustomerById() {
//    }
//
//    @Test
//    void updateCustomerById() {
//    }
//
//    @Test
//    void deleteCustomerById() {
//    }
}