package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class ParqueDelCafe implements Serializable{
		
		private static final long serialVersionUID = 1;
		private List<CustomerAccount> customers;
		private Game rollerCoaster;
		private Game karts;
		private Game wheel;
		private Game carousel;
		private Game krater;
		private Game crashingBoats;
		private Game fast; //Cualquier cambio en el nombre de este sera bienvenidos porque ni idea como traducir rapidos
		private Game yipe;
		private Game mountain;
		public ParqueDelCafe() {
			customers = new ArrayList<>();
			rollerCoaster = new Game("Montaña Rusa");
			karts = new Game("Karts");
			wheel = new Game("Rueda");
			carousel = new Game("Carusel");
			krater = new Game("Krater");
			crashingBoats = new Game("Botes Chocones");
			fast = new Game("Rapidos");
			yipe = new Game("Yipe");
			mountain = new Game("Montaña");
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
