package com.multiple.billingCX.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.billingCX.model.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable>{

}
