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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */

public class ShoppingCartController implements Initializable, Observer{

    @FXML
    private VBox itemsPane;
    
    ShoppingCartModel model = new ShoppingCartModel();
    private ArrayList<Integer> shoppingCartItems = model.getProdID(UserSession.getUserId());
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        update();
    }
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ShoppingCartItem.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        ShoppingCartItemController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);
        controller.setShoppingCartController(this);
        controller.addObserver(this);

        itemsPane.getChildren().add(shoppingCartItem);
    }

    @FXML
    private void goBackToCatalogue(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Catalogue.fxml"));
        Parent root = loader.load();
        CatalogueController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }
        catch(IOException ex){
           
        }
    }

    @FXML
    private void goToCheckout(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/checkout.fxml"));
        Parent root = loader.load();
        CheckoutController controlador = loader.getController();
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
    
    @Override
    public void update() {
        try {
            itemsPane.getChildren().clear();
            shoppingCartItems = model.getProdID(UserSession.getUserId());
            
            for (int i = 0; i < shoppingCartItems.size(); i++) {
                
                String[] order = model.getProductAmount(shoppingCartItems.get(i), UserSession.getUserId());

                String[] product = model.getProductDetail(shoppingCartItems.get(i));

                addItem(product[0], product[1], order[0], product[2], order[1]);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}