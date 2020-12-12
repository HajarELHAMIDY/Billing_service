package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Product;

@FeignClient(name="PRODUCT-SERVICE")
public interface InventoryServiceClient {
	 @GetMapping("/products/{id}")
	 Product findProductById(@PathVariable("id") Long id); 
	 @GetMapping("/products")
	 PagedModel<Product> findAll(); 

}
