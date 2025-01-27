package com.example.Spring_Crud_Operation.controller;

import com.example.Spring_Crud_Operation.entities.Customer;
import com.example.Spring_Crud_Operation.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Controller.class)
//@AutoConfigureMockMvc (addFilters = false)
@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;


    private Customer customer;

    @BeforeEach
    void setup(){
        customer=Customer.builder().customerName("maha").mobile("3423535656").email("maha123@gmail.com").build();
    }

    @Test
    void createCustomerTest() throws Exception{
//                Customer customer=Customer.builder().customerName("maha").mobile("3423535656").email("maha123@gmail.com").build();

//        when(customerService.SaveCustomerDetail(customer)).toString();
//      mockMvc.perform(post("api/v1/customer)")
//              .andExcept(status().isOk())

        given(customerService.SaveCustomerDetail(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/api/v1/customer/save").
                        contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)));

               response .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customerName", CoreMatchers.is(customer.getCustomerName())))
                .andExpect(jsonPath("$.email",CoreMatchers.is(customer.getEmail())))
                .andExpect(jsonPath("$.mobile",CoreMatchers.is(customer.getMobile())));

    }

//    @Test
//    void getCustomerById() {
//    }
//
//    @Test
//    void getAllDetails() {
//    }
//
//    @Test
//    void updateCustomerDetails() {
//    }
//
//    @Test
//    void deleteCustomerDetails() {
//    }
}