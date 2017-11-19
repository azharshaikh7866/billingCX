package com.multiple.billingCX.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.billingCX.model.Tax;

public interface TaxRepository extends JpaRepository<Tax, Serializable>{

}
