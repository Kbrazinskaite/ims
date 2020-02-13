/**
 * This package is used to persist domain objects to the database.
 */
package com.qa.persistence.domain;

public class Item {

	private Long Item_Id;
	private String Item_Name;
	private Double Item_Price;

	public Item(Long Item_Id, String Item_Name, Double Item_Price) {
		this.Item_Id = Item_Id;
		this.Item_Name = Item_Name;
		this.Item_Price = Item_Price;

	}

	public Long getItem_Id() {
		return Item_Id;
	}

	public void setItem_Id(Long item_Id) {
		Item_Id = item_Id;
	}

	public String getItem_Name() {
		return Item_Name;
	}

	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}

	public Double getItem_Price() {
		return Item_Price;
	}

	public void setItem_Price(Double item_Price) {
		Item_Price = item_Price;
	}

	@Override
	public String toString() {
		return "Item Id:" + Item_Id + " Item Name:" + Item_Name + " Item Price:" + Item_Price;
	}
}
