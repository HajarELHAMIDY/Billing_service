package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BillRepository;
import com.example.demo.dao.ProductItemRepository;
import com.example.demo.entities.Bill;
import com.example.demo.service.CustomerServiceClient;
import com.example.demo.service.InventoryServiceClient;

@RestController
public class BillRestController {
	@Autowired private BillRepository billRepository; 
	@Autowired private ProductItemRepository productItemRepository;
	@Autowired private CustomerServiceClient customerServiceClient; 
	@Autowired private InventoryServiceClient inventoryServiceClient; 
	@GetMapping("/bills/full/{id}")
	Bill getBill(@PathVariable(name="id") Long id) {
		Bill bill = billRepository.findById(id).get();
		bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerId()));
		bill.setProductsItems(productItemRepository.findByBillId(id));
		bill.getProductsItems().forEach(pr->{
			pr.setProduct(inventoryServiceClient.findProductById(pr.getProductID()));
		});
		return bill; 
		
	}
	

}
