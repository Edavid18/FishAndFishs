/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DataBase.Conexion;
import Decorator.ITotal;
import Decorator.Total;
import Decorator.discount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eliasvidal
 */
public class CheckoutModel {
    
    public double getTotal(ArrayList<Integer> prodId, String discCode){
        ITotal total = new Total(prodId);
        if (addDesc(discCode)) {
            total = new discount(total);
            return total.total();
        } else{
            return total.total();
        }
    }
    
    public boolean addDesc(String discCode){
        return discCode.equals("JESUS");
    }
    
    public double getSubTotal(ArrayList<Integer> prodId){
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
    
    public int getProductOrderId(int prodId, int userId) {
    Connection connection = Conexion.getInstance().Connection();
    int order = 0;

    String query = "SELECT orderId FROM products WHERE prodId = ? AND userId = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, prodId);
        preparedStatement.setInt(2, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            order = (resultSet.getInt("orderId"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return order;
    }
    
    public void deleteOrder(int orderId){
        Connection connection = Conexion.getInstance().Connection();
        String query = "DELETE FROM shoppingList WHERE orderId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the userId and prodId in the query
            preparedStatement.setInt(1, orderId);
            // Execute the query to delete the row
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product removed from shopping list.");
            } else {
                System.out.println("No product found to remove.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addProductHistory(int userId, int prodId, String amount){
        Conexion conexion = Conexion.getInstance();
        Connection conn = conexion.Connection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO history (userId, prodId, amount) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, prodId);
            stmt.setString(3, amount);

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
