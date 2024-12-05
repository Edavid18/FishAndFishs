package ControllerViews;

import Models.EstadisticaModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class EstadisticasController implements Initializable {
    
    @FXML
    private LineChart<String, Number> lineas;
    @FXML
    private CategoryAxis xAxis;
    
    EstadisticaModel model = new EstadisticaModel();
    Map<Integer, Integer> prodId = model.iterateThroughTable();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        
        xAxis.setTickLabelRotation(360);
        lineas.setTitle("Sales of products");
        series.setName("Times sold");
        
        Map<Integer, Integer> prodId = model.iterateThroughTable();
        
        prodId.forEach((key, value) -> series.getData().add(new XYChart.Data<>(String.valueOf(key), value)));
        
        lineas.getData().add(series);
    }
}
