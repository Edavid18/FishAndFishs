/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;


import DataBase.Conexion;
import Models.SignUpModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camilo
 */
public class SignUpController implements Initializable {
    
    @FXML
    private TextField name;
    @FXML
    private TextField lname;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private PasswordField password;
    @FXML
    private Button signUp;
    
    private SignUpModel model;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL
            url, ResourceBundle rb) {
        model = new SignUpModel();
    }    

    @FXML
    private void Back(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/LogIn.fxml"));
        Parent root = loader.load();
        LogInController controlador = loader.getController();
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
    private void SignUp(ActionEvent event) {
        
        model.signUpUser(email.getText(), password.getText(), name.getText(), phone.getText());
       
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/LogIn.fxml"));
        Parent root = loader.load();
        LogInController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        Conexion cx = new Conexion();
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
