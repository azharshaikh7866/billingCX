package com.multiple.billingCX.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.billingCX.repository.ItemRepository;
import com.multiple.billingCX.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository ItemRepository;
	

}
