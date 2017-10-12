package com.epayments.model.customer;

/**
 * The type Customer info.
 */
public class CustomerInfo {
	
	private Name name;
    /**
     * The Passport no.
     */
    private String passportNo;
    /**
     * The Phone number.
     */
    private String phoneNumber;
    /**
     * The Address.
     */
    private Address address;

    private String dateOfBirth;

    /**
     * Instantiates a new Customer info.
     */
    public CustomerInfo() {
    }

    /**
     * Instantiates a new Customer info.
     *
     * @param name        the name
     * @param passportNo  the passport no
     * @param phoneNumber the phone number
     * @param address     the address
     * @param dateOfBirth the date of birth
     */
    public CustomerInfo(Name name, String passportNo, String phoneNumber, Address address, String dateOfBirth) {
        this.name = name;
        this.passportNo = passportNo;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Sets passport no.
     *
     * @param passportNo the passport no
     */
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public Name getName() {
		return name;
	}

    /**
     * Gets passport no.
     *
     * @return the passport no
     */
    public String getPassportNo() {
		return passportNo;
	}

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
		return phoneNumber;
	}

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
		return address;
	}

}
