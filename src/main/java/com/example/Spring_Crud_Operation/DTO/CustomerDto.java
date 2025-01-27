package com.example.Spring_Crud_Operation.DTO;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Column;


public class CustomerDto {

    private int customerId;

    private String customerName;

    private  String mobile;

    private String email;

    public CustomerDto(int customerId, String customerName, String mobile, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobile = mobile;
        this.email = email;
    }

    public CustomerDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int CustomerId) {
        this.customerId = CustomerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String CustomerName) {
         this.customerName = CustomerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String Mobile) {
        this.mobile = Mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "CustomerId=" + customerId +
                ", CustomerName='" + customerName + '\'' +
                ", Mobile=" + mobile +
                ", email='" + email + '\'' +
                '}';
    }
}
