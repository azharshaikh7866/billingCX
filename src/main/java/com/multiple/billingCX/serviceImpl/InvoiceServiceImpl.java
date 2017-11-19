package com.multiple.billingCX.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.billingCX.model.Invoice;
import com.multiple.billingCX.repository.InvoiceRepository;
import com.multiple.billingCX.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public Invoice findById(int Id) {
		return invoiceRepository.findById(Id);
	}
	
	public List<Invoice> all(){
		return invoiceRepository.all();
	}
	

}
