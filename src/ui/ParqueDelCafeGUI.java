package ui;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import model.CustomerAccount;
import model.ParqueDelCafe;
import model.Visitor;

public class ParqueDelCafeGUI{

    @FXML
    private RadioButton txtMale;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton txtFemale;
    @FXML
    private RadioButton txtOther;
	@FXML
	private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private BorderPane mainPane;
    @FXML
    private BorderPane signInPane;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private BorderPane registerPane;
    @FXML
    private BorderPane menuPane;
    @FXML
    private BorderPane foodCourtPane;
    @FXML
    private BorderPane gamePane;
    @FXML
    private BorderPane userAccountPane;
    @FXML
    private BorderPane occupancyPane;
    @FXML
    private BorderPane parkingPane;
    @FXML
    private BorderPane planPane;
    @FXML
    private Label totalPricePlan;
    @FXML
    private BorderPane datePickerPane;
    @FXML
    private TextField txtParkingNumber;
    @FXML
    private BorderPane montanaRusaPane;
    @FXML
    private BorderPane montanaAcuaticaPane;
    @FXML
    private BorderPane yippePane;
    @FXML
    private BorderPane torreCumbrePane;
    @FXML
    private BorderPane botesChoconesPane;
    @FXML
    private BorderPane rapidosPane;
    @FXML
    private BorderPane ruedaPane;
    @FXML
    private BorderPane carruselPane;
    @FXML
    private BorderPane kraterPane;
    @FXML
    private BorderPane elGuadualPane;
    @FXML
    private BorderPane parrillaDelParquePane;
    @FXML
    private BorderPane subwayPane;
    @FXML
    private BorderPane heladeriasDelParquePane;
    @FXML
    private BorderPane chooserPane;
    @FXML
    private Label lbChooserUser;
    
    
    // PLAN MINI TABLE VIEW 
    
    @FXML
    private TableView<Visitor> tbPlanList;
    @FXML
    private TableColumn<Visitor, String> tcPlan;
    @FXML
    private TableColumn<Visitor, String> tcQuantity;
    @FXML
    private TextField quantityPlan;
    @FXML
    private ComboBox<String> planOptPlan;
    @FXML
    private ComboBox<String> planOptPlan1;
    
    @FXML
    private Label planCurrentUser;
    
    // DATE PICKER MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbDatePickerList;
    @FXML
    private TableColumn<Visitor, String> tcDateName;
    @FXML
    private TableColumn<Visitor, String> tcDateAge;
    @FXML
    private TableColumn<Visitor, String> tcDateGender;
    @FXML
    private TextField dateName;
    @FXML
    private DatePicker dateDate;
    @FXML
    private TextField dateAge;
    @FXML
    private ToggleGroup genderGroupDate;
    @FXML
    private Label lbDateUser;
          
    @FXML
    private RadioButton dateMale;
     

    @FXML
    private RadioButton dateFemale;

    @FXML
    private RadioButton dateOther;



    

    
    // OCCUPANCY TABLE VIEW
    
    @FXML
    private TableView<?> tbOccupancyList;
    @FXML
    private TableColumn<?, ?> tcRusaOccupancy;
    @FXML
    private TableColumn<?, ?> tcKartsOccupancy;
    @FXML
    private TableColumn<?, ?> tcAcuaticaOccupancy;
    @FXML
    private TableColumn<?, ?> tcYippeOccupancy;
    @FXML
    private TableColumn<?, ?> tcCumbreOccupancy;
    @FXML
    private TableColumn<?, ?> tcChoconesOccupancy;
    @FXML
    private TableColumn<?, ?> tcRapidosOccupancy;
    @FXML
    private TableColumn<?, ?> tcRuedaOccupancy;
    @FXML
    private TableColumn<?, ?> tcCarruselOccupancy;
    @FXML
    private TableColumn<?, ?> tcKraterOccupancy;
    @FXML
    private TableColumn<?, ?> tcGuadualOccupancy;
    @FXML
    private TableColumn<?, ?> tcParrillaOccupancy;
    @FXML
    private TableColumn<?, ?> tcSubwayOccupancy;
    @FXML
    private TableColumn<?, ?> tcHeladeriasOccupancy;
    @FXML
    private TableColumn<?, ?> tcParqueaderoOccupancy;
    @FXML
    private ComboBox<?> searchFriendOccupancy;
    @FXML
    private Label friendNameOccupancy;
    
    // USER ACCOUNT TABLE VIEW
    
    @FXML
    private TableView<CustomerAccount> tbUserAccountList;
    @FXML
    private TableColumn<CustomerAccount, String> tcUserAccount;
    @FXML
    private TableColumn<CustomerAccount, String> tcNameAccount;
    @FXML
    private TableColumn<CustomerAccount, String> tcAgeAccount;
    @FXML
    private TableColumn<CustomerAccount, String> tcGenderAccount;
/*    @FXML
    private TableColumn<CustomerAccount, String> tcPlanAccount;
    @FXML
    private TableColumn<CustomerAccount, Double> tcTotalPriceAccount;
    @FXML
    private TableColumn<CustomerAccount, String> tcBenefitsAccount;  */
    
    // MONTA�A RUSA MINI TABLE VIEW 
    
    @FXML
    private TableView<Visitor> tbMontanaRusaList;
    @FXML
    private TableColumn<Visitor, String> tcMontanaRusaName;
    @FXML
    private ComboBox<String> namesMontanaRusa;
    
    // KARTS MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbKartsList;
    @FXML
    private TableColumn<Visitor, String> tcKartsName;
    @FXML
    private ComboBox<String> namesKarts;
    
    // MONTA�A ACUATICA MINI TABLE VIEW

    @FXML
    private TableView<Visitor> tbMontanaAcuaticaList;
    @FXML
    private TableColumn<Visitor, String> tcMontanaAcuaticaName;
    @FXML
    private ComboBox<String> namesMontanaAcuatica;
    
    // YIPPE MINI TABLE VIEW

    @FXML
    private TableView<Visitor> tbYippeList;
    @FXML
    private TableColumn<Visitor, String> tcYippeName;
    @FXML
    private ComboBox<String> namesYippe;
    
    // TORRE CUMBRE MINI TABLE VIEW

    @FXML
    private TableView<Visitor> tbTorreCumbreList;
    @FXML
    private TableColumn<Visitor, String> tcTorreCumbreName;
    @FXML
    private ComboBox<String> namesTorreCumbre;
    
    // BOTES CHOCONES MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbBotesChoconesList;
    @FXML
    private TableColumn<Visitor, String> tcBotesChoconesName;
    @FXML
    private ComboBox<String> namesBotesChocones;
    
    // RAPIDOS MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbRapidosList;
    @FXML
    private TableColumn<Visitor, String> tcRapidosName;
    @FXML
    private ComboBox<String> namesRapidos;
    
    // RUEDA MINI TABLE VIEW

    @FXML
    private TableView<Visitor> tbRuedaList;
    @FXML
    private TableColumn<Visitor, String> tcRuedaName;
    @FXML
    private ComboBox<String> namesRueda;
    
    // CARRUSEL MINI TABLE VIEW

    @FXML
    private TableView<Visitor> tbCarruselList;
    @FXML
    private TableColumn<Visitor, String> tcCarruselName;
    @FXML
    private ComboBox<String> namesCarrusel;
    
    // KRATER MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbKraterList;
    @FXML
    private TableColumn<Visitor, String> tcKraterName;
    @FXML
    private ComboBox<String> namesKrater;
    
    // EL GUADUAL MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbGuadualList;
    @FXML
    private TableColumn<Visitor, String> tcGuadualName;
    @FXML
    private ComboBox<String> namesGuadual;
    
    // PARRILLA DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbParrillaList;
    @FXML
    private TableColumn<Visitor, String> tcParrillaName;
    @FXML
    private ComboBox<String> namesParrilla;
    
    // SUBWAY DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbSubwayList;
    @FXML
    private TableColumn<Visitor, String> tcSubwayName;
    @FXML
    private ComboBox<String> namesSubway;
    
    // HELADER�AS DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<Visitor> tbHeladeriasList;
    @FXML
    private TableColumn<Visitor, String> tcHeladeriasName;
    @FXML
    private ComboBox<String> namesHeladerias;
    
    
    
	private ParqueDelCafe parqueDelCafe;
	public final static String SAVE_PATH_FILE = "data.parqueDelCafe.csv";
	
	public ParqueDelCafeGUI(ParqueDelCafe pdc) {
		parqueDelCafe = pdc;
	}
	
	/*
	* ************************************************************************************* SERIALIZATION ***********************************************************************************************
	*/
	
	public void saveData() throws FileNotFoundException, IOException{
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
    	oos.writeObject(parqueDelCafe);
    	oos.close();
    }
    
    public void loadData() throws IOException, ClassNotFoundException{
    	File f = new File (SAVE_PATH_FILE);
    	if(f.exists()) {
    		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_FILE));
    		parqueDelCafe = (ParqueDelCafe)ois.readObject();
    		ois.close();
    	}
    }
    
    
    /*
     * ******************************************************************************* FIRST SCREEN (main-pane.fxml) *************************************************************************************
     */
    
    @FXML
    public void optContinue(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
    	fxmlLoader.setController(this);
    	Parent signInPane = (Parent) fxmlLoader.load();
    	mainPane.getChildren().setAll(signInPane);
    }
    
    @FXML
    public void showAbout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("El Parque Del Caf� ");
	    alert.setHeaderText("Creditos");
	    alert.setContentText("Daniela Olarte, Santiago Gutierrez y Esteban Mendoza \nAlgoritmos y Promagraci�n II \nUniversidad ICESI 2021");
	    alert.showAndWait();
    }
    
    /*
     ********************************************************************************* SECOND SCREEN SIGN IN (sign-in.fxml) **********************************************************************************
     */
    
    @FXML
    public void optLogIn(ActionEvent event) throws IOException {
    	String userName=txtUsername.getText();
     	String password=txtPassword.getText();
     	
     	if(parqueDelCafe.validateCustomer(userName, password)) {
     		parqueDelCafe.setUser(userName);
     		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chooser.fxml"));
        	fxmlLoader.setController(this);
        	Parent chooserPane = fxmlLoader.load();
        	mainPane.getChildren().setAll(chooserPane);
        	lbChooserUser.setText("User: "+ userName);
        	
     	}else if(!parqueDelCafe.validateCustomer(userName, password)) {
     		loginErrorAlert();
     	} 
    } 
   

    @FXML
    public void optSignUp(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(registerPane);
    }
   
    /*
     ********************************************************************************** THIRD SCREEN CREATE CUSTOMER ACCOUNT (register.fxml) *******************************************************************************************
     */
    
    @FXML
    public void sub15GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
    	fxmlLoader.setController(this);
    	Parent signInPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(signInPane);
    }
    
    @FXML
    public void optCreateAccount(ActionEvent event) throws IOException {
    	String userName=null;
    	if(!txtUsername.getText().equals("")) {
    		userName=txtUsername.getText();
    	}
    	String password="";
    	if(!txtPassword.getText().equals("")) {
    		password = txtPassword.getText();
    	}
    	String name=""; 
    	if(!txtName.getText().equals("")) {
    		name = txtName.getText();
    	}
    	RadioButton rbSelected = (RadioButton)genderGroup.getSelectedToggle();
    	String txtGender=rbSelected.getText();   
    	String age="";
    	if(!txtAge.getText().equals("")) {
    		age = txtAge.getText();
    	}

    	if(!(txtUsername.getText().equals("")) && !(txtPassword.getText().equals("")) && !(txtName.getText().equals("")) && !(txtAge.getText().equals("")))  {
        	parqueDelCafe.addCustomer(userName, password, name, txtGender, age);
        	accountCreatedAlert();
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
        	fxmlLoader.setController(this);
        	mainPane.getChildren().clear();
        	Parent signInPane = fxmlLoader.load();
        	mainPane.getChildren().setAll(signInPane);
        	}else if (userName.isEmpty() || password.isEmpty() || name.isEmpty() || txtGender=="" || age.isEmpty()) {
            	validationErrorAlert();
            }else{
        		customerValidationAlert();
        	}
       	} 
    
    /*
     ********************************************************************************************** SCREEN CHOOSER (chooser.fxml) ****************************************************************************************************
     */
    
    @FXML
    public void continueMenu(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }

    @FXML
    public void continueRegister(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("date-picker.fxml"));
    	fxmlLoader.setController(this);
    	Parent datePickerPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(datePickerPane);
    	lbDateUser.setText("Userio: "+parqueDelCafe.getCurrentCustomer().getUserName());	
    	initializeMiniVisitorTableView();
    }

    @FXML
    public void sub29GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
    	fxmlLoader.setController(this);
    	Parent signInPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(signInPane);
    }
    
    /*
     **********************************************************************************************FOURTH SCREEN DATE PICKER (date-picker.fxml) ****************************************************************************************************
     */
    
    @FXML
    public void dateAdd(ActionEvent event) throws ParseException {
    	
    	
    	LocalDate chooseDate = dateDate.getValue();
    	String day = Integer.toString(chooseDate.getDayOfMonth());
    	String month = Integer.toString(chooseDate.getMonthValue());
    	String year = Integer.toString(chooseDate.getYear());
    	String date = day+"/"+month+"/"+year;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse(date);
    
      
    	Date date2 = new Date();
        dateFormat.format(date2);
        if(date1.before(date2)){
        	
        	chooseDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        String chooseName = dateName.getText();
    	String chooseAge = dateAge.getText();
    	int choose = 0;
    	String sex = "";
    	if(dateMale.isSelected()) {
    		choose = 1;
    	}else if(dateFemale.isSelected()) {
    		choose = 2;
    	}else {
    		choose = 3;
    	}
    	switch(choose) {
    	
    	case 1: sex = "Male";
    	break;
    	case 2: sex = "Female";
    	break;
    	case 3: sex = "Other";
    	break;
    	}
    	
    	if((chooseName.equals(""))||(chooseAge.equals(""))){
    		
    		visitorRegisterAlert();
    		
    	}else {
    		if(((dateMale.isSelected()==false)&&(dateFemale.isSelected()==false)&&(dateOther.isSelected()==true)||(dateMale.isSelected()==false)&&(dateFemale.isSelected()==true)&&(dateOther.isSelected()==false))||(dateMale.isSelected()==true)&&(dateFemale.isSelected()==false)&&(dateOther.isSelected()==false)) {
    			parqueDelCafe.addVisitorToUser(chooseName, chooseAge, sex);	
    			tbDatePickerList.refresh();
    			initializeMiniVisitorTableView();
    		}else {
    			visitorRegisterAlert();
    		}
    	}
    	
    	
    }
    public void initializeMiniVisitorTableView() {
    	
    	ObservableList<Visitor> observableList;
    	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorList());
    	tbDatePickerList.setItems(observableList);
    	
    	tcDateName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
    	tcDateAge.setCellValueFactory(new PropertyValueFactory<Visitor,String>("age"));
    	tcDateGender.setCellValueFactory(new PropertyValueFactory<Visitor,String>("gender"));
    	
    }
   public void initializePlanComboBoxes() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   planOptPlan1.getItems().add(name);
		   
	   }
	   planOptPlan.getItems().addAll("Pasaporte Multiple","Almuerzo","Parqueadero");
	   
   }
   public void initializeMontanaRusaComboBox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesMontanaRusa.getItems().add(name);
		   System.out.println(name);
	   }
	   
   }
   public void initializeWaterMountainCombBox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesMontanaAcuatica.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeKartsComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesKarts.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeKraterComboBox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesKrater.getItems().add(name);
		   System.out.println(name);
	   }
   }
   
   public void initializeWheelComboBox() {
	
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesRueda.getItems().add(name);
		   System.out.println(name);
	   }
	   
   }
   public void initializeWaterMountainTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInMontana());
	   	tbMontanaAcuaticaList.setItems(observableList);
	   	
	   	tcMontanaAcuaticaName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbMontanaAcuaticaList.refresh();
   }
   public void initializeKraterTableView() {
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorInKrater());
	   	tbKraterList.setItems(observableList);
	   	
	   	tcKraterName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbKraterList.refresh();
   }
   public void initializeWheelTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInWheel());
	   	tbRuedaList.setItems(observableList);
	   	
	   	tcRuedaName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbRuedaList.refresh();
   }
   public void initializeKartsTableView() {
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorInKarts());
	   	tbKartsList.setItems(observableList);
	   	
	   	tcKartsName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbKartsList.refresh();
   }
   public void initializeCrashingBoatsComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesBotesChocones.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeCumbreComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesTorreCumbre.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeYipeComboBox() {
	
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesYippe.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeCumbreTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInCumbre());
	   	tbTorreCumbreList.setItems(observableList);
	   	
	   	tcTorreCumbreName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbTorreCumbreList.refresh();
   }
   public void initializeIceCreamComboBox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesHeladerias.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeGuadalComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesGuadual.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeSubwayComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesSubway.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeParrillaComboBox() {
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesParrilla.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeYipeTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInYipe());
	   	tbYippeList.setItems(observableList);
	   	
	   	tcYippeName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbYippeList.refresh();
   }
   public void initializeCarouselCombobox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesCarrusel.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeFastComboBox() {
	   
	   for(int i=0; i < parqueDelCafe.namesList().size();i++) {
		   String name = parqueDelCafe.namesList().get(i);
		   namesRapidos.getItems().add(name);
		   System.out.println(name);
	   }
   }
   public void initializeCarouselTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInCarousel());
	   	tbCarruselList.setItems(observableList);
	   	
	   	tcCarruselName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbCarruselList.refresh();
   }
   public void initializeFastTableView() {
	   
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorInFast());
	   	tbRapidosList.setItems(observableList);
	   	
	   	tcRapidosName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbRapidosList.refresh();
   }
   public void initializeCrashingBoatsTableView() {
	   
	   ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInCrashingBoats());
	   	tbBotesChoconesList.setItems(observableList);
	   	
	   	tcBotesChoconesName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbBotesChoconesList.refresh();
   }
   public void initializeMontanaRusaTableView() {
	   
	   
		ObservableList<Visitor> observableList;
	   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorsInRollerCoaster());
	   	tbMontanaRusaList.setItems(observableList);
	   	
	   	tcMontanaRusaName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
	   	tbMontanaRusaList.refresh();
	   
   }
   public void initializePlansMiniTableView() {
	   
	ObservableList<Visitor> observableList;
   	observableList = FXCollections.observableArrayList(parqueDelCafe.createVisitorList());
   	tbPlanList.setItems(observableList);
   	
   	tcPlan.setCellValueFactory(new PropertyValueFactory<Visitor,String>("name"));
   	tcQuantity.setCellValueFactory(new PropertyValueFactory<Visitor,String>("plan"));
   	
   	
	   
   }
   

    @FXML
    public void dateDelete(ActionEvent event) {
    	
    		/*Visitor v = this.tbDatePickerList.getSelectionModel().getSelectedItem();
    		if(v == null) {
    		
    		
    			
    		}else {
    			
    			this.parqueDelCafe.createVisitorList().remove(v);
    			this.tbPlanList.refresh();
    			initialize
    		}
    		*/	
    	  parqueDelCafe.RemoveVisitor(tbDatePickerList.getSelectionModel().getSelectedItem().getName());
    	  tbDatePickerList.getItems().remove(tbDatePickerList.getSelectionModel().getSelectedItem());
    	  tbDatePickerList.refresh();
    }

    @FXML
    public void planContinue1(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("plan.fxml"));
    	fxmlLoader.setController(this);
    	Parent planPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(planPane);
    	initializePlanComboBoxes();
    	initializePlansMiniTableView();
    	planCurrentUser.setText("Usuario: "+parqueDelCafe.getCurrentCustomer().getUserName());
    }

    @FXML
    public void sub12GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chooser.fxml"));
    	fxmlLoader.setController(this);
    	Parent chooserPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(chooserPane);
    }
    
    
    
    /*
     **********************************************************************************************FIFTH SCREEN PLANS (plan.fxml) ****************************************************************************************************
     */
    
    @FXML
    public void lunchPlan(ActionEvent event) {

    }

    @FXML
    public void multiplePlan(ActionEvent event) {

    }

    @FXML
    public void parkingPlan(ActionEvent event) {

    }
    
    @FXML
    public void AddPlan(ActionEvent event) {

    	String name = planOptPlan1.getValue();
    	String plan = planOptPlan.getValue();
    	int quantity = Integer.parseInt(quantityPlan.getText());
    	@SuppressWarnings("unused")
		int price = 0;
    	
    	int totalPrice = 0;
    	
    	
    	if(plan.equals("Pasaporte Multiple")) {
    		
    		price = 50000;
    		
    	}else if(plan.equals("Almuerzo")) {
    		price = 12000;
    	}else {
    		price = 5000;
    		
    	}
    	
    	totalPrice = parqueDelCafe.calculateTotalprice(quantity, price);
    	totalPricePlan.setText("$" + totalPrice);
    	parqueDelCafe.addPlanToVisitor(name, plan);
    	initializePlansMiniTableView();
    	tbPlanList.refresh();
    }

    @FXML
    public void planContinue(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }

    @FXML
    public void sub11GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("date-picker.fxml"));
    	fxmlLoader.setController(this);
    	Parent datePickerPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(datePickerPane);
    	initializeMiniVisitorTableView();
    }

    
    /*
     **********************************************************************************************SIXTH SCREEN MENU (menu.fxml) *****************************************************************************************************
     */
    
    @FXML
    public void menuSingOut(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
    	fxmlLoader.setController(this);
    	Parent signInPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(signInPane);
    }
    
    @FXML
    public void menuGames(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	menuPane.getChildren().setAll(gamePane);
    }
    
    @FXML
    public void menuFoodCourt(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-court.fxml"));
    	fxmlLoader.setController(this);
    	Parent foodCourtPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(foodCourtPane);
    }
    
    @FXML
    public void menuParking(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parking.fxml"));
    	fxmlLoader.setController(this);
    	Parent parkingPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(parkingPane);
    }

    @FXML
    public void menuOccupancy(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("occupancy.fxml"));
    	fxmlLoader.setController(this);
    	Parent occupancyPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(occupancyPane);
    }
    
    @FXML
    public void menuMyAccount(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user-account.fxml"));
    	fxmlLoader.setController(this);
    	Parent userAccountPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(userAccountPane);
    	
    	initializeCustomerTableView();
    }
    
    @FXML
    public void menuExport(ActionEvent event) {

    }
    
    @FXML
    public void menuImport(ActionEvent event) {

    }
    
    @FXML
    public void sub30GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chooser.fxml"));
    	fxmlLoader.setController(this);
    	Parent chooserPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(chooserPane);
    }
    
    
    /*
     *****************************************************************************************************SEVENTH SCREEN GAMES (games.fxml) **************************************************************************************
     */
    
    @FXML
    public void optBotesChocones(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("botes-chocones.fxml"));
    	fxmlLoader.setController(this);
    	Parent botesChoconesPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(botesChoconesPane);
    	initializeCrashingBoatsComboBox();
    	initializeCrashingBoatsTableView();
    }

    @FXML
    public void optKarts(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("karts.fxml"));
    	fxmlLoader.setController(this);
    	Parent kartsPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(kartsPane);
    	initializeKartsComboBox();
    	initializeKartsTableView();
    }
    
    @FXML
    public void optCarrusel(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("carrusel.fxml"));
    	fxmlLoader.setController(this);
    	Parent carruselPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(carruselPane);
    	initializeCarouselCombobox();
    	initializeCarouselTableView();
    }

    @FXML
    public void optKrater(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("krater.fxml"));
    	fxmlLoader.setController(this);
    	Parent kraterPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(kraterPane);
    	initializeKraterComboBox();
    	initializeKraterTableView();
    	
    }

    @FXML
    public void optMontanaAcuatica(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("montana-acuatica.fxml"));
    	fxmlLoader.setController(this);
    	Parent montanaAcuaticaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(montanaAcuaticaPane);
    	initializeWaterMountainCombBox();
    	initializeWaterMountainTableView();
    }

    @FXML
    public void optMontanaRusa(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("montana-rusa.fxml"));
    	fxmlLoader.setController(this);
    	Parent montanaRusaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(montanaRusaPane);
    	initializeMontanaRusaComboBox();
    	initializeMontanaRusaTableView();
    }

    @FXML
    public void optRapidos(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rapidos.fxml"));
    	fxmlLoader.setController(this);
    	Parent rapidosPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(rapidosPane);
    	initializeFastComboBox();
    	initializeFastTableView();
    }

    @FXML
    public void optRueda(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rueda.fxml"));
    	fxmlLoader.setController(this);
    	Parent ruedaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(ruedaPane);
    	initializeWheelComboBox();
    	initializeWheelTableView();
    }

    @FXML
    public void optTorreCumbre(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("torre-cumbre.fxml"));
    	fxmlLoader.setController(this);
    	Parent torreCumbrePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(torreCumbrePane);
    	initializeCumbreComboBox();
    	initializeCumbreTableView();
    }

    @FXML
    public void optYippe(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yippe.fxml"));
    	fxmlLoader.setController(this);
    	Parent yippePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(yippePane);
    	initializeYipeComboBox();
    	initializeYipeTableView();
    	
    }

    @FXML
    public void sub13GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }
    
    /*
     *****************************************************************************************************EIGHT SCREEN FOOD COURT (food-court.fxml) ****************************************************************************
     */
    
    @FXML
    public void optGuadual(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("el-guadual.fxml"));
    	fxmlLoader.setController(this);
    	Parent elGuadualPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(elGuadualPane);
    }

    @FXML
    public void optHeladeria(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("heladerias-del-parque.fxml"));
    	fxmlLoader.setController(this);
    	Parent heladeriasDelParquePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(heladeriasDelParquePane);
    }

    @FXML
    public void optParrilla(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parrilla-del-parque.fxml"));
    	fxmlLoader.setController(this);
    	Parent parrillaDelParquePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(parrillaDelParquePane);
    }

    @FXML
    public void optSubway(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("subway.fxml"));
    	fxmlLoader.setController(this);
    	Parent subwayPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(subwayPane);
    }

    @FXML
    public void sub6GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }
    
    /*
     *****************************************************************************************************NINETH SCREEN PARKING (parking.fxml) ******************************************************************************
     */
    
    @FXML
    public void optSelectParking(ActionEvent event) {

    }

    @FXML
    public void sub7GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }
    
    /*
     *****************************************************************************************************TENTH SCREEN OCCUPANCY (occupancy.fxml) ************************************************************************
     */
    
    @FXML
    public void sub8GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }
    
    @FXML
    public void searchOptOccupancy(ActionEvent event) {

    }
    
    /*
     *****************************************************************************************************TENTH SCREEN USER ACCOUNT (user-account.fxml) *******************************************************************
     */

    @FXML
    public void sub10GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	fxmlLoader.setController(this);
    	Parent menuPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(menuPane);
    }
    
    private void initializeCustomerTableView() {
    	 ObservableList<CustomerAccount> observableList;
         observableList = FXCollections.observableArrayList(parqueDelCafe.getCustomers());
         tbUserAccountList.setItems(observableList);
         
         
         tcUserAccount.setCellValueFactory(new PropertyValueFactory<CustomerAccount, String>("userName"));
         tcNameAccount.setCellValueFactory(new PropertyValueFactory<CustomerAccount, String>("name"));
         tcAgeAccount.setCellValueFactory(new PropertyValueFactory<CustomerAccount, String>("age"));
         tcGenderAccount.setCellValueFactory(new PropertyValueFactory<CustomerAccount, String>("gender"));
         
         tcUserAccount.setCellFactory(TextFieldTableCell.forTableColumn());
         tcNameAccount.setCellFactory(TextFieldTableCell.forTableColumn());
         tcAgeAccount.setCellFactory(TextFieldTableCell.forTableColumn());
         tcGenderAccount.setCellFactory(TextFieldTableCell.forTableColumn());
         
         tcUserAccount.setOnEditCommit(data -> {
             System.out.println("New username: " +  data.getNewValue());
             System.out.println("Old username: " + data.getOldValue());

             CustomerAccount ca = data.getRowValue();
             ca.setUserName(data.getNewValue());

             System.out.println(ca);
         });
         
         tcNameAccount.setOnEditCommit(data -> {
             System.out.println("New name: " +  data.getNewValue());
             System.out.println("Old  name: " + data.getOldValue());

             CustomerAccount ca = data.getRowValue();
             ca.setName(data.getNewValue());

             System.out.println(ca);
         });
         
         tcAgeAccount.setOnEditCommit(data -> {
             System.out.println("New age: " +  data.getNewValue());
             System.out.println("Old age: " + data.getOldValue());

             CustomerAccount ca = data.getRowValue();
             ca.setAge(data.getNewValue());

             System.out.println(ca);
         });
         
         tcGenderAccount.setOnEditCommit(data -> {
             System.out.println("New gender: " +  data.getNewValue());
             System.out.println("Old gender: " + data.getOldValue());

             CustomerAccount ca = data.getRowValue();
             ca.setGender(data.getNewValue());

             System.out.println(ca);
         });
    }
    
    
    /*
     ***************************************************************************************************** MONTA�A RUSA SCREEN (monta�a-rusa.fxml) *******************************************************************
     */
    
    @FXML
    public void sub14GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    @FXML
    public void AddMontanaRusa(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesMontanaRusa.getValue(), 1);
    	initializeMontanaRusaTableView();
    	System.out.println("Esta entrando");
    }
    
    @FXML
    public void DeleteMontanaRusa(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbMontanaRusaList.getSelectionModel().getSelectedItem().getName());;
    	initializeMontanaRusaTableView();
    	tbMontanaRusaList.refresh();
    	
    	
    }
    
    /*
     ***************************************************************************************************** KARTS SCREEN (karts.fxml) *******************************************************************
     */
    
    @FXML
    public void AddKarts(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesKarts.getValue(), 2);
    	initializeKartsTableView();
    	tbKartsList.refresh();
    }

    @FXML
    public void DeleteKarts(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbKartsList.getSelectionModel().getSelectedItem().getName());
    	initializeKartsTableView();
    	tbKartsList.refresh();
    }

    @FXML
    public void sub16GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** MONTA�A ACU�TICA SCREEN (monta�a-acuatica.fxml) *******************************************************************
     */
    
    @FXML
    public void AddMontanaAcuatica(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesMontanaAcuatica.getValue(), 9);
    	initializeWaterMountainTableView();
    	tbMontanaAcuaticaList.refresh();
    }

    @FXML
    public void DeleteMontanaAcuatica(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbMontanaAcuaticaList.getSelectionModel().getSelectedItem().getName());
    	initializeWaterMountainTableView();
    	tbMontanaAcuaticaList.refresh();
    }

    @FXML
    public void sub17GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** YIPPE SCREEN (yippe.fxml) *******************************************************************
     */
    
    @FXML
    public void AddYippe(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesYippe.getValue(), 8);
    	initializeYipeTableView();
    	tbYippeList.refresh();
    }

    @FXML
    public void DeleteYippe(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbYippeList.getSelectionModel().getSelectedItem().getName());
    	initializeYipeTableView();
    	tbYippeList.refresh();
    }

    @FXML
    public void sub18GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** TORRE CUMBRE SCREEN (torre-cumbre.fxml) *******************************************************************
     */
    
    @FXML
    public void AddTorreCumbre(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesTorreCumbre.getValue(), 10);
    	initializeCumbreTableView();
    	tbTorreCumbreList.refresh();
    }

    @FXML
    public void DeleteTorreCumbre(ActionEvent event) {

    	parqueDelCafe.deleteVisitorInGame(tbTorreCumbreList.getSelectionModel().getSelectedItem().getName());
    	initializeCumbreTableView();
    	tbTorreCumbreList.refresh();
    }

    @FXML
    public void sub19GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** BOTES CHOCONES SCREEN (botes-chocones.fxml) *******************************************************************
     */
    
    @FXML
    public void AddBotesChocones(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesBotesChocones.getValue(), 6);
    	initializeCrashingBoatsTableView();
    	tbBotesChoconesList.refresh();
    }

    @FXML
    public void DeleteBotesChocones(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbBotesChoconesList.getSelectionModel().getSelectedItem().getName());
    	initializeCrashingBoatsTableView();
    	tbBotesChoconesList.refresh();
    }

    @FXML
    public void sub20GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** RAPIDOS SCREEN (rapidos.fxml) *******************************************************************
     */
    
    @FXML
    public void AddRapidos(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesRapidos.getValue(), 7);
    	initializeFastTableView();
    	tbRapidosList.refresh();
    	
    }

    @FXML
    public void DeleteRapidos(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbRapidosList.getSelectionModel().getSelectedItem().getName());
    	initializeFastTableView();
    	tbRapidosList.refresh();
    }

    @FXML
    public void sub21GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** RUEDA SCREEN (rueda.fxml) *******************************************************************
     */
    
    @FXML
    public void AddRueda(ActionEvent event) {

    	parqueDelCafe.moveVisitor(namesRueda.getValue(), 3);
    	initializeWheelTableView();
    	tbRuedaList.refresh();
    }

    @FXML
    public void DeleteRueda(ActionEvent event) {
    	
    	parqueDelCafe.deleteVisitorInGame(tbRuedaList.getSelectionModel().getSelectedItem().getName());
    	initializeWheelTableView();
    	tbRuedaList.refresh();
    	
    }

    @FXML
    public void sub22GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** CARRUSEL SCREEN (carrusel.fxml) *******************************************************************
     */
    
    @FXML
    public void AddCarrusel(ActionEvent event) {
    	
    	parqueDelCafe.moveVisitor(namesCarrusel.getValue(), 4);
    	initializeCarouselTableView();
    	tbCarruselList.refresh();
    }

    @FXML
    public void DeleteCarrusel(ActionEvent event) {

    	parqueDelCafe.deleteVisitorInGame(tbCarruselList.getSelectionModel().getSelectedItem().getName());
    	initializeCarouselTableView();
    	tbCarruselList.refresh();
    }

    @FXML
    public void sub23GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** KRATER SCREEN (krater.fxml) *******************************************************************
     */
    
    @FXML
    public void AddKrater(ActionEvent event) {

    	parqueDelCafe.moveVisitor(namesKrater.getValue(), 5);
    	initializeKraterTableView();
    	tbKraterList.refresh();
    }

    @FXML
    public void DeleteKrater(ActionEvent event) {

    	parqueDelCafe.deleteVisitorInGame(tbKraterList.getSelectionModel().getSelectedItem().getName());
    	initializeKraterTableView();
    	tbKraterList.refresh();
    }

    @FXML
    public void sub24GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** EL GUADUAL SCREEN (el-guadual.fxml) *******************************************************************
     */
    
    @FXML
    public void AddGuadual(ActionEvent event) {

    }

    @FXML
    public void DeleteGuadual(ActionEvent event) {

    }

    @FXML
    public void sub25GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-court.fxml"));
    	fxmlLoader.setController(this);
    	Parent foodCourtPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(foodCourtPane);
    }
    
    /*
     ***************************************************************************************************** PARRILLA DEL PARQUE SCREEN (parrilla-del-parque.fxml) *******************************************************************
     */
    
    @FXML
    public void AddParrilla(ActionEvent event) {

    }

    @FXML
    public void DeleteParrilla(ActionEvent event) {

    }

    @FXML
    public void sub26GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-court.fxml"));
    	fxmlLoader.setController(this);
    	Parent foodCourtPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(foodCourtPane);
    }
    
    /*
     ***************************************************************************************************** SUBWAY SCREEN (subway.fxml) *******************************************************************
     */

    @FXML
    public void AddSubway(ActionEvent event) {

    }

    @FXML
    public void DeleteSubway(ActionEvent event) {

    }

    @FXML
    public void sub27GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-court.fxml"));
    	fxmlLoader.setController(this);
    	Parent foodCourtPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(foodCourtPane);
    }
    

    /*
     ***************************************************************************************************** HELADERIAS DEL PARQUE SCREEN (heladerias-del-parque.fxml) *******************************************************************
     */
    
    @FXML
    public void AddHeladerias(ActionEvent event) {

    }

    @FXML
    public void DeleteHeladerias(ActionEvent event) {

    }

    @FXML
    public void sub28GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-court.fxml"));
    	fxmlLoader.setController(this);
    	Parent foodCourtPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(foodCourtPane);
    }
    
    /*
     ************************************************************************************************************** ALERTS ***********************************************************************************************
     */
    
    @FXML
    public void loginErrorAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Inicio de sesi�n incorrecto");
	    alert.setHeaderText("");
	    alert.setContentText("El usuario y/o contrase�a no coinciden");
	    alert.showAndWait();
	}
    
    @FXML
    public void validationErrorAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Error de validaci�n");
	    alert.setHeaderText("");
	    alert.setContentText("Llene todos los espacios");
	    alert.showAndWait();
    }
    
    @FXML
    public void customerValidationAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Error crear cuenta");
	    alert.setHeaderText("");
	    alert.setContentText("El nombre de usuario escogido ya existe");
	    alert.showAndWait();
	}
    @FXML
    public void visitorRegisterAlert() {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Error al Añadir Visitante");
    	alert.setHeaderText("");
    	alert.setContentText("Debe Llenar todos los datos para añadir un visitante");
    	alert.showAndWait();
    }
    
    
    @FXML
    public void customerCreatedAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Cliente creado");
	    alert.setHeaderText("");
	    alert.setContentText("El cliente ha sido creado satisfactoriamente");
	    alert.showAndWait();
    }
    
    @FXML
    public void accountCreatedAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Cuenta creada");
	    alert.setHeaderText("");
	    alert.setContentText("Nueva cuenta ha sido creada");
	    alert.showAndWait();
    }
}
