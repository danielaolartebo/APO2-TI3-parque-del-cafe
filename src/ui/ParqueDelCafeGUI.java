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

    
    
    // PLAN MINI TABLE VIEW 
    
    @FXML
    private TableView<?> tbPlanList;
    @FXML
    private TableColumn<?, ?> tcPlan;
    @FXML
    private TableColumn<?, ?> tcQuantity;
    @FXML
    private TextField quantityPlan;
    @FXML
    private ComboBox<?> planOptPlan;
    
    // DATE PICKER MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbDatePickerList;
    @FXML
    private TableColumn<?, ?> tcDateName;
    @FXML
    private TableColumn<?, ?> tcDateAge;
    @FXML
    private TableColumn<?, ?> tcDateGender;
    @FXML
    private TextField dateName;
    @FXML
    private DatePicker dateDate;
    @FXML
    private TextField dateAge;
    @FXML
    private ToggleGroup genderGroupDate;
    
    // OCCUPANCY TABLE VIEW
    
    @FXML
    private TableView<?> tbOccupancyList;
    @FXML
    private TableColumn<?, ?> tcNumberOccupancy;
    @FXML
    private TableColumn<?, ?> tcNameOccupancy;
    @FXML
    private TableColumn<?, ?> tcAgeOccupancy;
    @FXML
    private TableColumn<?, ?> tcGenderOccupancy;
    @FXML
    private TableColumn<?, ?> tcGamesOccupancy;
    @FXML
    private TableColumn<?, ?> tcFoodCourtOccupancy;
    @FXML
    private TableColumn<?, ?> tcParkingOccupancy;
    @FXML
    private TableColumn<?, ?> tcTotalPriceOccupancy;
    
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
    
    // MONTAÑA RUSA MINI TABLE VIEW 
    
    @FXML
    private TableView<?> tbMontanaRusaList;
    @FXML
    private TableColumn<?, ?> tcMontanaRusaName;
    @FXML
    private ComboBox<?> namesMontanaRusa;
    
    // KARTS MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbKartsList;
    @FXML
    private TableColumn<?, ?> tcKartsName;
    @FXML
    private ComboBox<?> namesKarts;
    
    // MONTAÑA ACUATICA MINI TABLE VIEW

    @FXML
    private TableView<?> tbMontanaAcuaticaList;
    @FXML
    private TableColumn<?, ?> tcMontanaAcuaticaName;
    @FXML
    private ComboBox<?> namesMontanaAcuatica;
    
    // YIPPE MINI TABLE VIEW

    @FXML
    private TableView<?> tbYippeList;
    @FXML
    private TableColumn<?, ?> tcYippeName;
    @FXML
    private ComboBox<?> namesYippe;
    
    // TORRE CUMBRE MINI TABLE VIEW

    @FXML
    private TableView<?> tbTorreCumbreList;
    @FXML
    private TableColumn<?, ?> tcTorreCumbreName;
    @FXML
    private ComboBox<?> namesTorreCumbre;
    
    // BOTES CHOCONES MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbBotesChoconesList;
    @FXML
    private TableColumn<?, ?> tcBotesChoconesName;
    @FXML
    private ComboBox<?> namesBotesChocones;
    
    // RAPIDOS MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbRapidosList;
    @FXML
    private TableColumn<?, ?> tcRapidosName;
    @FXML
    private ComboBox<?> namesRapidos;
    
    // RUEDA MINI TABLE VIEW

    @FXML
    private TableView<?> tbRuedaList;
    @FXML
    private TableColumn<?, ?> tcRuedaName;
    @FXML
    private ComboBox<?> namesRueda;
    
    // CARRUSEL MINI TABLE VIEW

    @FXML
    private TableView<?> tbCarruselList;
    @FXML
    private TableColumn<?, ?> tcCarruselName;
    @FXML
    private ComboBox<?> namesCarrusel;
    
    // KRATER MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbKraterList;
    @FXML
    private TableColumn<?, ?> tcKraterName;
    @FXML
    private ComboBox<?> namesKrater;
    
    // EL GUADUAL MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbGuadualList;
    @FXML
    private TableColumn<?, ?> tcGuadualName;
    @FXML
    private ComboBox<?> namesGuadual;
    
    // PARRILLA DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbParrillaList;
    @FXML
    private TableColumn<?, ?> tcParrillaName;
    @FXML
    private ComboBox<?> namesParrilla;
    
    // SUBWAY DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbSubwayList;
    @FXML
    private TableColumn<?, ?> tcSubwayName;
    @FXML
    private ComboBox<?> namesSubway;
    
    // HELADERÍAS DEL PARQUE MINI TABLE VIEW
    
    @FXML
    private TableView<?> tbHeladeriasList;
    @FXML
    private TableColumn<?, ?> tcHeladeriasName;
    @FXML
    private ComboBox<?> namesHeladerias;
    
    
    
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
	    alert.setTitle("El Parque Del Café ");
	    alert.setHeaderText("Creditos");
	    alert.setContentText("Daniela Olarte, Santiago Gutierrez y Esteban Mendoza \nAlgoritmos y Promagración II \nUniversidad ICESI 2021");
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
     	
     		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chooser.fxml"));
        	fxmlLoader.setController(this);
        	Parent chooserPane = fxmlLoader.load();
        	mainPane.getChildren().setAll(chooserPane);
        		
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
    public void dateAdd(ActionEvent event) {

    }

    @FXML
    public void dateDelete(ActionEvent event) {

    }

    @FXML
    public void planContinue1(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("plan.fxml"));
    	fxmlLoader.setController(this);
    	Parent planPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(planPane);
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
    	mainPane.getChildren().setAll(gamePane);
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
    }

    @FXML
    public void optKarts(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("karts.fxml"));
    	fxmlLoader.setController(this);
    	Parent kartsPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(kartsPane);
    }
    
    @FXML
    public void optCarrusel(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("carrusel.fxml"));
    	fxmlLoader.setController(this);
    	Parent carruselPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(carruselPane);
    }

    @FXML
    public void optKrater(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("krater.fxml"));
    	fxmlLoader.setController(this);
    	Parent kraterPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(kraterPane);
    }

    @FXML
    public void optMontañaAcuatica(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("montaña-acuatica.fxml"));
    	fxmlLoader.setController(this);
    	Parent montañaAcuaticaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(montañaAcuaticaPane);
    }

    @FXML
    public void optMontañaRusa(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("montaña-rusa.fxml"));
    	fxmlLoader.setController(this);
    	Parent montañaRusaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(montañaRusaPane);
    }

    @FXML
    public void optRapidos(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rapidos.fxml"));
    	fxmlLoader.setController(this);
    	Parent rapidosPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(rapidosPane);
    }

    @FXML
    public void optRueda(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rueda.fxml"));
    	fxmlLoader.setController(this);
    	Parent ruedaPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(ruedaPane);
    }

    @FXML
    public void optTorreCumbre(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("torre-cumbre.fxml"));
    	fxmlLoader.setController(this);
    	Parent torreCumbrePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(torreCumbrePane);
    }

    @FXML
    public void optYippe(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("yippe.fxml"));
    	fxmlLoader.setController(this);
    	Parent yippePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(yippePane);
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
     ***************************************************************************************************** MONTAÑA RUSA SCREEN (montaña-rusa.fxml) *******************************************************************
     */
    
    @FXML
    public void sub14GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    @FXML
    public void AddMontañaRusa(ActionEvent event) {

    }
    
    @FXML
    public void DeleteMontañaRusa(ActionEvent event) {

    }
    
    /*
     ***************************************************************************************************** KARTS SCREEN (karts.fxml) *******************************************************************
     */
    
    @FXML
    public void AddKarts(ActionEvent event) {

    }

    @FXML
    public void DeleteKarts(ActionEvent event) {

    }

    @FXML
    public void sub16GoBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("games.fxml"));
    	fxmlLoader.setController(this);
    	Parent gamePane = fxmlLoader.load();
    	mainPane.getChildren().setAll(gamePane);
    }
    
    /*
     ***************************************************************************************************** MONTAÑA ACUÁTICA SCREEN (montaña-acuatica.fxml) *******************************************************************
     */
    
    @FXML
    public void AddMontañaAcuatica(ActionEvent event) {

    }

    @FXML
    public void DeleteMontañaAcuatica(ActionEvent event) {

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

    }

    @FXML
    public void DeleteYippe(ActionEvent event) {

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

    }

    @FXML
    public void DeleteTorreCumbre(ActionEvent event) {

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

    }

    @FXML
    public void DeleteBotesChocones(ActionEvent event) {

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

    }

    @FXML
    public void DeleteRapidos(ActionEvent event) {

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

    }

    @FXML
    public void DeleteRueda(ActionEvent event) {

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

    }

    @FXML
    public void DeleteCarrusel(ActionEvent event) {

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

    }

    @FXML
    public void DeleteKrater(ActionEvent event) {

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
	    alert.setTitle("Inicio de sesión incorrecto");
	    alert.setHeaderText("");
	    alert.setContentText("El usuario y/o contraseña no coinciden");
	    alert.showAndWait();
	}
    
    @FXML
    public void validationErrorAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Error de validación");
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
