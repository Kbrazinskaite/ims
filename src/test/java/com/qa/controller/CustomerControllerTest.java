package com.qa.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		String id = "1";
		String name = "John Spark";
		String street = "2 Coldhams Lane";
		String city = "London";
		String postCode = "E5 7HL";
		String country = "uk";
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(id, name, street, city, postCode, country));
		Mockito.doReturn(customers).when(customerController).getInput();
		customerController.readAll();
		Mockito.verify(customerServices, Mockito.times(1)).readAll(customers);

		// Mockito.when(customerServices.readAll()).thenReturn(customers);
		// assertEquals(customers, customerController.readAll());

	}

	@Test
	public void createTest() {
		String id = "1";
		String name = "Kristina";
		String street = "Quays";
		String city = "Salford";
		String postCode = "not sure";
		String country = "uk";
		Mockito.doReturn(id, name, street, city, postCode, country).when(customerController).getInput();
		Customer customer = new Customer(1L, name, street, city, postCode, country);
		customerController.create();
		Mockito.verify(customerServices, Mockito.times(1)).create(customer);

	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "2";
		String name = "Leona Lewis";
		Mockito.doReturn(id, name).when(customerController).getInput();
		customerController.update();
		Mockito.verify(customerServices, Mockito.times(1)).update(name);
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
