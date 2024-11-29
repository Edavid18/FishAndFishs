/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Interfaces.Observable;
import Interfaces.Observer;
import Models.ShoppingCartModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */

public class ShoppingCartItemController implements Initializable, Observable {

    @FXML
    private ImageView imgSrc;
    @FXML
    private Label ProdName;
    @FXML
    private Label price;
    @FXML
    private Label desc;

    public String id;
    
    private ShoppingCartController shoppingCartController;
    private CheckoutController checkout;
    boolean shop = false;
    boolean buy = false;
    
    private ArrayList<Observer> observers = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
    public void changeLabels(String productName, String price, String description, String route, String id){
        ProdName.setText(productName);
        this.price.setText(price);
        desc.setText(description);

        Image imagen = new Image(route);
        imgSrc.setImage(imagen);

        this.id = id;
    }
    
    public void setShoppingCartController(ShoppingCartController shoppingCartController) {  // Add this method
        this.shoppingCartController = shoppingCartController;
        shop = true;
        buy = false;
        
    }
    
    public void setCheckOutController(CheckoutController checkout){
        this.checkout = checkout;
        shop = false;
        buy = true;
    }

    @FXML
    private void delete(ActionEvent event) {
        if (shop) {
            shoppingCartController.model.deleteOrder(Integer.parseInt(id));
            notifyObservers();
        }else if(buy){
            checkout.model.deleteOrder(Integer.parseInt(id));
            notifyObservers();
        }
        
    }
    
    
    
}