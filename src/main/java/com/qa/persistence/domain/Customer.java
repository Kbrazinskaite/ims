/**
 * This package is used to persist domain objects to the database.
 */
package com.qa.persistence.domain;

public class Customer {

	private Long customerId;
	private String name;
	private String street;
	private String city;
	private String postCode;
	private String country;

	public Customer(Long customerId, String name, String street, String city, String postCode, String country) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	public Customer(long l, String name2) {
		// TODO Auto-generated constructor stub
	}

	public Customer(String string, String name2, String street2, String city2, String postCode2, String country2) {
		// TODO Auto-generated constructor stub
	}

	public Long getCustomer_Id() {
		return customerId;
	}

	public void setCustomer_Id(Long customer_Id) {
		customerId = customer_Id;
	}

	public String getCustomer_Name() {
		return name;
	}

	public void setCustomer_Name(String customer_Name) {
		name = customer_Name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		city = city;
	}

	public String getPost_Code() {
		return postCode;
	}

	public void setPost_Code(String post_Code) {
		postCode = post_Code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		country = country;
	}

	@Override
	public String toString() {
		return "Customer Id:" + customerId + " Customer Name:" + name + " Street:" + street + " City:" + city
				+ " Post_Code:" + postCode + " Country:" + country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
