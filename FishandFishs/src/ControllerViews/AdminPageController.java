/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;


import Models.AdminModel;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userSession.UserSession;

/**
 * FXML Controller class
 *
 * @author camilo
 */
public class AdminPageController implements Initializable {

    @FXML
    private VBox itemsPane;
    @FXML
    private Pane chartPane;
    @FXML
    private Button back;
    
    AdminModel model = new AdminModel();
    ArrayList<String[]> products = model.iterateThroughTable();

    /**
     * Initializes the controller class.
     */
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            for (int i = 0; i < products.size(); i++) {
                String[] product = products.get(i);
                addItem(product[1], product[2], product[3], product[0]);
            }
            addItems();
        }catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    private void addItem(String name, String price, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/adminPageItems.fxml"));
        AnchorPane ks = loader.load();
        
        AdminPageItemsController controller = loader.getController();
        controller.changeLabels(name, price, route, id);
        
        
        itemsPane.getChildren().add(ks);
    }
    
    
    private void addItems() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Estadisticas.fxml"));
        Pane shoppingCartItem = loader.load();
        
        EstadisticasController controller = loader.getController();
        
        chartPane.getChildren().add(shoppingCartItem);
    }

    @FXML
    private void backToLandingPage(ActionEvent event) {
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
    
}
