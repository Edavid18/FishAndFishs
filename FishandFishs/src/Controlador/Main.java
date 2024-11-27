/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import DataBase.Conexion;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import userSession.UserSession;

/**
 *
 * @author camilo
 */

public class Main extends Application{
    
    Conexion cx = Conexion.getInstance();
    
    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage primaryStage) {

        try {
            cx.Connection();
            FXMLLoader loader = new FXMLLoader();
            System.out.println(Main.class.getResource("/Views/LogIn.fxml"));
            loader.setLocation(Main.class.getResource("/Views/LogIn.fxml"));
            Pane ventana = (Pane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
