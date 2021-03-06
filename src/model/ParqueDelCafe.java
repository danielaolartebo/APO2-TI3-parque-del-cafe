package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exceptions.YoungerException;


public class ParqueDelCafe implements Serializable{
		
	private static final long serialVersionUID = 1;
	public final static String USERS_SAVE_PATH_FILE = "data/users.parqueDelCafe";	
	
	private int planTotalPrice;
	private List<CustomerAccount> customers;

	private Parking parking;

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
	private Game cumbre;
	//Food court
	//Hice el cambio de FoodCourt a Game debido a que poseen los mismos atributos
	private Game heladerias;
	private Game subway;
	private Game parrilla;
	private Game guadual;
	//user
	private CustomerAccount customer;
	private Visitor root;
	private Game gameRoot;
	
	public ParqueDelCafe() {
		customers = new ArrayList<>();

		parkings = new ArrayList<>();

		rollerCoaster = new Game("Monta�a Rusa",1);
		
		karts = new Game("Karts",2);
		rollerCoaster.setNextGame(karts);
		
		wheel = new Game("Rueda",3);
		karts.setNextGame(wheel);
		
		carousel = new Game("Carusel",4);
		wheel.setNextGame(carousel);
		
		krater = new Game("Krater",5);
		carousel.setNextGame(krater);
		
		crashingBoats = new Game("Botes Chocones",6);
		krater.setNextGame(crashingBoats);
		
		fast = new Game("Rapidos",7);
		crashingBoats.setNextGame(fast);
		
		yipe = new Game("Yipe",8);
		fast.setNextGame(yipe);
		
		mountain = new Game("Monta�a Acuatica",9);
		yipe.setNextGame(mountain);
		
		cumbre = new Game("Torre Cumbre",10);
		mountain.setNextGame(cumbre);
		
		heladerias = new Game("Heladerias del Parque",11);
		cumbre.setNextGame(heladerias);
		
		subway = new Game("Subway",12);
		heladerias.setNextGame(subway);
		
		parrilla = new Game("Parrilla del Parque",13);
		subway.setNextGame(parrilla);
		
		guadual = new Game("El Guadual",14);
		parrilla.setNextGame(guadual);
		
		parking = new Parking(-7,350);
		
		planTotalPrice = 0;
		root = null;
		gameRoot = null;
	}
		

	public void addCustomer(String userName, String password, String name, String gender, int age) throws YoungerException, FileNotFoundException, IOException {
		
		if(age>=16) {
		customers.add(new CustomerAccount(userName, password, name, gender, age));
		saveData();	
		}else {
			throw new YoungerException(age);
		}
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
	public void addVisitorToUser(String name, int  age, String sex) throws  YoungerException {
		
		if(age>=3) {
		Visitor tmp = new Visitor(name,age,sex);
			if(customer.getFirstVisitor()==null) {
				customer.setFirstVisitor(tmp);
			}else {
				addVisitor(customer.getFirstVisitor(),tmp);
			}
		}else {
			throw new YoungerException(age);
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
		int age = customer.getAge();
		String gender = customer.getGender();
		Visitor customerVisitor = new Visitor(name,age,gender);
		customer.setFirstVisitor(customerVisitor);
		root = customerVisitor;
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
	public ArrayList<Game> createGamesList(){
		
		ArrayList<Game> gameList = new ArrayList<Game>();
		
			gameList.add(rollerCoaster);
			
			Game tmp = rollerCoaster.getnextGame();
			
			gameList.add(tmp);
			tmp = tmp.getnextGame();
			System.out.println(tmp.getName());
			while(tmp!=null) {
				
				gameList.add(tmp);
				tmp = tmp.getnextGame();
			}
			/*
			while(tmp!=null) {
				System.out.println(tmp.getName());
				gameList.add(tmp);
				Game tmp2 = tmp;
				tmp = tmp2.getnextGame();
			}*/
		return gameList;
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
	
	public void addPlanToVisitor(String name, String plan,double toPaid) {
		
		getVisitor(name).setManyPlans(plan);
		getVisitor(name).setToPay(toPaid+getVisitor(name).getToPay());
		addToTheTree(getVisitor(name));
	}
	public void addToTheTree(Visitor visitor) {
		
		if(root==null) {
			root = visitor;
		}else {
			
			addToTheTree(root,visitor);
		}
		
	}
	private void addToTheTree(Visitor visitor,Visitor visitor2 ) {
		
		if(visitor.getToPay()<visitor2.getToPay()) {
			if(visitor.getPaidMore()==null) {
			visitor.setPaidMore(visitor2);
			} else {
				addToTheTree(visitor.getPaidMore(), visitor2);
				
			} 
		} else if(visitor.getToPay()>=visitor2.getToPay()){
			if(visitor.getPaidLess()==null) {
				visitor.setPaidLess(visitor2);
			} else {
				addToTheTree(visitor.getPaidLess(), visitor2);
			}
		}
	}
	public void occupancyTree(Game game) {
		
		if(gameRoot==null) {
			gameRoot = game;
		}else {
			
			occupancyTree(gameRoot,game);
		}
	}
	private void occupancyTree(Game game, Game game2) {
		
		if(game.getOccupancy()<game2.getOccupancy()) {
			if(game.getWithMoreOccupancy()==null) {
			game.setWithMoreOccupancy(game2);
			} else {
				occupancyTree(game.getWithMoreOccupancy(), game2);
				
			} 
		} else if(game.getOccupancy()>=game2.getOccupancy()){
			if(game.getWithLessOccupancy()==null) {
				game.setWithLessOccupancy(game2);
			} else {
				occupancyTree(game.getWithLessOccupancy(), game2);
			}
		}
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
	 1: Montana Rusa - - -
	 2: karts - - -
	 3: wheel - - -
	 4: carousel - - -
	 5: krater - - -
	 6: botes chocones - - -
	 7: rapidos - - - 
	 8: yipe - - -
	 9:	montana acuatica - - -
	 10: Cumbre - - -
	 11: heladeria -
	 12: subway - 
	 13: parrilla -
	 14: guadual -
	 Tambien podria cambiarse tanto metodo addVisitantTo usando un switch con los mismos
	 numeros, luego me dicen, att: Esteban UmU
	 */
	/*
	public void moveVisitor(String name, int gameToMove) {
		
		Visitor toMove = getVisitor(name);
		System.out.println(toMove.getPlaying());
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
			case 10: addVisitorToCumbre(toMove);
			break;
			}
		}else {
			
			Game gameIn = findGame(toMove, rollerCoaster);
			Visitor previusVisitorInGame = null;
			if(gameIn.equals(rollerCoaster)) {
				if(rollerCoaster.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, rollerCoaster.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(crashingBoats)) {
				if(crashingBoats.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, crashingBoats.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(cumbre)) {
				if(cumbre.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, cumbre.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(fast)) {
				if(fast.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, fast.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(karts)) {
				if(karts.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, karts.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(krater)) {
				if(krater.getVisitors().getNextVisitor()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, krater.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(mountain)) {
				if(mountain.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, mountain.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(wheel)) {
				if(wheel.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, wheel.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else if(gameIn.equals(yipe)){
				if(yipe.getVisitors().getNextVisitorInGame()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, yipe.getVisitors());
				}else {
					previusVisitorInGame = null;
				}
			}else {
				if(carousel.getVisitors()!=null) {
				previusVisitorInGame = findNextVisitorInGame(name, carousel.getVisitors());
				}
			}
			
			Visitor nextVisitorInGame = toMove.getNextVisitorInGame();
			if(previusVisitorInGame==null) {
				
			}else {
			previusVisitorInGame.setNextVisitorInGame(nextVisitorInGame);
			}
			toMove.setNextVisitorInGame(null);
			toMove.setPlaying(false);
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
			case 10: addVisitorToCumbre(toMove);
			break;			
			}
		}
		
	}*/
	public void moveVisitor(String name, int gameToMove) {
		
		Visitor toMove = getVisitor(name);
		System.out.println(toMove.getPlaying());
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
			
			case 10: addVisitorToCumbre(toMove);
			break;
			
			case 11: addVisitorToIceCreamParlour(toMove);
			break;
			
			case 12: addVisitorToSubway(toMove);
			break;
			
			case 13: addVisitorToParillaDelParque(toMove);
			break;
			
			case 14: addVisitorToGuadal(toMove);
			break;
			
			}
		}else {
			deleteVisitorInGame(name);
			moveVisitor(name, gameToMove);
			/*
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
			case 10: addVisitorToCumbre(toMove);
			break;			
			}*/
		}
		
	}
	
	public Game findGame(Visitor toMove,Game current) {
		
		if(toMove.getInGame().equals(current)) {
			return current;
		}else {
			return findGame(toMove, current.getnextGame());
		}
	
	}

	public void addVisitorToMontana(Visitor toMove) {
		
		if(mountain.getVisitors()==null) {
			
			 mountain.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(mountain);
			mountain.setOccupancy(mountain.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToMountain(mountain.getVisitors(),toMove);
		}
	}
	private void addVisitorToMountain(Visitor current,Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(mountain);
			mountain.setOccupancy(mountain.getOccupancy()+1);
		}else {
			addVisitorToMountain(current.getNextVisitorInGame(), toMove);
		}
	}
	private void addVisitorToCumbre(Visitor toMove) {
		
		if(cumbre.getVisitors()==null) {
			
			cumbre.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(cumbre);
			cumbre.setOccupancy(cumbre.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToCumbre(cumbre.getVisitors(),toMove);
		}
	}
	private void addVisitorToCumbre(Visitor current, Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(cumbre);
			cumbre.setOccupancy(cumbre.getOccupancy()+1);
		}else {
			addVisitorToCumbre(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorsInCumbre(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(cumbre.getVisitors()!=null) {
			currentVisitors.add(cumbre.getVisitors());
			Visitor tmp = cumbre.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
		}
	
		
		return currentVisitors; 
	
	}
	public ArrayList<Visitor> createVisitorsInMontana(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(mountain.getVisitors()!=null) {
			currentVisitors.add(mountain.getVisitors());
			Visitor tmp = mountain.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
		}
	
		
		return currentVisitors; 
	}
	private void addVisitorToRoallerCoaster(Visitor current,Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(rollerCoaster);
			rollerCoaster.setOccupancy(rollerCoaster.getOccupancy()+1);
		}else {
			addVisitorToRoallerCoaster(current.getNextVisitorInGame(), toMove);
		}
		
	}
	public ArrayList<Visitor> createVisitorsInRollerCoaster(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(rollerCoaster.getVisitors()!=null) {
			currentVisitors.add(rollerCoaster.getVisitors());
			Visitor tmp = rollerCoaster.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
		}
	
		
		return currentVisitors; 
	}
	public ArrayList<Visitor> createVisitorInKarts(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(karts.getVisitors()!=null) {
			currentVisitors.add(karts.getVisitors());
			Visitor tmp = karts.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
		}
	
		
		return currentVisitors; 
	}
	private void addVisitorToYipe(Visitor toMove) {
		if(yipe.getVisitors()==null) {
			
			 yipe.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(yipe);
			yipe.setOccupancy(yipe.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToYipe(yipe.getVisitors(),toMove);
		}
		
	}
	private void addVisitorToYipe(Visitor current, Visitor toMove) {
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(yipe);
			yipe.setOccupancy(yipe.getOccupancy()+1);
		}else {
			addVisitorToYipe(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorsInYipe(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(yipe.getVisitors()!=null) {
			currentVisitors.add(yipe.getVisitors());
			Visitor tmp = yipe.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	private void addVisitorToFast(Visitor toMove) {
		
		if(fast.getVisitors()==null) {
	
			fast.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(fast);
			int people = fast.getOccupancy();
			fast.setOccupancy(people+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToFast(fast.getVisitors(),toMove);
		}
		
	}
	private void addVisitorToFast(Visitor current, Visitor toMove){
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(fast);
			int people = fast.getOccupancy();
			fast.setOccupancy(people+1);
		}else {
			addVisitorToFast(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorInFast(){
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(fast.getVisitors()!=null) {
			currentVisitors.add(fast.getVisitors());
			Visitor tmp = fast.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	public ArrayList<Visitor> createVisitorInIceCreamParlour(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(heladerias.getVisitors()!=null) {
			currentVisitors.add(heladerias.getVisitors());
			Visitor tmp = heladerias.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	public ArrayList<Visitor> createVisitorInParilla(){
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(parrilla.getVisitors()!=null) {
			currentVisitors.add(parrilla.getVisitors());
			Visitor tmp = parrilla.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	public ArrayList<Visitor> createVisitorInSubway(){
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(subway.getVisitors()!=null) {
			currentVisitors.add(subway.getVisitors());
			Visitor tmp = subway.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	public ArrayList<Visitor> createVisitorInGuadual(){
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(guadual.getVisitors()!=null) {
			currentVisitors.add(guadual.getVisitors());
			Visitor tmp = guadual.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	private void addVisitorToCrashingBoats(Visitor toMove) {
		if(crashingBoats.getVisitors()==null) {
			
			crashingBoats.setVisitors(toMove);
			toMove.setPlaying(true);
			System.out.println("Esta entrando parte 1.5");
			toMove.setInGame(crashingBoats);
			crashingBoats.setOccupancy(crashingBoats.getOccupancy()+1);
		}else {
			addVisitorToCrashingBoats(crashingBoats.getVisitors(),toMove);
		}
		
	}
	private void addVisitorToCrashingBoats(Visitor current, Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(crashingBoats);
			crashingBoats.setOccupancy(crashingBoats.getOccupancy()+1);
		}else {
			addVisitorToCrashingBoats(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorsInCrashingBoats(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(crashingBoats.getVisitors()!=null) {
			currentVisitors.add(crashingBoats.getVisitors());
			Visitor tmp = crashingBoats.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}

	private void addVisitorToKrater(Visitor toMove) {
		
		if(krater.getVisitors()==null) {
			
			 krater.setVisitors(toMove);
			toMove.setPlaying(true);
			System.out.println("Esta entrando parte 1.5");
			toMove.setInGame(krater);
			krater.setOccupancy(krater.getOccupancy()+1);
		}else {
			addVisitorToKrater(krater.getVisitors(),toMove);
		}
	}
	private void addVisitorToKrater(Visitor current,Visitor toMove) {

		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(krater);
			krater.setOccupancy(krater.getOccupancy()+1);
		}else {
			addVisitorToKrater(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorInKrater(){
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(krater.getVisitors()!=null) {
			currentVisitors.add(krater.getVisitors());
			Visitor tmp = krater.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	private void addVisitorToCarousel(Visitor toMove) {
		if(carousel.getVisitors()==null) {
			
			 carousel.setVisitors(toMove);
			toMove.setPlaying(true);
			System.out.println("Esta entrando parte 1.5");
			toMove.setInGame(carousel);
			carousel.setOccupancy(carousel.getOccupancy()+1);
		}else {
			addVisitorToCarousel(carousel.getVisitors(),toMove);
		}
	
	}
	private void addVisitorToCarousel(Visitor current,Visitor toMove) {
	
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(carousel);
			carousel.setOccupancy(carousel.getOccupancy()+1);
		}else {
			addVisitorToCarousel(current.getNextVisitorInGame(), toMove);
		}
	
	}
	public ArrayList<Visitor> createVisitorsInCarousel(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(wheel.getVisitors()!=null) {
			currentVisitors.add(carousel.getVisitors());
			Visitor tmp = carousel.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	private void addVisitorToWheel(Visitor toMove) {
		
		if(wheel.getVisitors()==null) {
			
			wheel.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(wheel);
			wheel.setOccupancy(wheel.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToWheel(wheel.getVisitors(),toMove);
		}
	}
	private void addVisitorToWheel(Visitor current,Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(wheel);
			wheel.setOccupancy(wheel.getOccupancy()+1);
		}else {
			addVisitorToWheel(current.getNextVisitorInGame(), toMove);
		}
	}
	

	private void addVisitorToKarts(Visitor toMove) {
		
		if(karts.getVisitors()==null) {
			
			karts.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(karts);
			System.out.println("Esta entrando parte 1.5");
			karts.setOccupancy(karts.getOccupancy()+1);
		}else {
			addVisitorToKarts(karts.getVisitors(),toMove);
		}
	}
		
	

	private void addVisitorToKarts(Visitor current, Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(karts);
			karts.setOccupancy(karts.getOccupancy()+1);
		}else {
			addVisitorToKarts(current.getNextVisitorInGame(), toMove);
		}
	}
	public ArrayList<Visitor> createVisitorsInWheel(){
		
		ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
		
		if(wheel.getVisitors()!=null) {
			currentVisitors.add(wheel.getVisitors());
			Visitor tmp = wheel.getVisitors().getNextVisitorInGame();
			while(tmp!=null){
				currentVisitors.add(tmp);
				tmp = tmp.getNextVisitorInGame();
				System.out.println("Esta entrando parte 2");
			}
	
		}
		return currentVisitors;
	}
	private void addVisitorToRollerCoaster(Visitor toMove) {
	
		if(rollerCoaster.getVisitors()==null) {
			
			rollerCoaster.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(rollerCoaster);
			System.out.println("Esta entrando parte 1.5");
			rollerCoaster.setOccupancy(rollerCoaster.getOccupancy()+1);
		}else {
			addVisitorToRoallerCoaster(rollerCoaster.getVisitors(),toMove);
		}
	}
	public void addVisitorToIceCreamParlour(Visitor toMove) {
		
		if(heladerias.getVisitors()==null) {
			
			heladerias.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(heladerias);
			heladerias.setOccupancy(heladerias.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToIceCreamParlour(heladerias.getVisitors(),toMove);
		}
	}
	public void addVisitorToSubway(Visitor toMove) {
		
		if(subway.getVisitors()==null) {
			
			subway.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(subway);
			subway.setOccupancy(subway.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToSubway(subway.getVisitors(),toMove);
		}
	}
	public void addVisitorToGuadal(Visitor toMove) {
		if(guadual.getVisitors()==null) {
			
			guadual.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(guadual);
			guadual.setOccupancy(guadual.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToGuadual(guadual.getVisitors(),toMove);
		}
	}
	public void addVisitorToParillaDelParque(Visitor toMove) {
		if(parrilla.getVisitors()==null) {
			
			parrilla.setVisitors(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(parrilla);
			parrilla.setOccupancy(parrilla.getOccupancy()+1);
			System.out.println("Esta entrando parte 1.5");
		}else {
			addVisitorToParillaDelParque(parrilla.getVisitors(),toMove);
		}
	}
	private void addVisitorToIceCreamParlour(Visitor current, Visitor toMove) {
		
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(heladerias);
			heladerias.setOccupancy(heladerias.getOccupancy()+1);
		}else {
			addVisitorToIceCreamParlour(current.getNextVisitorInGame(), toMove);
		}
	}
	private void addVisitorToSubway(Visitor current, Visitor toMove) {
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(subway);
			subway.setOccupancy(subway.getOccupancy()+1);
		}else {
			addVisitorToSubway(current.getNextVisitorInGame(), toMove);
		}
	}
	private void addVisitorToGuadual(Visitor current, Visitor toMove) {
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(guadual);
			guadual.setOccupancy(guadual.getOccupancy()+1);
		}else {
			addVisitorToGuadual(current.getNextVisitorInGame(), toMove);
		}
	}
	private void addVisitorToParillaDelParque(Visitor current, Visitor toMove) {
		if(current.getNextVisitorInGame()==null) {
			current.setNextVisitorInGame(toMove);
			toMove.setPlaying(true);
			toMove.setInGame(parrilla);
			parrilla.setOccupancy(parrilla.getOccupancy()+1);
		}else {
			addVisitorToParillaDelParque(current.getNextVisitorInGame(), toMove);
		}
	}
	public Visitor findNextVisitorInGame(String name, Game game) {
		
		Visitor toFind = getVisitor(name);
		if(toFind.equals(game.getVisitors())) {
			return null;
		}else {
			return findNextVisitorInGame(name, game.getVisitors());
		}	
	}
	
	private Visitor findNextVisitorInGame(String name, Visitor visitor) {
		
		if(visitor.getNextVisitorInGame().getName().equals(name)) {
			
			return visitor;
			
		}else {
			return findNextVisitorInGame(name, visitor.getNextVisitorInGame());
		}
		
	}
	public void deleteVisitorInGame(String name) {
		
		Game gameToSearch = findGame(getVisitor(name), rollerCoaster);
		Visitor toDelete = getVisitor(name);
		Visitor findPreVisitor = findNextVisitorInGame(name, gameToSearch);
		Visitor nextVisitor = getVisitor(name).getNextVisitorInGame();
		if(findPreVisitor == null) {
		
			gameToSearch.setVisitors(nextVisitor);
			toDelete.setNextVisitorInGame(null);
			toDelete.setPlaying(false);
			}else{
			findPreVisitor.setNextVisitorInGame(nextVisitor);
			toDelete.setNextVisitorInGame(null);
			toDelete.setPlaying(false);
		}
		gameToSearch.setOccupancy(gameToSearch.getOccupancy()-1);
	}
	public void takeOutFromGame() {
		
		ArrayList<Visitor> visitors = createVisitorList();
		int size = visitors.size();
		int first = 0;
		int random = (int)((Math.random()*(size-first))+first);
		System.out.println(random);
		Visitor visitorInPosition = visitors.get(random);
		if(visitorInPosition.getInGame()==null) {

		}
		
		String name = visitorInPosition.getName();
		System.out.println(name);
		deleteVisitorInGame(name);
		
	}
	public int countAmountOfGames() {
		
		int games = 0;
		
		games = countAmountOfGames(games, rollerCoaster);
		
		
		return games;
	}
	private int countAmountOfGames(int current, Game currentGame) {
		
		if(currentGame != null) {
			
			current+=1;
			current = countAmountOfGames(current,currentGame.getnextGame());
		}
		return current;
	}
	public Game findGameinPostion(int pos) {
			
			
			int found = -1;
			
			int i = 0;
				
			ArrayList<Game> games = createGamesList();
			
			int j =  games.size()-1;
			
			int m = 0;
			
			
			
			while(found<0 && i<=j) {
			
				m = (j+i)/2;	
				
				int pos2 = games.get(m).getPosition();
				
				if(pos==pos2) {
					
					found = 1;
					
				}else if(pos>pos2){
					
					i = m+1;
					
				}else if((pos2)>pos){
					
					j = m-1;
					
				}			
			}		
			
			return games.get(m);	
	}
	public void addPeopleToGame() {
		
		LocalTime current = java.time.LocalTime.now();
		LocalTime toCompare = LocalTime.of(12,0,0,0);
		LocalTime toCompare2 = LocalTime.of(15,0,0,0);
		LocalTime toCompare3 = LocalTime.of(18, 0,0,0);

		int totalGames = countAmountOfGames();
		int resultOfToCompare = current.compareTo(toCompare);
		int resultOfToCompare2 = current.compareTo(toCompare2);
		int resultOfToCompare3 = current.compareTo(toCompare3);
		int gameToAdd = (int)((Math.random()*(totalGames-1))+1);
		System.out.println(gameToAdd);
		Game game = findGameinPostion(gameToAdd);
		if(resultOfToCompare <=0) {
			
			int amountToAdd = (int)((Math.random()*(10-2))+2);
			game.setOccupancy(game.getOccupancy()+amountToAdd);
		}else if(resultOfToCompare>=1 && resultOfToCompare2<=0) {
			
			int amountToAdd = (int)((Math.random()*(18-4))+4);
			game.setOccupancy(game.getOccupancy()+amountToAdd);
			
		}else if(resultOfToCompare2>=1 && resultOfToCompare3<=0) {
			
			int amountToAdd = (int)((Math.random()*(13-6))+6);
			game.setOccupancy(game.getOccupancy()+amountToAdd);
		}else {
			int amountToAdd = (int)((Math.random()*(5-0))+0);
			game.setOccupancy(game.getOccupancy()+amountToAdd);
		}
	}
	
public void removePeopleOfGame() {
		
		LocalTime current = java.time.LocalTime.now();
		LocalTime toCompare = LocalTime.of(12,0,0,0);
		LocalTime toCompare2 = LocalTime.of(15,0,0,0);
		LocalTime toCompare3 = LocalTime.of(18, 0,0,0);

		int totalGames = countAmountOfGames();
		int resultOfToCompare = current.compareTo(toCompare);
		int resultOfToCompare2 = current.compareTo(toCompare2);
		int resultOfToCompare3 = current.compareTo(toCompare3);
		int gameToAdd = (int)((Math.random()*(totalGames-1))+1);
		System.out.println(gameToAdd);
		Game game = findGameinPostion(gameToAdd);

		
		if(resultOfToCompare <=0) {
			
			int amountToAdd = (int)((Math.random()*(10-2))+2);
			if(game.getOccupancy()-amountToAdd <0) {
				removePeopleOfGame();
			}else {
				game.setOccupancy(game.getOccupancy()-amountToAdd);
			}
		}else if(resultOfToCompare>=1 && resultOfToCompare2<=0) {
			
			int amountToAdd = (int)((Math.random()*(18-4))+4);
			if(game.getOccupancy()-amountToAdd <0) {
				removePeopleOfGame();
			}else {
				game.setOccupancy(game.getOccupancy()-amountToAdd);
			}
		}else if(resultOfToCompare2>=1 && resultOfToCompare3<=0) {
			
			int amountToAdd = (int)((Math.random()*(13-6))+6);
			
			if(game.getOccupancy()-amountToAdd <0) {
				removePeopleOfGame();
			}else {
				game.setOccupancy(game.getOccupancy()-amountToAdd);
			}
		}else {
			int amountToAdd = (int)((Math.random()*(5-0))+0);
			if(game.getOccupancy()-amountToAdd <0) {
				removePeopleOfGame();
			}else {
				game.setOccupancy(game.getOccupancy()-amountToAdd);
			}
		}
		
	}
	
	public ArrayList<Visitor> visitorsSortedById(){
		
		ArrayList<Visitor> visitorsToSort = createVisitorList();
		
		for(int i=1; i < visitorsToSort.size();i++) {
			
			Visitor visitorToUse = visitorsToSort.get(i);
			boolean ended = false;
			
			for(int j=i; j > 0 && !ended;j--) {
				
				Visitor current = visitorsToSort.get(j-1);
				
				if(current.compareVisitantsbyId(visitorToUse)>0) {
					
					visitorsToSort.set(j, current);
					visitorsToSort.set(j-1, visitorToUse);
				}else {
					ended = true;
				}
			}
		}
		
		return visitorsToSort;
	}
	public String findVisitorBinary(String name) {
		
		
		int found = -1;
		
		int i = 0;
			
		ArrayList<Visitor> visitors = visitorsSortedById();
		
		int j =  visitors.size()-1;
		
		int m = 0;
		
		Visitor getVisitor = getVisitor(name);
		
		long toFind = getVisitor.getCode();
		
		
		while(found<0 && i<=j) {
		
			m = (j+i)/2;	
			
			long current = visitors.get(m).getCode();
			
			if(toFind==current) {
				
				found = 1;
				
			}else if(toFind>current){
				
				i = m+1;
				
			}else if((current)>toFind){
				
				j = m-1;
				
			}			
		}
		String toReturn = "";
		if(visitors.get(m).getInGame().getName()==null) {
			toReturn = "Descansando";
		}else {
			toReturn = visitors.get(m).getInGame().getName();	
		}		
		
		return toReturn;
		
	}
	public ArrayList<Visitor> sortingVisitorsByNameAndGender(){
		
		ArrayList<Visitor> visitors = createVisitorList();
		
		Collections.sort(visitors);
		
		return visitors;
		
	}


	public Parking getParking() {
		return parking;
	}
	public ArrayList<Game> sortGamesByOccupancyAndName(){
		
		ArrayList<Game> games = createGamesList();
		Comparator<Game> occupancyAndNamesComparator = new GamesVisitorsNamesComparator();
		Collections.sort(games,occupancyAndNamesComparator);
		
		return games;
		
	}
	
	public void saveData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream ooo = new ObjectOutputStream(new FileOutputStream(USERS_SAVE_PATH_FILE));
		
		ooo.writeObject(customers);
		ooo.close();
	}
	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File f = new File(USERS_SAVE_PATH_FILE);
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_SAVE_PATH_FILE));
			customers = (List<CustomerAccount>)ois.readObject();
			ois.close();
		}else {
			
		}
		
	}

	public List<Parking> getParkings() {
		return parkings;
	}

	public Game getRollerCoaster() {
		return rollerCoaster;
	}

	public Game getKarts() {
		return karts;
	}

	public Game getWheel() {
		return wheel;
	}

	public Game getCarousel() {
		return carousel;
	}

	public Game getKrater() {
		return krater;
	}

	public Game getCrashingBoats() {
		return crashingBoats;
	}

	public Game getFast() {
		return fast;
	}

	public Game getYipe() {
		return yipe;
	}

	public Game getMountain() {
		return mountain;
	}

	public Game getCumbre() {
		return cumbre;
	}

	public Game getHeladerias() {
		return heladerias;
	}

	public Game getSubway() {
		return subway;
	}

	public Game getParrilla() {
		return parrilla;
	}

	public Game getGuadual() {
		return guadual;
	}

	public CustomerAccount getCustomer() {
		return customer;
	}
	public void createOccupancyTree() {
		
		ArrayList<Game> games = createGamesList();
		
		for(int i=0; i < games.size();i++) {
			
			occupancyTree(games.get(i));
			
		}
		
	}
}