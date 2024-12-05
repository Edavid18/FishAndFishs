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

/**
 *
 * @author eliasvidal
 */
public class AdminModel {
    
    public ArrayList<String[]> iterateThroughTable() {
    Connection connection = Conexion.getInstance().Connection();
    String query = "SELECT * FROM products";
    ArrayList<String[]> products = new ArrayList();
    String[] info = new String[4];
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            info = new String[4];
            
            info[0] = resultSet.getString("prodId");
            info[1] = resultSet.getString("name"); 
            info[2] = resultSet.getString("price");
            info[3] = resultSet.getString("route");
            
            products.add(info);
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return products;
}
    
}
