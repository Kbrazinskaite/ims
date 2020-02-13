/**
 * This package is used to take in a user inputs.
 */
package com.qa.controller;

import org.apache.log4j.Logger;

/**
 * Takes in customer order details for CRUD functionality
 *
 */

import com.qa.persistence.domain.Customer_Order;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class Customer_OrderController implements CrudController<Customer_Order> {

	public static final Logger LOGGER = Logger.getLogger(Customer_OrderController.class);

	private CrudServices<Customer_Order> customer_OrderService;

	public Customer_OrderController(CrudServices<Customer_Order> customer_OrderService) {
		this.customer_OrderService = customer_OrderService;
	}

	/**
	 * Reads all customer orders to the logger
	 */

	@Override
	public void readAll() {
		for (Customer_Order customer_Order : customer_OrderService.readAll()) {
			LOGGER.info(customer_Order.toString());
		}
	}

	/**
	 * Creates a customer order by taking in user input of order id, customer id
	 * foreign key, order date, total cost of order
	 */

	@Override
	public void create() {
		LOGGER.info("Please enter a order id");
		String strOrder_Id = Utils.getInput();
		Long Order_Id = Long.parseLong(strOrder_Id);

		LOGGER.info("Please enter a customer id foreign key");
		String strCustomer_Id_FK = Utils.getInput();
		Long Customer_Id_FK = Long.parseLong(strCustomer_Id_FK);

		LOGGER.info("Please enter a order date in a format of YYYY-MM-DD");
		String Order_Date = Utils.getInput();

		LOGGER.info("Please enter a total cost of order in a format of 0.00");
		String strTotal_Cost_of_Order = Utils.getInput();
		Double Total_Cost_of_Order = Double.parseDouble(strTotal_Cost_of_Order);

		customer_OrderService.create(new Customer_Order(Order_Id, Customer_Id_FK, Order_Date, Total_Cost_of_Order));
		LOGGER.info("Customer Order created");
	}

	/**
	 * Updates an existing customer order by taking in user input of existing order
	 * id and new total cost of order
	 */

	@Override
	public void update() {
		LOGGER.info("Please enter an existing order id");
		String strOrder_Id = Utils.getInput();
		Long Order_Id = Long.parseLong(strOrder_Id);

		LOGGER.info("Please enter a new total cost of order");
		String strTotal_Cost_of_Order = Utils.getInput();
		Double Total_Cost_of_Order = Double.parseDouble(strTotal_Cost_of_Order);

		customer_OrderService.update(Long.valueOf(strOrder_Id),
				new Customer_Order(Order_Id, null, null, Total_Cost_of_Order));
		LOGGER.info("New total cost of order updated");

	}

	/**
	 * Deletes an existing customer order by the id of customer order
	 */

	@Override
	public void delete() {

		LOGGER.info("Please enter an existing order id");
		String strOrder_Id = Utils.getInput();

		customer_OrderService.delete(Long.valueOf(strOrder_Id));
		LOGGER.info("Order deleted");

	}

}
