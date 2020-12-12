package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.BillRepository;
import com.example.demo.dao.ProductItemRepository;
import com.example.demo.entities.Bill;
import com.example.demo.entities.Customer;
import com.example.demo.entities.ProductItem;
import com.example.demo.service.CustomerServiceClient;
import com.example.demo.service.InventoryServiceClient;



@SpringBootApplication
@EnableFeignClients
public class BilingServiceApplication {

	 public static void main(String[] args) {
	        SpringApplication.run(BilingServiceApplication.class, args);
	    }
	    @Bean
	    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
	                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient) {
	        return args -> {
	            Bill bill = new Bill();
	            bill.setBuillingDate(new Date());
	            Customer customer = customerServiceClient.findCustomerById(1L);
	            System.out.println(customer);
	            bill.setCustomerId(customer.getId());
	            billRepository.save(bill);
	            inventoryServiceClient.findAll().getContent().forEach(p -> {
	                System.out.println(p);
	                productItemRepository.save(new ProductItem(null, null, p.getId(),
	                		p.getPrice(), (int) (1 + Math.random() * 1000), bill));
	            });
	        };
	    }
		

}
