package com.multiple.billingCX.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.billingCX.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Serializable>{

}
