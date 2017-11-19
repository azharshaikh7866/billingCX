/*
 * Part of a set of classes based on a sample database.
 * This example was written by Bruno Lowagie in the context of a book.
 * See http://developers.itextpdf.com/content/zugferd-future-invoicing/3-simple-invoice-database
 */
package com.multiple.billingCX.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Plain Old Java Object containing info about a Product.
 * @author Bruno Lowagie (iText Software)
 */
@Entity
public class Product {
    
    /** The id. */
	@Id
    private int id;
    
    /** The name. */
    private String name;
    
    
    @ManyToOne
    private Category category;
    
    @OneToMany(mappedBy="product")
    private Set<Tax> taxes;
    
    /** The price. */
    private double price;
    
    
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	


	public Set<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(Set<Tax> taxes) {
		this.taxes = taxes;
	}

	/**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t(").append(id).append(")\t").append(name).append("\t").append(price);
        return sb.toString();
    }
}
