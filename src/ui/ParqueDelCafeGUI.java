package ui;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import model.ParqueDelCafe;

public class ParqueDelCafeGUI {
	
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
    private TextField newUsername;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField newName;
    @FXML
    private TextField newAge;
    @FXML
    private RadioButton newMale;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton newFemale;
    @FXML
    private RadioButton newOther;
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
    private TableView<?> tbUserAccountList;
    @FXML
    private TableColumn<?, ?> tcUserAccount;
    @FXML
    private TableColumn<?, ?> tcNameAccount;
    @FXML
    private TableColumn<?, ?> tcAgeAccount;
    @FXML
    private TableColumn<?, ?> tcGenderAccount;
    @FXML
    private TableColumn<?, ?> tcPlanAccount;
    @FXML
    private TableColumn<?, ?> tcTotalPriceAccount;
    @FXML
    private TableColumn<?, ?> tcBenefitsAccount;




    private RadioButton rbSelected;
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
   // 	String userName=txtUsername.getText();
   //  	String password=txtPassword.getText();
     	
//     	if(parqueDelCafe.validateCustomer(userName, password)) {
     	
     		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("date-picker.fxml"));
        	fxmlLoader.setController(this);
        	Parent datePickerPane = fxmlLoader.load();
        	mainPane.getChildren().setAll(datePickerPane);
        		
    /* 	}else if(!parqueDelCafe.validateCustomer(userName, password)) {
     		loginErrorAlert();
     	} */
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
    	String userName=newUsername.getText();
    	String password=newPassword.getText();
    	String name=newName.getText(); 
    	String gender=rbSelected.getText();   	
    	String age=newAge.getText();
    	
    	if (userName.isEmpty() || password.isEmpty() || name.isEmpty() || gender.isEmpty() || age.isEmpty()) {
        	validationErrorAlert();
        }else if(parqueDelCafe.validateCustomer(userName, password)) {
        	
        	accountCreatedAlert();
        	parqueDelCafe.addCustomer(userName, password, name, gender, age);
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
        	fxmlLoader.setController(this);
        	Parent signInPane = fxmlLoader.load();
        	mainPane.getChildren().setAll(signInPane);
        	}else {
        		customerValidationAlert();
        	}
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
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
    	fxmlLoader.setController(this);
    	Parent signInPane = fxmlLoader.load();
    	mainPane.getChildren().setAll(signInPane);
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
    }
    
    @FXML
    public void menuExport(ActionEvent event) {

    }
    
    @FXML
    public void menuImport(ActionEvent event) {

    }
    
    
    /*
     *****************************************************************************************************SEVENTH SCREEN GAMES (games.fxml) **************************************************************************************
     */
    
    @FXML
    public void optBotesChocones(ActionEvent event) {

    }

    @FXML
    public void optKarts(ActionEvent event) {

    }

    @FXML
    public void optKrater(ActionEvent event) {

    }

    @FXML
    public void optMontañaAcuatica(ActionEvent event) {

    }

    @FXML
    public void optMontañaRusa(ActionEvent event) {

    }

    @FXML
    public void optRapidos(ActionEvent event) {

    }

    @FXML
    public void optRueda(ActionEvent event) {

    }

    @FXML
    public void optTorreCumbre(ActionEvent event) {

    }

    @FXML
    public void optYippe(ActionEvent event) {

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
    public void optGuadual(ActionEvent event) {

    }

    @FXML
    public void optHeladeria(ActionEvent event) {

    }

    @FXML
    public void optPandebono(ActionEvent event) {

    }

    @FXML
    public void optParrilla(ActionEvent event) {

    }

    @FXML
    public void optSubway(ActionEvent event) {

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
