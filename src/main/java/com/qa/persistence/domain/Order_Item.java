/**
 * This package is used to persist domain objects to the database.
 */
package com.qa.persistence.domain;

public class Order_Item {

	private Long Order_Item_Id;
	private Long Order_Id_FK;
	private Long Item_Id_FK;
	private Long Quantity;
	private Double Item_Discount_Price;

	public Order_Item(Long Order_Item_Id, Long Order_Id_FK, Long Item_Id_FK, Long Quantity,
			Double Item_Discount_Price) {
		this.Order_Item_Id = Order_Item_Id;
		this.Order_Id_FK = Order_Id_FK;
		this.Item_Id_FK = Item_Id_FK;
		this.Quantity = Quantity;
		this.Item_Discount_Price = Item_Discount_Price;
	}

	public Order_Item(Long order_Item_Id, Object order_Id_FK2, Object item_Id_FK2, Object quantity2,
			Object item_Discount_Price2) {
		// TODO Auto-generated constructor stub
	}

	public Long getOrder_Item_Id() {
		return Order_Item_Id;
	}

	public void setOrder_Item_Id(Long order_Item_Id) {
		Order_Item_Id = order_Item_Id;
	}

	public Long getOrder_Id_FK() {
		return Order_Id_FK;
	}

	public void setOrder_Id_FK(Long order_Id_FK) {
		Order_Id_FK = order_Id_FK;
	}

	public Long getItem_Id_FK() {
		return Item_Id_FK;
	}

	public void setItem_Id_FK(Long item_Id_FK) {
		Item_Id_FK = item_Id_FK;
	}

	public Long getQuantity() {
		return Quantity;
	}

	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}

	public Double getItem_Discount_Price() {
		return Item_Discount_Price;
	}

	public void setItem_Discount_Price(Double item_Discount_Price) {
		Item_Discount_Price = item_Discount_Price;
	}

	@Override
	public String toString() {
		return "Order_Item_Id:" + Order_Item_Id + "Order_Id_FK:" + Order_Id_FK + " Item_Id_FK:" + Item_Id_FK
				+ " Quantity:" + Quantity + " Item_Discount_Price:" + Item_Discount_Price;
	}

}
