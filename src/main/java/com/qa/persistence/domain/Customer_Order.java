/**
 * This package is used to persist domain objects to the database.
 */
package com.qa.persistence.domain;

/**
 * Customer order class is created
 */

public class Customer_Order {

	/**
	 * Customer order private variables created
	 */

	private Long Order_Id;
	private Long Customer_Id_FK;
	private String Order_Date;
	private Double Total_Cost_of_Order;

	public Customer_Order(Long Order_Id, Long Customer_Id_FK, String Order_Date, Double Total_Cost_of_Order) {
		this.Order_Id = Order_Id;
		this.Customer_Id_FK = Customer_Id_FK;
		this.Order_Date = Order_Date;
		this.Total_Cost_of_Order = Total_Cost_of_Order;

	}

	/**
	 * Customer order getters and setters
	 */

	public Long getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(Long order_Id) {
		Order_Id = order_Id;
	}

	public Long getCustomer_Id_FK() {
		return Customer_Id_FK;
	}

	public void setCustomer_Id_FK(Long customer_Id_FK) {
		Customer_Id_FK = customer_Id_FK;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}

	public Double getTotal_Cost_of_Order() {
		return Total_Cost_of_Order;
	}

	public void setTotal_Cost_of_Order(Double total_Cost_of_Order) {
		Total_Cost_of_Order = total_Cost_of_Order;
	}

	@Override
	public String toString() {
		return "Order Id:" + Order_Id + " Customer Id Foreign Key:" + Customer_Id_FK + " Order Date:" + Order_Date
				+ " Total Cost of Order:" + Total_Cost_of_Order;
	}

}
