package com.multiple.billingCX.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.billingCX.model.Item;

public interface ItemRepository extends JpaRepository<Item, Serializable>{

}
