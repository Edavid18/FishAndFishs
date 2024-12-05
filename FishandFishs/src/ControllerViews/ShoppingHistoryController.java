/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Models.ShoppingHistoryModel;
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

public class ShoppingHistoryController implements Initializable {

    @FXML
    private VBox itemsPane;
    
    ShoppingHistoryModel model = new ShoppingHistoryModel();
    ArrayList<Integer> itemsInHistory = model.getProdID(UserSession.getUserId());
    ArrayList<String[]> order = model.getProductAmount(UserSession.getUserId());
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            itemsPane.getChildren().clear();
            
            for (int i = 0; i < order.size(); i++) {
                String[] details = order.get(i);
                String[] product = model.getProductDetail(Integer.parseInt(details[2]));
                addItem(product[0], product[1], details[3], product[2], details[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ShoppingHistoryItem.fxml"));
        AnchorPane ks = loader.load();
        
        ShoppingHistoryItemController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);
        
        itemsPane.getChildren().add(ks);
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
        
        }
        catch(IOException ex){
           
        }
    }
    
}
