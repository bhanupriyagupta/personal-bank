package com.example.personalbankingservices.Repository;

import com.example.personalbankingservices.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
