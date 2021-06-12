package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import exceptions.PlanException;
import exceptions.YoungerException;

public class ParqueDelCafeTest {
	
	private ParqueDelCafe parque;
	
	public void setupScenary1() {
		
	}
	
	public void setupScenary2() {
		parque = new ParqueDelCafe();
	}
	
	public void setupScenary3() throws FileNotFoundException, YoungerException, IOException {
		parque = new ParqueDelCafe();
		
		parque.addCustomer("dob01", "1234", "Daniel", "Male",18);
		parque.addCustomer("Est2", "2222", "Esteban", "Male",20);
		parque.addCustomer("Soph12", "3333", "Sophie", "Female",30);
		
	}
	
	@Test
	public void testAdd_1() {
		setupScenary1();
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		assertNotNull(pdc.getCustomers());
		assertTrue(pdc.getCustomers().isEmpty());
		
	}
	
	@Test
	public void testAdd_2() throws FileNotFoundException, YoungerException, IOException {
		setupScenary2();
		
		String userName = "Dob01";
		String password = "1234";
		String name = "Daniel";
		String gender = "Male";
		int age = 18;
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		pdc.addCustomer(userName, password, name, gender, age);
		
		
		List<CustomerAccount> account = pdc.getCustomers();
		assertEquals(1, account.size());
		
		CustomerAccount cus = account.get(0);
		assertEquals(userName, cus.getUserName());
		assertEquals(password, cus.getPassword());
		assertEquals(name, cus.getName());
		assertEquals(gender, cus.getGender());
		assertEquals(age, cus.getAge());	
		
	}
	
	@Test
	public void testValidate_1() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Dob01";
		String password = "1234";
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		boolean validate = pdc.validateCustomer(userName, password);
		assertTrue(validate);	
		
	}
	
	@Test
	public void testValidate_2() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Est2";
		String password = "2222";
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		boolean validate = pdc.validateCustomer(userName, password);
		assertTrue(validate);	
		
	}
	
	@Test
	public void testValidate_3() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Soph12";
		String password = "3333";
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		boolean validate = pdc.validateCustomer(userName, password);
		assertTrue(validate);	
		
	}
	
	@Test
	public void testValidate_4() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Sebast1";
		String password = "4444";
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		boolean validate = pdc.validateCustomer(userName, password);
		assertFalse(validate);	
		
	}
	
	@Test
	public void testFindcustomer_1() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "dob01";
		
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		List<CustomerAccount> cus = pdc.getCustomers();
		CustomerAccount customer = cus.get(0);
		
		assertEquals(userName, customer.getUserName());
		
	}
	
	@Test
	public void testFindcustomer_2() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Est2";
		
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		List<CustomerAccount> cus = pdc.getCustomers();
		CustomerAccount customer = cus.get(1);
		
		assertEquals(userName, customer.getUserName());
		
	}
	
	@Test
	public void testFindcustomer_3() throws FileNotFoundException, YoungerException, IOException {
		setupScenary3();
		
		String userName = "Soph12";
		
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		List<CustomerAccount> cus = pdc.getCustomers();
		CustomerAccount customer = cus.get(2);
		
		assertEquals(userName, customer.getUserName());
		
	}
	
	
	public void testSetUser() throws FileNotFoundException, YoungerException, IOException {
		setupScenary2();
		
		String userName = "Dob01";
		String password = "1234";
		String name = "Daniel";
		String gender = "Male";
		int age = 18;
		
		ParqueDelCafe pdc = new ParqueDelCafe();
		
		pdc.addCustomer(userName, password, name, gender, age);
		
		List<CustomerAccount> cus = pdc.getCustomers();
		CustomerAccount customer = cus.get(0);
		assertEquals(userName, customer.getUserName());
		
	}
	
}
