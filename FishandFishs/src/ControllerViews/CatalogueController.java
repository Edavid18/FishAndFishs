 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ControllerViews;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EVER
 */
public class CatalogueController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private Pane uglygx2;
    @FXML
    private Pane oceaplugger;
    @FXML
    private Pane freaky;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaCompra.fxml"));
     VistaCompraController obj = new VistaCompraController();

    @FXML
    private void Cana1(MouseEvent event) {
        obj.cambiar("Fishing Rod Pro",489.99,"1001","/images/canas1/shimano-ocea-plugger.jpg");
    }

    @FXML
    private void plugger(MouseEvent event) {
        obj.cambiar("Ocea Plugger",719.99,"1003","/images/canas1/oceaplugger.png");
    }

    @FXML
    private void uglstcik(MouseEvent event) {
        obj.cambiar("Ugly Freaky Stick",69.99,"1004","/images/canas1/fiberglass.png");
    }

    @FXML
    private void mercury(MouseEvent event) {
        obj.cambiar("Mercury Avator 7.5",3499.99,"5001","/images/canas1/mercury.jpg");
    }

    @FXML
    private void yeti(MouseEvent event) {
        obj.cambiar("YETY Cooler",299.99,"3001","/images/miselanea/yeti-tundra-45-cooler-1.png");
    }

    @FXML
    private void coleman(MouseEvent event) {
        obj.cambiar("Cooleman 316",49.99,"3002","/images/miselanea/coleman-316-series-.jpg");
    }

    @FXML
    private void american(MouseEvent event) {
        obj.cambiar("American kit",49.99,"4001","/images/miselanea/kit .png");
    }

    @FXML
    private void Devianton(MouseEvent event) {
        obj.cambiar("Deviaton 6 Boot",134.99,"2001","/images/miselanea/boots.png");
    }

    @FXML
    private void xtratuf(MouseEvent event) {
        obj.cambiar("Xtratuf",139.99,"2002","/images/miselanea/ADSM100_LARGE.jpg");
    }

    @FXML
    private void stringer(MouseEvent event) {
        obj.cambiar("Stringer198",45000,"6001","/images/botes/Stinger-198-Metallic-Blue.png");
    }

    @FXML
    private void machine(MouseEvent event) {
        obj.cambiar("Fishing Macihe",35000,"6002","/images/botes/fishingmachine.png");
    }

    @FXML
    private void thevw(MouseEvent event) {
        obj.cambiar("The VW",60000,"6003","/images/botes/lb-wv1670.png");
    }

    @FXML
    private void lblegacy(MouseEvent event) {
        obj.cambiar("LB Legacy",22325,"6004","/images/botes/lb-legacy.png");
    }

    @FXML
    private void Rough(MouseEvent event) {
        obj.cambiar("Roughneck 2070",27000,"6005","/images/botes/lb-roughneck-2070.png");
    }

    @FXML
    private void fishand(MouseEvent event) {
        obj.cambiar("Fish and Sky",50000,"6006","/images/botes/lb-fs1900.png");
    }

    @FXML
    private void rs270(MouseEvent event) {
        obj.cambiar("RS 270",74600,"6007","/images/botes/lb-rs27ew.png");
    }

    @FXML
    private void g2(MouseEvent event) {
        obj.cambiar("Ugly Stick Gx2",539.99,"1002","/images/canas1/ugly-stik-gx2.jpg");
    }

    @FXML
    private void goToShoppingCart(ActionEvent event) {
        
    }

    @FXML
    private void goToLogIn(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/LandingPage.fxml"));
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
    private void goToWishList(ActionEvent event) {
       
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
    
}
