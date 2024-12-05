/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

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
public class Total implements ITotal{

    ArrayList<Integer> prodId;
    
    public Total(ArrayList<Integer> prodId){
        this.prodId = prodId;
    }
    
    @Override
    public double total() {
        double price = 0;
        for (int i = 0; i < prodId.size(); i++) {
            price = price + getProductDetail(prodId.get(i));
        }
        return price;
    }
    
    public double getProductDetail(int prodId) {
    Connection connection = Conexion.getInstance().Connection();
    double price = 0;

    String query = "SELECT price FROM products WHERE prodId = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, prodId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            price = (Double.parseDouble(resultSet.getString("price")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return price;
    }
    
}
