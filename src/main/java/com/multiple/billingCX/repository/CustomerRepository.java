package com.multiple.billingCX.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.billingCX.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable>{

}
