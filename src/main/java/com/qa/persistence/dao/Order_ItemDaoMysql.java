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

import com.qa.controller.Order_ItemController;
import com.qa.persistence.domain.Order_Item;

public class Order_ItemDaoMysql implements Dao<Order_Item> {

	public static final Logger logger = Logger.getLogger(Order_ItemController.class);

	private String username;
	private String password;

	public Order_ItemDaoMysql(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Order_ItemDaoMysql() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reads all order items from the database
	 * 
	 * JDBC Execute SELECT Statement
	 */

	@Override
	public List<Order_Item> readAll() {
		ArrayList<Order_Item> order_Items = new ArrayList<Order_Item>();
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Order_Item");
			while (resultSet.next()) {

				Long Order_Item_Id = resultSet.getLong("Order_Item_Id");
				Long Order_Id_FK = resultSet.getLong("Order_Id_FK");
				Long Item_Id_FK = resultSet.getLong("Item_Id_FK");
				Long Quantity = resultSet.getLong("Quantity");
				Double Item_Discount_Price = resultSet.getDouble("Item_Discount_Price");

				Order_Item order_Item = new Order_Item(Order_Item_Id, Order_Id_FK, Item_Id_FK, Quantity,
						Item_Discount_Price);
				order_Items.add(order_Item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order_Items;
	}

	/**
	 * Creates an order item in the database
	 * 
	 * JDBC Execute INSERT Statement
	 */

	@Override
	public void create(Order_Item order_Item) {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"insert into Order_Item(Order_Id_FK, Item_Id_FK, Quantity, Item_Discount_Price) values('"
							+ order_Item.getOrder_Id_FK() + "','" + order_Item.getItem_Id_FK() + "','"
							+ order_Item.getQuantity() + "','" + order_Item.getItem_Discount_Price() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates an order item in the database
	 * 
	 * JDBC Executing UPDATE Statement
	 */

	@Override
	public void update(long id, Order_Item order_Item) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("update Order_Item set Item_Discount_Price ='" + order_Item.getItem_Discount_Price()
					+ "' where Order_Id_FK =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an order item in the database
	 * 
	 * JDBC Execute DELETE Statement
	 */

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from Order_Item where Order_Item_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
