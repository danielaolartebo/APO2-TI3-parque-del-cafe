package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.impl.ps.CachingRoundRectRep;

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
		rollerCoaster.setNextGame(karts);
		
		wheel = new Game("Rueda");
		karts.setNextGame(wheel);
		
		carousel = new Game("Carusel");
		wheel.setNextGame(carousel);
		
		krater = new Game("Krater");
		carousel.setNextGame(krater);
		
		crashingBoats = new Game("Botes Chocones");
		krater.setNextGame(crashingBoats);
		
		fast = new Game("Rapidos");
		crashingBoats.setNextGame(fast);
		
		yipe = new Game("Yipe");
		fast.setNextGame(crashingBoats);
		
		mountain = new Game("Monta�a");
		yipe.setNextGame(mountain);
		
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
		customerAsVisitor();
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
	public Visitor customerAsVisitor() {
		
		String name = customer.getName();
		String age = customer.getAge();
		String gender = customer.getGender();
		Visitor customerVisitor = new Visitor(name,age,gender);
		customer.setFirstVisitor(customerVisitor);
		return customerVisitor;
		
	}
	public ArrayList<Visitor> createVisitorList() {
		
		ArrayList<Visitor> visitorList = new ArrayList<Visitor>();
		
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
		
		planTotalPrice += newprice;
		
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
		
		getVisitor(name).setManyPlans(plan);
		
		
	}
	public void RemoveVisitor(String name) {
		
	
		
		Visitor previusVisitor = findNextVisitor(name, customer.getFirstVisitor());
		Visitor nextVisitor = getVisitor(name).getNextVisitor();
		Visitor toDelete = getVisitor(name);
		
		previusVisitor.setNextVisitor(nextVisitor);
		toDelete.setNextVisitor(null);
		
	}
	private Visitor findNextVisitor(String name, Visitor visitor) {
		
		if(visitor.getNextVisitor().getName().equals(name)) {
			
			return visitor;
			
		}else {
			return findNextVisitor(name, visitor.getNextVisitor());
		}
		
	}
	/*
	 Esto es muy provisional pero mientras sera el mismo que en el costructor
	 Como con los rapidos, se aceptan ideas UwU
	 1: Montana Rusa
	 2: karts
	 3: wheel
	 4: carousel
	 5: krater
	 6: botes chocones
	 7: rapidos
	 8: yipe
	 9:	montana
	 Tambien podria cambiarse tanto metodo addVisitantTo usando un switch con los mismos
	 numeros, luego me dicen, att: Esteban UmU
	 */
	public void moveVisitor(String name, int gameToMove) {
		
		Visitor toMove = getVisitor(name);
		if(toMove.getPlaying()==false) {
			
			switch(gameToMove) {
			
			case 1: addVisitorToRollerCoaster(toMove);
			break;
			
			case 2: addVisitorToKarts(toMove);
			break;
			
			case 3: addVisitorToWheel(toMove);
			break;
			
			case 4: addVisitorToCarousel(toMove);
			break;
			
			case 5: addVisitorToKrater(toMove);
			break;
			
			case 6: addVisitorToCrashingBoats(toMove);
			break;
			
			case 7: addVisitorToFast(toMove);
			break;
			
			case 8: addVisitorToYipe(toMove);
			break;
			
			case 9: addVisitorToMontana(toMove);
			break;
			}
		}
		
	}
	/*
	public Visitor findVisitorInGame(String name,Game game) {
		
		Visitor toReturn;
		
		
		return toReturn;
		}*/

	private void addVisitorToMontana(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToYipe(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToFast(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToCrashingBoats(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToKrater(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToCarousel(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToWheel(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToKarts(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}

	private void addVisitorToRollerCoaster(Visitor toMove) {
		// TODO Auto-generated method stub
		
	}
	}
