package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class ParqueDelCafe implements Serializable{
		
		private static final long serialVersionUID = 1;
		
		private int planTotalPrice;
		private List<CustomerAccount> customers;
		private List<Game> games;
		private List<FoodCourt> foods;
		private List<Parking> parkings;
		//Games
		private Game rollerCoaster;
		private Game karts;
		private Game wheel;
		private Game carousel;
		private Game krater;
		private Game crashingBoats;
		private Game fast;
		private Game yipe;
		private Game mountain;
		//Food court
		private FoodCourt heladerias;
		private FoodCourt subway;
		private FoodCourt parrilla;
		private FoodCourt guadual;
		//user
		private CustomerAccount customer;
		
		public ParqueDelCafe() {
			customers = new ArrayList<>();
			games = new ArrayList<>();
			foods = new ArrayList<>();
			parkings = new ArrayList<>();
			rollerCoaster = new Game("Monta�a Rusa");
			karts = new Game("Karts");
			wheel = new Game("Rueda");
			carousel = new Game("Carusel");
			krater = new Game("Krater");
			crashingBoats = new Game("Botes Chocones");
			fast = new Game("Rapidos");
			yipe = new Game("Yipe");
			mountain = new Game("Monta�a");
			heladerias = new FoodCourt("Heladerias del Parque");
			subway = new FoodCourt("Subway");
			parrilla = new FoodCourt("Parrilla del Parque");
			guadual = new FoodCourt("El Guadual");
			planTotalPrice = 0;
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
				if(customer.getUserName().equals(userName) && customer.getPassword().equals(password)) {
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
	public void setUser(String userName) {
		
		CustomerAccount tmp = findCustomer(userName);
		setCustomerAccount(tmp);
	}
	public void setCustomerAccount(CustomerAccount ca) {
		customer = ca;
	}
	public CustomerAccount getCurrentCustomer() {
		return customer;
	}
	public void addVisitorToUser(String name, String age, String sex) {
		
		Visitor tmp = new Visitor(name,age,sex);
		if(customer.getFirstVisitor()==null) {
			customer.setFirstVisitor(tmp);
		}else {
			addVisitor(customer.getFirstVisitor(),tmp);
		}
	}
	private void addVisitor(Visitor current, Visitor tmp) {
		
		if(current.getNextVisitor()==null) {
			current.setNextVisitor(tmp);
		}else {
			addVisitor(current.getNextVisitor(),tmp);
		}
		
	}
	public ArrayList<Visitor> createVisitorList() {
		
		ArrayList<Visitor> visitorList = new ArrayList<Visitor>();
		String name = customer.getName();
		String age = customer.getAge();
		String gender = customer.getGender();
		Visitor customerVisitor = new Visitor(name,age,gender);
		visitorList.add(customerVisitor);
		if(customer.getFirstVisitor()!=null) {
			visitorList.add(customer.getFirstVisitor());
			Visitor tmp = customer.getFirstVisitor().getNextVisitor();
			while(tmp!=null){
				visitorList.add(tmp);
				tmp = tmp.getNextVisitor();	
			}
		}
		return visitorList;
	}
	public ArrayList<String> namesList(){
		
		ArrayList<String> visitors = new ArrayList<String>();
		ArrayList<Visitor> visitorsComplete = createVisitorList();
		for(int i=0;i< visitorsComplete.size();i++) {
			
			String name = visitorsComplete.get(i).getName();
			visitors.add(name);
			
		}
		
		
		
		return visitors;
	}
	public int calculateTotalprice(int quantity, int price) {
		
		int newprice = quantity*price;
		System.out.println(newprice);
		planTotalPrice += newprice;
		System.out.println(planTotalPrice);
		return planTotalPrice;
	}
	public int getPlanTotalPrice() {
		return planTotalPrice;
	}
	public Visitor getVisitor(String name) {
		
		ArrayList<Visitor> visitors = createVisitorList();
		Visitor visitorToReturn = null;
		for(int i=0; i < createVisitorList().size();i++) {
			
			if(visitors.get(i).getName().equals(name)) {
				visitorToReturn = visitors.get(i);
			}
			
			
		}
		return visitorToReturn;
	}	
	
	public void addPlanToVisitor(String name, String plan) {
		
		Visitor visitorToAddPlan = getVisitor(name);
		visitorToAddPlan.setManyPlans(plan);
		
		
	}
}
