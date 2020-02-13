/**
 * This package is used to perform logic of the application.
 */
package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Order_Item;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public void update(long id, Customer customer) {
		customerDao.update(id, customer);

	}

	@Override
	public void delete(Long valueOf) {
		customerDao.delete(valueOf);
	}

	@Override
	public void update(Double valueOf, Order_Item t) {
		// TODO Auto-generated method stub

	}

	public void update(String name) {
		// TODO Auto-generated method stub

	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void update(long l) {
		// TODO Auto-generated method stub

	}

	public void readAll(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void readAll(List<Customer> customers) {
		// TODO Auto-generated method stub

	}

}
