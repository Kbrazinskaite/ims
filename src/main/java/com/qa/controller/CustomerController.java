/**
 * This package is used to take in a user inputs.
 */
package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	/**
	 * get input method created for testing purpose
	 */

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */

	@Override
	public void readAll() {
		for (Customer customer : customerService.readAll()) {
			LOGGER.info(customer.toString());
		}
	}

	/**
	 * Creates a customer by taking in user input of customer id, customer name,
	 * surname, street, city, post code and country
	 */

	@Override
	public void create() {
		LOGGER.info("Please enter a customer id");
		String strCustomer_Id = getInput();
		long Customer_Id = Long.parseLong(strCustomer_Id);
		LOGGER.info("Please enter a customer name and surname");
		String Customer_Name = getInput();
		LOGGER.info("Please enter a street");
		String Street = getInput();
		LOGGER.info("Please enter a city");
		String City = getInput();
		LOGGER.info("Please enter a post code");
		String Post_Code = getInput();
		LOGGER.info("Please enter a country");
		String Country = getInput();

		customerService.create(new Customer(Customer_Id, Customer_Name, Street, City, Post_Code, Country));
		LOGGER.info("Customer created");
	}

	/**
	 * Updates an existing customer by taking in user input of existing customer id
	 * and new customer name and surname
	 */

	@Override
	public void update() {
		LOGGER.info("Please enter an existing customer id");
		String strCustomer_Id = getInput();
		Long Customer_Id = Long.parseLong(strCustomer_Id);
		LOGGER.info("Please enter a new customer name and surname");
		String newCustomer_Name = getInput();

		customerService.update(Long.valueOf(strCustomer_Id),
				new Customer(Customer_Id, newCustomer_Name, null, null, null, null));
		LOGGER.info("New Customer name updated");
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */

	@Override
	public void delete() {

		LOGGER.info("Please enter an existing customer id");
		String strCustomer_Id = getInput();

		customerService.delete(Long.valueOf(strCustomer_Id));
		LOGGER.info("Customer deleted");

	}

}
