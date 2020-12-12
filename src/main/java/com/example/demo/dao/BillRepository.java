package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Bill;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {

}
