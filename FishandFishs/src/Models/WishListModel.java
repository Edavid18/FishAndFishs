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
public class WishListModel {
    public ArrayList<Integer> getProdID(int userId) {
        Connection connection = Conexion.getInstance().Connection();
        ArrayList<Integer> prodID = new ArrayList();

        String query = "SELECT prodId FROM wishList WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                prodID.add(resultSet.getInt("prodId"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodID;
    }
    
    public String[] getProductDetail(int prodId) {
        Connection connection = Conexion.getInstance().Connection();
        String[] details = new String[3];

        String query = "SELECT name, price, route FROM products WHERE prodId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, prodId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                details[0] = resultSet.getString("name");
                details[1] = resultSet.getString("price");
                details[2] = resultSet.getString("route");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    public String[] getProductAmount(int prodId, int userId) {
        Connection connection = Conexion.getInstance().Connection();
        String[] amount = new String[2];

        String query = "SELECT amount, wishId FROM wishList WHERE userId = ? AND prodId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, prodId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                amount[0] = resultSet.getString("amount");
                amount[1] = resultSet.getString("wishId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amount;
    }
    
    public void addProductShoppingList(int userId, int prodId, String amount){
        Conexion conexion = Conexion.getInstance();
        Connection conn = conexion.Connection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO shoppingList (userId, prodId, amount) VALUES (?, ?, ?)";
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
    
    public void addProductWishList(int userId, int prodId, String amount){
        Conexion conexion = Conexion.getInstance();
        Connection conn = conexion.Connection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO wishList (userId, prodId, amount) VALUES (?, ?, ?)";
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
    
    public void deleteOrder(int orderId){
        Connection connection = Conexion.getInstance().Connection();
        String query = "DELETE FROM wishList WHERE wishId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the userId and prodId in the query
            preparedStatement.setInt(1, orderId);
            // Execute the query to delete the row
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product removed from wish list.");
            } else {
                System.out.println("No product found to remove.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
