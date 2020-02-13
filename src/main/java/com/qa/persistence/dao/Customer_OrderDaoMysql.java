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

import com.qa.controller.Customer_OrderController;
import com.qa.persistence.domain.Customer_Order;

public class Customer_OrderDaoMysql implements Dao<Customer_Order> {

	public static final Logger logger = Logger.getLogger(Customer_OrderController.class);

	private String username;
	private String password;

	public Customer_OrderDaoMysql(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Customer_OrderDaoMysql() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reads all customer orders from the database
	 * 
	 * JDBC Execute SELECT Statement
	 */

	@Override
	public List<Customer_Order> readAll() {
		ArrayList<Customer_Order> customer_Orders = new ArrayList<Customer_Order>();
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Customer_Order");
			while (resultSet.next()) {
				Long Order_Id = resultSet.getLong("Order_Id");
				Long Customer_Id_FK = resultSet.getLong("Customer_Id_FK");
				String Order_Date = resultSet.getString("Order_Date");
				Double Total_Cost_of_Order = resultSet.getDouble("Total_Cost_of_Order");

				Customer_Order customer_Order = new Customer_Order(Order_Id, Customer_Id_FK, Order_Date,
						Total_Cost_of_Order);
				customer_Orders.add(customer_Order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer_Orders;
	}

	/**
	 * Creates a customer order in the database
	 * 
	 * JDBC Execute INSERT Statement
	 */

	@Override
	public void create(Customer_Order customer_Order) {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"insert into Customer_Order(Order_Id, Customer_Id_FK, Order_Date, Total_Cost_of_Order) values('"
							+ customer_Order.getOrder_Id() + "','" + customer_Order.getCustomer_Id_FK() + "','"
							+ customer_Order.getOrder_Date() + "','" + customer_Order.getTotal_Cost_of_Order() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates a customer order in the database
	 * 
	 * JDBC Executing UPDATE Statement
	 */

	@Override
	public void update(long id, Customer_Order customer_Order) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("update Customer_Order set Total_Cost_of_Order ='"
					+ customer_Order.getTotal_Cost_of_Order() + "' where Order_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a customer order in the database
	 * 
	 * JDBC Execute DELETE Statement
	 */

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from Customer_Order where Order_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
