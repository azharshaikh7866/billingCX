package com.multiple.billingCX.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiple.billingCX.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Serializable>{
	
	@Query("Select i from Invoice i left join fetch i.customer c left join fetch i.items item left join fetch item.product p left join fetch p.category left join fetch p.taxes where i.id=?1")
	public Invoice findById(int id);
	
	@Query("Select i from Invoice i left join fetch i.customer c left join fetch i.items item left join fetch item.product p left join fetch p.category left join fetch p.taxes group by i.id")
	public List<Invoice> all();

}
