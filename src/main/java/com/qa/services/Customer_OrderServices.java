/**
 * This package is used to perform logic of the application.
 */
package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer_Order;
import com.qa.persistence.domain.Order_Item;

public class Customer_OrderServices implements CrudServices<Customer_Order> {

	Dao<Customer_Order> customer_OrderDao;

	public Customer_OrderServices(Dao<Customer_Order> customer_OrderDao) {
		this.customer_OrderDao = customer_OrderDao;
	}

	@Override
	public List<Customer_Order> readAll() {
		return customer_OrderDao.readAll();
	}

	@Override
	public void create(Customer_Order customer_Order) {
		customer_OrderDao.create(customer_Order);
	}

	@Override
	public void update(long id, Customer_Order t) {
		customer_OrderDao.update(id, t);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		customer_OrderDao.delete(id);

	}

	@Override
	public void update(Double valueOf, Order_Item t) {
		// TODO Auto-generated method stub
	}

}
