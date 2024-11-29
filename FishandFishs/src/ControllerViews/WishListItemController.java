/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Interfaces.Observable;
import Interfaces.Observer;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class WishListItemController implements Initializable, Observable {

    @FXML
    private Label ProdName;
    @FXML
    private Label price;
    @FXML
    private Label desc;
    @FXML
    private ImageView image;
    
    public String id;
    public String idp;
    
    private WishListController wishListController;
    private ArrayList<Observer> observers = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    
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
    
    public void changeLabels(String productName, String price, String amount, String route, String id, String idp){
      ProdName.setText(productName);
      this.price.setText(price);
      desc.setText(amount);
      
      
      this.id = id;
      this.idp = idp;
      
      Image imagen = new Image(route);
      image.setImage(imagen);
    }
    
    public void setWishListController(WishListController wishListController) {  // Add this method
        this.wishListController = wishListController;
    }

    @FXML
    private void addToCart(ActionEvent event) {
        wishListController.model.addProductShoppingList(UserSession.getUserId(), Integer.parseInt(idp), desc.getText());
        wishListController.model.deleteOrder(Integer.parseInt(id));
        notifyObservers();
    }

    @FXML
    private void delete(ActionEvent event) {
        wishListController.model.deleteOrder(Integer.parseInt(id));
        notifyObservers();
    }
    
}
