package org.telekomatrix.hbase.connection.service.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerInfoTest {

	private CustomerInformation customerInfo;
	
	@Before
	public void init() {
		customerInfo = getCustomer();
	}
	
	@Test
	public void customerFirstNameTest() {
		assertEquals("Rithicaa", customerInfo.getFirstName());
	}
	
	@Test
	public void customerLastNameTest() {
		assertEquals("Sundaram", customerInfo.getLastName());
	}
	
	@Test
	public void customerRoleTest() {
		assertEquals("Sale", customerInfo.getRole());
	}
	
	@Test
	public void customerAgeTest() {
		assertEquals(21, customerInfo.getAge());
	}
	
	private CustomerInformation getCustomer() {
		customerInfo = new CustomerInformation();
		customerInfo.setFirstName("Rithicaa");
		customerInfo.setLastName("Sundaram");
		customerInfo.setRole("Sale");
		customerInfo.setAge(21);
		return customerInfo;
	}
}
