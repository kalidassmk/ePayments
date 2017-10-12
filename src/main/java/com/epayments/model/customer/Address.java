package com.epayments.model.customer;

import javax.validation.constraints.NotNull;

/**
 * The type Address.
 */
public class Address {
	
	@NotNull
	private String street1;
	
	private String street2;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String zipCode;

    /**
     * Instantiates a new Address.
     */
    public Address() {
	}

    /**
     * Instantiates a new Address.
     *
     * @param street1 the street 1
     * @param street2 the street 2
     * @param city    the city
     * @param state   the state
     * @param zipCode the zip code
     */
    public Address(String street1, String street2, String city, String state, String zipCode) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

    /**
     * Gets street 1.
     *
     * @return the street 1
     */
    public String getStreet1() {
		return street1;
	}

    /**
     * Sets street 1.
     *
     * @param street1 the street 1
     */
    public void setStreet1(String street1) {
		this.street1 = street1;
	}

    /**
     * Gets street 2.
     *
     * @return the street 2
     */
    public String getStreet2() {
		return street2;
	}

    /**
     * Sets street 2.
     *
     * @param street2 the street 2
     */
    public void setStreet2(String street2) {
		this.street2 = street2;
	}

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
		return city;
	}

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
		this.city = city;
	}

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
		return state;
	}

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
		this.state = state;
	}

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
		return zipCode;
	}

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
