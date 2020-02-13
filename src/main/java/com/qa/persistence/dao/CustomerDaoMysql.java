/**
 * This package is used to to send the data to the database.
 */
package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;

public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger logger = Logger.getLogger(CustomerController.class);
	private String username;
	private String password;

	public CustomerDaoMysql(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Reads all customers from the database
	 * 
	 * JDBC Execute SELECT Statement
	 */

	@Override
	public List<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Customer");
			while (resultSet.next()) {
				Long Customer_Id = resultSet.getLong("Customer_Id");
				String Customer_Name = resultSet.getString("Customer_Name");
				String Street = resultSet.getString("Street");
				String City = resultSet.getString("City");
				String Post_Code = resultSet.getString("Post_Code");
				String Country = resultSet.getString("Country");

				Customer customer = new Customer(Customer_Id, Customer_Name, Street, City, Post_Code, Country);
				customers.add(customer);
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return customers;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * JDBC Execute INSERT Statement
	 */

	@Override
	public void create(Customer customer) {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"insert into Customer(Customer_Id, Customer_Name, Street, City, Post_Code, Country) values('"
							+ customer.getCustomer_Id() + "','" + customer.getCustomer_Name() + "','"
							+ customer.getStreet() + "','" + customer.getCity() + "','" + customer.getPost_Code()
							+ "','" + customer.getCountry() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates a customer in the database
	 * 
	 * JDBC Executing UPDATE Statement
	 */

	@Override
	public void update(long id, Customer customer) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("update Customer set Customer_Name ='" + customer.getCustomer_Name()
					+ "' where Customer_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * JDBC Execute DELETE Statement
	 */

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from Customer where Customer_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
