/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import DataBase.Conexion;
import Thread.TimeThread;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author camilo
 */

public class Main extends Application{
    
    Conexion cx = Conexion.getInstance();
    
    @Override
    public void start(Stage primaryStage) {

        try {
            cx.Connection();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/LandingPage.fxml"));
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
        launch();
    }
}
