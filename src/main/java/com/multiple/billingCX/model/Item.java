/*
 * Part of a set of classes based on a sample database.
 * This example was written by Bruno Lowagie in the context of a book.
 * See http://developers.itextpdf.com/content/zugferd-future-invoicing/3-simple-invoice-database
 */
package com.multiple.billingCX.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Plain Old Java Object containing info about an Item.
 * @author Bruno Lowagie (iText Software)
 */
@Entity
public class Item {
    
    /** The item. */
	@Id
    private int id;
    
    /** The product. */
	@OneToOne
    private Product product;
    
    /** The quantity. */
    private int quantity;
    
    /** The cost. */
    private double cost;
    
    private double tax;
    
    private double amount;
    
    
    @ManyToOne
    private Invoice invoice;
    

   
 
    public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
     * Gets the product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param product the new product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the cost.
     *
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost.
     *
     * @param cost the new cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  #").append(id);
        sb.append(product.toString());
        sb.append("\tQuantity: ").append(quantity);
        sb.append("\tCost: ").append(cost).append("\u20ac");
        return sb.toString();
    }
}
