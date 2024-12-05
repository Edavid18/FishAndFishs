/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eliasvidal
 */
public class EstadisticaModel {
    
    public Map<Integer, Integer> iterateThroughTable() {
    Connection connection = Conexion.getInstance().Connection();
    String query = "SELECT * FROM history";
    Map<Integer, Integer> prodId = new HashMap<>();
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            
            int prod = resultSet.getInt("prodId");

            prodId.put(prod, prodId.getOrDefault(prod, 0) + 1);
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return prodId;
    
    }
}
