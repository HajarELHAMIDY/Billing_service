package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
	Customer findCustomerById(@PathVariable("id") Long id); 
}
