/**
 * This package is used to take in a user inputs.
 */
package com.qa.controller;

import org.apache.log4j.Logger;

/**
 * Takes in item details for CRUD functionality
 *
 */

import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	/**
	 * Reads all items to the logger
	 */

	@Override
	public void readAll() {
		for (Item item : itemService.readAll()) {
			LOGGER.info(item.toString());
		}
	}

	/**
	 * Creates an item by taking in user input of item id, item name and item price
	 */

	@Override
	public void create() {
		LOGGER.info("Please enter a item id");
		String strItem_Id = Utils.getInput();
		Long Item_Id = Long.parseLong(strItem_Id);
		LOGGER.info("Please enter a item name");
		String Item_Name = Utils.getInput();
		LOGGER.info("Please enter a item price");
		String strItem_Price = Utils.getInput();
		Double Item_Price = Double.parseDouble(strItem_Price);

		itemService.create(new Item(Item_Id, Item_Name, Item_Price));
		LOGGER.info("Item created");
	}

	/**
	 * Updates an existing item by taking in user input of existing item id and new
	 * item name
	 */

	@Override
	public void update() {
		LOGGER.info("Please enter an existing item id");
		String strItem_Id = Utils.getInput();
		Long Item_Id = Long.parseLong(strItem_Id);
		LOGGER.info("Please enter a new item name");
		String newItem_Name = Utils.getInput();

		itemService.update(Long.valueOf(strItem_Id), new Item(Item_Id, newItem_Name, null));
		LOGGER.info("New Item name updated");

	}

	/**
	 * Deletes an existing item by the id of the item
	 */

	@Override
	public void delete() {
		LOGGER.info("Please enter an existing item id");
		String strItem_Id = Utils.getInput();

		itemService.delete(Long.valueOf(strItem_Id));
		LOGGER.info("Item deleted");

	}
}
