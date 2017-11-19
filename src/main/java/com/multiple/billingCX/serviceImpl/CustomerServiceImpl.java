package com.multiple.billingCX.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.billingCX.repository.CustomerRepository;
import com.multiple.billingCX.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository CustomerRepository;
	

}
