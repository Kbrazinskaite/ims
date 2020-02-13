/**
 * This package is used to perform logic of the application.
 */
package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order_Item;

public class ItemServices implements CrudServices<Item> {

	Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	@Override
	public void create(Item item) {
		itemDao.create(item);
	}

	@Override
	public void update(long id, Item t) {
		itemDao.update(id, t);
	}

	@Override
	public void update(Double valueOf, Order_Item t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long valueOf) {
		// TODO Auto-generated method stub
		itemDao.delete(valueOf);

	}

}
