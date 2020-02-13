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

import com.qa.controller.ItemController;
import com.qa.persistence.domain.Item;

public class ItemDaoMysql implements Dao<Item> {

	public static final Logger logger = Logger.getLogger(ItemController.class);

	private String username;
	private String password;

	public ItemDaoMysql(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public ItemDaoMysql() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reads all items from the database
	 * 
	 * JDBC Execute SELECT Statement
	 */

	@Override
	public List<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Item");
			while (resultSet.next()) {
				Long Item_Id = resultSet.getLong("Item_Id");
				String Item_Name = resultSet.getString("Item_Name");
				Double Item_Price = resultSet.getDouble("Item_Price");

				Item item = new Item(Item_Id, Item_Name, Item_Price);
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * Creates an item in the database
	 * 
	 * JDBC Execute INSERT Statement
	 */

	@Override
	public void create(Item item) {
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into Item(Item_Id, Item_Name, Item_Price) values('" + item.getItem_Id()
					+ "','" + item.getItem_Name() + "','" + item.getItem_Price() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates an item in the database
	 * 
	 * JDBC Executing UPDATE Statement
	 */

	@Override
	public void update(long id, Item item) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"update Item set Item_Name ='" + item.getItem_Name() + "' where Item_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Deletes an item in the database
	 * 
	 * JDBC Execute DELETE Statement
	 */

	@Override
	public void delete(long id) {

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://34.89.105.140:3306/Inventory_Management_Systemdb", username, password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from Item where Item_Id =" + id + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
