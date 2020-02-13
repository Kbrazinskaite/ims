package com.qa.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer;
	private Customer other;

	@Before
	public void setUp() {
		customer = new Customer(1L, "Bill Jones", "4 Howards Road", "London", "2 EM 3 LM", "UK");
		other = new Customer(1L, "Bill Jones", "4 Howards Road", "London", "2 EM 3 LM", "UK");
	}

	@Test
	public void settersTest() {
		assertNotNull(customer.getcustomerId());
		assertNotNull(customer.getname());
		assertNotNull(customer.getstreet());
		assertNotNull(customer.getcity());
		assertNotNull(customer.getpostCode());
		assertNotNull(customer.getcountry());

		customer.setcustomerId(null);
		assertNull(customer.getcustomerId());
		customer.setname(null);
		assertNull(customer.getname());
		customer.setstreet(null);
		assertNull(customer.getstreet());
		customer.setcity(null);
		assertNull(customer.getcity());
		customer.setpostCode(null);
		assertNull(customer.getpostCode());
		customer.setcountry(null);
		assertNull(customer.getcountry());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}

	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getcustomerId(), 0);
		assertEquals("Bill Jones", customer.getname());
		assertEquals("4 Howards Road", customer.getstreet());
		assertEquals("London", customer.getcity());
		assertEquals("2 EM 3 LM", customer.getpostCode());
		assertEquals("UK", customer.getcountry());
	}

	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setname(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setname("rhys");
		assertFalse(customer.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setname(null);
		other.setname(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		other.setId(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setSurname("thompson");
		assertFalse(customer.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Chris", "Perrins");
		assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null);
		Customer other = new Customer(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 first name:Chris surname:Perrins";
		assertEquals(toString, customer.toString());
	}

}
