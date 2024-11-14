/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camilo
 */
public class LogInController implements Initializable {

    
    @FXML
    private Pane pane;
    @FXML
    private TextField email;
    @FXML
    private Button logIn;
    @FXML
    private PasswordField password;

   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoSignUp(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SignUp.fxml"));
        Parent root = loader.load();
        SignUpController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
        
    }

    @FXML
    private void LogIn(ActionEvent event) {
        
        
        String user = email.getText();
        String pw = password.getText();

        if (user.equals("ruben") && pw.equals("ruben")) {
            goToAdminPage(event);
        }else{
            goToCatalogue(event);
        }
    }
    
    private void goToCatalogue(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Catalogue.fxml"));
        Parent root = loader.load();
        CatalogueController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }
    
    private void goToAdminPage(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/adminPage.fxml"));
        Parent root = loader.load();
        AdminPageController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }

    @FXML
    private void goToLanding(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/LandingPage.fxml"));
        Parent root = loader.load();
        LandingPageController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }
    
}
