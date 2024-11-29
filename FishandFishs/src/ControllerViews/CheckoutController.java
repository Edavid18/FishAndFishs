/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Interfaces.Observer;
import Models.CheckoutModel;
import Models.ShoppingCartModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class CheckoutController implements Initializable, Observer {

    @FXML
    private VBox itemsPane;
    @FXML
    private TextField discountCode;
    @FXML
    private Label subTotal;
    @FXML
    private Label total;
    
    private String tot;
    @FXML
    private Button DiscountButton;
    @FXML
    private Button payButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        update();
        payButton.setDisable(true);
    }    
    
    ShoppingCartModel shoppingItems = new ShoppingCartModel();
    CheckoutModel model = new CheckoutModel();
    private ArrayList<Integer> shoppingCartItems = shoppingItems.getProdID(UserSession.getUserId());
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ShoppingCartItem.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        ShoppingCartItemController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);
        controller.setCheckOutController(this);
        controller.addObserver(this);

        itemsPane.getChildren().add(shoppingCartItem);
    }

    @FXML
    private void goBackToCatalogue(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Catalogue.fxml"));
        Parent root = loader.load();
        CatalogueController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }catch(IOException ex){
        }
    }

    @FXML
    private void addDiscount(ActionEvent event) {
        double totalAmount = model.getTotal(shoppingCartItems, discountCode.getText());
        total.setText(String.valueOf(totalAmount));
        payButton.setDisable(false);
    }

    @FXML
    private void pay(ActionEvent event) {
        
        for (int i = 0; i < shoppingCartItems.size(); i++) {
            String[] order = shoppingItems.getProductAmount(shoppingCartItems.get(i), UserSession.getUserId());
            model.addProductHistory(UserSession.getUserId(), shoppingCartItems.get(i), order[0]);
            model.deleteOrder(Integer.parseInt(order[1]));
        }
        update();
        
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

    @Override
    public void update() {
        try {
            itemsPane.getChildren().clear();
            shoppingCartItems = shoppingItems.getProdID(UserSession.getUserId());
            
            for (int i = 0; i < shoppingCartItems.size(); i++) {
                String[] product = shoppingItems.getProductDetail(shoppingCartItems.get(i));
                String[] order = shoppingItems.getProductAmount(shoppingCartItems.get(i), UserSession.getUserId());
                addItem(product[0], product[1], order[0], product[2], order[1]);
            }
            
            double subTotalAmount = model.getSubTotal(shoppingCartItems);
            subTotal.setText(String.valueOf(subTotalAmount));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
