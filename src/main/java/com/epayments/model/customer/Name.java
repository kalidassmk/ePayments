package com.epayments.model.customer;

import javax.validation.constraints.NotNull;

/**
 * The type Name.
 */
public class Name {

	@NotNull
	private String title;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	/**
	 * Instantiates a new Name.
	 */
	public Name() {
	}

	/**
	 * Instantiates a new Name.
	 *
	 * @param title     the title
	 * @param firstName the first name
	 * @param lastName  the last name
	 */
	public Name(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
