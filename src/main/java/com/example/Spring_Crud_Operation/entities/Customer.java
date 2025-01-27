package com.example.Spring_Crud_Operation.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name= "customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="mobile")
    private  String mobile;

    @Column(name="email")
    private String email;



//    public Customer(int customerId, String customerName, String mobile, String email) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.mobile = mobile;
//        this.email = email;
//    }
//
//    public Customer() {
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "CustomerId=" + customerId +
//                ", CustomerName='" + customerName + '\'' +
//                ", Mobile=" + mobile +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
