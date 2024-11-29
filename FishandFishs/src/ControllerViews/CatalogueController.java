 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import Interfaces.Observer;
import Models.CatalogueModel;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author EVER
 */
public class CatalogueController implements Initializable {

    CatalogueModel model = new CatalogueModel();
    
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Label welcome;
    @FXML
    private Pane Cana1;
    @FXML
    private Pane g2;
    @FXML
    private Pane plugger;
    @FXML
    private Pane uglstick;
    @FXML
    private Pane mercury;
    @FXML
    private Pane yeti;
    @FXML
    private Pane coleman;
    @FXML
    private Pane american;
    @FXML
    private Pane Devianton;
    @FXML
    private Pane xtratuf;
    @FXML
    private Pane stringer;
    @FXML
    private Pane machine;
    @FXML
    private Pane thevw;
    @FXML
    private Pane lblegacy;
    @FXML
    private Pane Rough;
    @FXML
    private Pane fishand;
    @FXML
    private Pane rs270;
    
    public CatalogueController(){
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        welcome.setText("Welcome, " + UserSession.getName());
    }    
    VistaCompraController obj = new VistaCompraController();

    @FXML
    private void goToLogIn(ActionEvent event) {
        try{
        UserSession.logout();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/LandingPage.fxml"));
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
    @FXML
    private void handleProductClick(MouseEvent event) {
        // Get the ID of the clicked control
        String controlId = ((Node) event.getSource()).getId();

        // Find the product
        String[] product = model.getProductDetail(controlId);
        if (product != null) {
            obj.cambiar(product[0], Double.parseDouble(product[1]), product[2], product[3]);
        }
    }

    @FXML
    private void goToHistory(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ShoppingHistory.fxml"));
        Parent root = loader.load();
        ShoppingHistoryController controlador = loader.getController();
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
    private void carro(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/ShoppingCart.fxml"));
        Parent root = loader.load();
        ShoppingCartController controlador = loader.getController();
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
    private void deseo(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/WishList.fxml"));
        Parent root = loader.load();
        WishListController controlador = loader.getController();
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
    private void Goboats(MouseEvent event) {
        
    }
    
}
