/**
 * This package is used to perform logic of the application.
 */
package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Order_Item;

public class Order_ItemServices implements CrudServices<Order_Item> {

	Dao<Order_Item> order_ItemDao;

	public Order_ItemServices(Dao<Order_Item> order_ItemDao) {
		this.order_ItemDao = order_ItemDao;
	}

	@Override
	public List<Order_Item> readAll() {
		return order_ItemDao.readAll();
	}

	@Override
	public void create(Order_Item order_Item) {
		order_ItemDao.create(order_Item);
	}

	@Override
	public void update(long id, Order_Item t) {
		order_ItemDao.update(id, t);

	}

	@Override
	public void update(Double valueOf, Order_Item t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long valueOf) {
		// TODO Auto-generated method stub
		order_ItemDao.delete(valueOf);

	}

}
