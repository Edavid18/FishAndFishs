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

/**
 *
 * @author eliasvidal
 */
public class CatalogueModel {
    
    public String[] getProductDetail(String keyword) {
    Connection connection = Conexion.getInstance().Connection();
    String[] details = new String[4];

    String query = "SELECT name, price, prodId, route FROM products WHERE keyword = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, keyword);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            details[0] = resultSet.getString("name");
            details[1] = resultSet.getString("price");
            details[2] = resultSet.getString("prodId");
            details[3] = resultSet.getString("route");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return details;
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
}
