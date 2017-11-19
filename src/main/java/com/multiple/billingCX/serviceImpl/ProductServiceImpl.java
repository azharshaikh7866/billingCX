package com.multiple.billingCX.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.billingCX.repository.ProductRepository;
import com.multiple.billingCX.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository ProductRepository;
	

}
