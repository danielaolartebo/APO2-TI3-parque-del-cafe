package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.ParqueDelCafe;

//Prueba 
public class Main extends Application{
	private ParqueDelCafe parqueDelCafe;
	private ParqueDelCafeGUI parqueDelCafeGUI;
	
	public Main() throws IOException, ClassNotFoundException {
		parqueDelCafe = new ParqueDelCafe();
		parqueDelCafeGUI = new ParqueDelCafeGUI(parqueDelCafe);
		
		try {
			parqueDelCafeGUI.loadData();
			parqueDelCafe.loadData();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("");
			alert.setContentText("No se pudo cargar datos del archivo");
			alert.showAndWait();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(parqueDelCafeGUI);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("El Parque Del Cafe");
		primaryStage.show();
		
		primaryStage.setMinHeight(640);
        primaryStage.setMinWidth(820);
        primaryStage.setMaxWidth(820);        
        primaryStage.setMaxHeight(640);

       
	}
	
}