 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

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
        System.out.println(UserSession.getName());
    }
    
    private final Map<String, Product> products = new HashMap<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        welcome.setText("Welcome, " + UserSession.getName());
        products.put("Cana1", new Product("Fishing Rod Pro", 489.99, "1001", "/images/canas1/shimano-ocea-plugger.jpg"));
        products.put("plugger", new Product("Ocea Plugger", 719.99, "1003", "/images/canas1/oceaplugger.png"));
        products.put("uglstick", new Product("Ugly Freaky Stick", 69.99, "1004", "/images/canas1/fiberglass.png"));
        products.put("mercury", new Product("Mercury Avator 7.5", 3499.99, "5001", "/images/canas1/mercury.jpg"));
        products.put("yeti", new Product("YETY Cooler", 299.99, "3001", "/images/miselanea/yeti-tundra-45-cooler-1.png"));
        products.put("coleman", new Product("Cooleman 316", 49.99, "3002", "/images/miselanea/coleman-316-series-.jpg"));
        products.put("american", new Product("American kit", 49.99, "4001", "/images/miselanea/kit .png"));
        products.put("Devianton", new Product("Deviaton 6 Boot", 134.99, "2001", "/images/miselanea/boots.png"));
        products.put("xtratuf", new Product("Xtratuf", 139.99, "2002", "/images/miselanea/ADSM100_LARGE.jpg"));
        products.put("stringer", new Product("Stringer198", 45000, "6001", "/images/botes/Stinger-198-Metallic-Blue.png"));
        products.put("machine", new Product("Fishing Macihe", 35000, "6002", "/images/botes/fishingmachine.png"));
        products.put("thevw", new Product("The VW", 60000, "6003", "/images/botes/lb-wv1670.png"));
        products.put("lblegacy", new Product("LB Legacy", 22325, "6004", "/images/botes/lb-legacy.png"));
        products.put("Rough", new Product("Roughneck 2070", 27000, "6005", "/images/botes/lb-roughneck-2070.png"));
        products.put("fishand", new Product("Fish and Sky", 50000, "6006", "/images/botes/lb-fs1900.png"));
        products.put("rs270", new Product("RS 270", 74600, "6007", "/images/botes/lb-rs27ew.png"));
        products.put("g2", new Product("Ugly Stick Gx2", 539.99, "1002", "/images/canas1/ugly-stik-gx2.jpg"));
    }    
    // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaCompra.fxml"));
     VistaCompraController obj = new VistaCompraController();

    @FXML
    private void goToLogIn(ActionEvent event) {
        try{
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
        Product product = products.get(controlId);
        if (product != null) {
            obj.cambiar(product.name, product.price, product.code, product.imagePath);
        }
    }

    @FXML
    private void goToHistory(ActionEvent event) {
        
    }

    @FXML
    private void carro(MouseEvent event) {
        
    }

    @FXML
    private void deseo(MouseEvent event) {
        
    }

    @FXML
    private void Goboats(MouseEvent event) {
        
    }
    
    private static class Product {
        String name;
        double price;
        String code;
        String imagePath;

        public Product(String name, double price, String code, String imagePath) {
            this.name = name;
            this.price = price;
            this.code = code;
            this.imagePath = imagePath;
        }
    }
    
}
