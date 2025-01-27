package com.example.Spring_Crud_Operation.repository;

import com.example.Spring_Crud_Operation.entities.Customer;
//import com.example.Spring_Crud_Operation.entities.Role;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    public void CustomerRepository_SaveAll(){

//        role.setRoleName("admin");
//        Set<Role> roles = new HashSet<>();
//         roles.add();

//        Role role=Role.builder()
//                .roleName("admin")
//                .build();

        Customer customer=Customer.builder()
//                .customerId(1)
                .customerName("maha")
                .mobile("3257568578")
                .email("maha@gmail.com")
//                .roles(new HashSet<>(Set.of(role)))
                .build();


        Customer saveCustomer= customerRepository.save(customer);

        Assertions.assertThat(saveCustomer).isNotNull();
        Assertions.assertThat(saveCustomer.getEmail()).isEqualTo("maha@gmail.com");
    }

}