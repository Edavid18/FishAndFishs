/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Interfaces.Observer;
import Models.WishListModel;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author eliasvidal
 */
public class WishListController implements Initializable, Observer {

    @FXML
    private VBox itemsPane;
    
    WishListModel model = new WishListModel();    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        update();
    }
    
    private void addItem(String name, String price, String amount, String route, String id, int idp) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/WishListItem.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        WishListItemController controller = loader.getController();
        controller.changeLabels(name, price, amount, route, id, String.valueOf(idp));
        controller.setWishListController(this);
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
       // stage.initModality(Modality.APPLICATION_MODAL); sirve para no salir hasta terminar el programa
        stage.setScene(scene);
        
        stage.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        }catch(IOException ex){
        }
    }

    @Override
    public void update() {
        try {
            itemsPane.getChildren().clear();
            ArrayList<Integer> wishListItems = model.getProdID(UserSession.getUserId());
            
            for (int i = 0; i < wishListItems.size(); i++) {
                
                String[] order = model.getProductAmount(wishListItems.get(i), UserSession.getUserId());

                String[] product = model.getProductDetail(wishListItems.get(i));

                addItem(product[0], product[1], order[0], product[2], order[1], wishListItems.get(i));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
