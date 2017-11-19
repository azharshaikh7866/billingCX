package com.multiple.billingCX.service;

import java.util.List;

import com.multiple.billingCX.model.Invoice;

public interface InvoiceService {
	
	public Invoice findById(int Id);
	
	public List<Invoice> all();

}
