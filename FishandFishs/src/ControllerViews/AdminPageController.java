/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

    /**
     * Initializes the controller class.
     */
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
       
        
        }catch(Exception E){
        }
        
        
        
    }    
    /**
    private void addItem(String name, String price, String desc, String route, String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/adminPageItems.fxml"));
        AnchorPane is = loader.load();
        
        AdminPageItemsController controller = loader.getController();
        controller.changeLabels(name, price, desc, route, id);

        /*if (itemsPane.getChildren().isEmpty()) {
            itemsPane.getChildren().add(shoppingCartItem); // If empty, just add the item
        }else {
            itemsPane.getChildren().add(itemsPane.getChildren().size() - 1, shoppingCartItem); // Adds above the last item
        } 
        itemsPane.getChildren().add(is);
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
    
    private void addItems() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VistaAdmin/Estadisticas.fxml"));
        AnchorPane shoppingCartItem = loader.load();
        
        EstadisticasController controller = loader.getController();

        chartPane.getChildren().add(shoppingCartItem);
    }

    @FXML
    private void goToChart(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VistaAdmin/Estadisticas.fxml"));
        Parent root = loader.load();
        EstadisticasController controlador = loader.getController();
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
    */
}
