package com.qa.contoller.persistence.dao;

import org.junit.Test;

import com.qa.persistence.dao.CustomerDaoMysql;
import com.qa.persistence.domain.Customer;

public class CustomerDaoTest {

	@Test
	public void updateCustomer() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "Galimybe@321");

		customerDaoMysql.update(1L, new Customer(null, "Ted Morris", "1 Kings Street", "Manchester", "M6 4LN", "UK"));
	}
}
