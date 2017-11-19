/*
 * Part of a set of classes based on a sample database.
 * This example was written by Bruno Lowagie in the context of a book.
 * See http://developers.itextpdf.com/content/zugferd-future-invoicing/3-simple-invoice-database
 */
package com.multiple.billingCX.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Plain Old Java Object containing info about a Customer.
 * @author Bruno Lowagie (iText Software)
 */
@Entity
public class Customer {
    
    /** The id. */
	@Id
    private int id;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    private String mobile;
    
    /** The street. */
    private String street;
    
    /** The postal code. */
    private String postalcode;
    
    /** The city. */
    private String city;
    
    /** The country id. */
    private String country;

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
    
    

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param street the new street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalcode the new postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * Gets the country id.
     *
     * @return the country id
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country id.
     *
     * @param countryId the new country id
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("\n");
        sb.append("    First Name: ").append(firstName).append("\n");
        sb.append("    Last Name: ").append(lastName).append("\n");
        sb.append("    Street: ").append(street).append("\n");
        sb.append("    City: ").append(country).append(" ").append(postalcode).append(" ").append(city);
        return sb.toString();
    }
}
