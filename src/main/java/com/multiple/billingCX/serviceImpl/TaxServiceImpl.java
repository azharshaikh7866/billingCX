package com.multiple.billingCX.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.billingCX.repository.TaxRepository;
import com.multiple.billingCX.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService {
	
	@Autowired
	TaxRepository TaxRepository;
	

}
