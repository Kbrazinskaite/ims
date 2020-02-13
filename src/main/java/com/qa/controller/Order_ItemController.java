/**
 * This package is used to take in a user inputs.
 */
package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Order_Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * Takes in order item details for CRUD functionality
 *
 */

public class Order_ItemController implements CrudController<Order_Item> {

	public static final Logger LOGGER = Logger.getLogger(Order_ItemController.class);

	private CrudServices<Order_Item> order_ItemService;

	public Order_ItemController(CrudServices<Order_Item> order_ItemService) {
		this.order_ItemService = order_ItemService;
	}

	/**
	 * Reads all order items to the logger
	 */

	@Override
	public void readAll() {
		for (Order_Item order_Item : order_ItemService.readAll()) {
			LOGGER.info(order_Item.toString());
		}
	}

	/**
	 * Creates an order item by taking in user input of order item id, order id
	 * foreign key, item id foreign key, quantity and item discount price
	 */

	@Override
	public void create() {
		LOGGER.info("Please enter a order item id");
		String strOrder_Item_Id = Utils.getInput();
		Long Order_Item_Id = Long.parseLong(strOrder_Item_Id);

		LOGGER.info("Please enter a order id foreign key");
		String strOrder_Id_FK = Utils.getInput();
		Long Order_Id_FK = Long.parseLong(strOrder_Id_FK);

		LOGGER.info("Please enter a item id foreign key");
		String strItem_Id_FK = Utils.getInput();
		Long Item_Id_FK = Long.parseLong(strItem_Id_FK);

		LOGGER.info("Please enter a quantity");
		String strQuantity = Utils.getInput();
		Long Quantity = Long.parseLong(strQuantity);

		LOGGER.info("Please enter a item discount price");
		String strItem_Discount_Price = Utils.getInput();
		Double Item_Discount_Price = Double.parseDouble(strItem_Discount_Price);

		order_ItemService.create(new Order_Item(Order_Item_Id, Order_Id_FK, Item_Id_FK, Quantity, Item_Discount_Price));
		LOGGER.info("Order_Item created");
	}

	/**
	 * Updates an existing order item by taking in user input of existing order id
	 * foreign key and new item discount price
	 */

	@Override
	public void update() {

		LOGGER.info("Please enter an existing order id foreign key");
		String strOrder_Id_FK = Utils.getInput();
		Long Order_Id_FK = Long.parseLong(strOrder_Id_FK);
		LOGGER.info("Please enter a new item discount price");
		String strItem_Discount_Price = Utils.getInput();
		Double Item_Discount_Price = Double.parseDouble(strItem_Discount_Price);

		order_ItemService.update(Long.valueOf(strOrder_Id_FK),
				new Order_Item(null, Order_Id_FK, null, null, Item_Discount_Price));
		LOGGER.info("New item discount price updated");

	}

	/**
	 * Deletes an existing order item by the id of the order item
	 */

	@Override
	public void delete() {
		LOGGER.info("Please enter an existing order item id");
		String strOrder_Item_Id = Utils.getInput();
		// Long Order_Item_Id = Long.parseLong(strOrder_Item_Id);

		order_ItemService.delete(Long.valueOf(strOrder_Item_Id));
		LOGGER.info("Item deleted");

	}

}
