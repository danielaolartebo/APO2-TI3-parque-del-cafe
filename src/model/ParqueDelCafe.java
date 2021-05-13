package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class ParqueDelCafe implements Serializable{
		
		private static final long serialVersionUID = 1;
		private List<CustomerAccount> customers;
		
		public ParqueDelCafe() {
			customers = new ArrayList<>();
		}
		
		public void addCustomer(String userName, String password, String name, String gender, String age) {
			customers.add(new CustomerAccount(userName, password, name, gender, age));
			
		}
		
		public List<CustomerAccount> getCustomers(){
			return customers; 
		}
		
		public boolean validateCustomer(String userName, String password) {
			boolean validate=false;
			for(int i=0; i<customers.size() && !validate;i++) {
				CustomerAccount customer = customers.get(i);
				if(customer.getUserName().equals(customer.getUserName()) && customer.getPassword().equals(customer.getPassword())) {
					validate=true;
				}
			}
			return validate;
		}
		
		public CustomerAccount findCustomer(String userName){
			CustomerAccount tempName=null;
			for (int i=0; i < customers.size();i++) {
				if(customers.get(i).getUserName().equals(userName)) {
					tempName = customers.get(i);
				}
			}
			return tempName;
		}
}
