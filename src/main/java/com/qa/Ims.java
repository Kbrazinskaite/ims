/**
 * This package is the parent of the qa project.
 */
package com.qa;

import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.Customer_OrderController;
import com.qa.controller.ItemController;
import com.qa.controller.Order_ItemController;
import com.qa.persistence.dao.CustomerDaoMysql;
import com.qa.persistence.dao.Customer_OrderDaoMysql;
import com.qa.persistence.dao.ItemDaoMysql;
import com.qa.persistence.dao.Order_ItemDaoMysql;
import com.qa.persistence.domain.Domain;
import com.qa.services.CustomerServices;
import com.qa.services.Customer_OrderServices;
import com.qa.services.ItemServices;
import com.qa.services.Order_ItemServices;
import com.qa.utils.Utils;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInput();

		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();

		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();

		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(
					new CustomerServices(new CustomerDaoMysql(username, password)));
			doAction(customerController, action);
			break;
		case ITEM:
			ItemController itemController = new ItemController(new ItemServices(new ItemDaoMysql(username, password)));
			doAction(itemController, action);
			break;
		case ORDER:
			Customer_OrderController customer_OrderController = new Customer_OrderController(
					new Customer_OrderServices(new Customer_OrderDaoMysql(username, password)));
			doAction(customer_OrderController, action);
			break;

		case ORDER_ITEM:
			Order_ItemController order_ItemController = new Order_ItemController(
					new Order_ItemServices(new Order_ItemDaoMysql(username, password)));
			doAction(order_ItemController, action);
			break;

		case STOP:
			break;
		}

	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		}
	}
}
