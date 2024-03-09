package com.devops.assignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devops.assignment.controller.CustomerController;
import com.devops.assignment.model.Customer;
import com.devops.assignment.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController controller;

    @Mock
    private CustomerRepository repository;

    @Test
    void TestCreateCustomer() throws Exception {
        lenient().when(repository.save(Mockito.any(Customer.class))).thenReturn(new Customer());
        assertThat(controller.createCustomer(new Customer())).isNotNull();
    }

}
