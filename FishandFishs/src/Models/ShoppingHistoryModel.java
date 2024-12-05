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
public class ShoppingHistoryModel {
    
    String lastOrderId = "";
    
    public ArrayList<Integer> getProdID(int userId) {
        Connection connection = Conexion.getInstance().Connection();
        ArrayList<Integer> prodID = new ArrayList();

        String query = "SELECT prodId FROM history WHERE userId = ?";
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
    
    public ArrayList<String[]> getProductAmount(int userId) {
        Connection connection = Conexion.getInstance().Connection();
        ArrayList<String[]> details = new ArrayList();

        String query = "SELECT * FROM history";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            // Retrieve row data
            int dbUserId = resultSet.getInt("userId");
            if (dbUserId == userId) { // Check if the userId matches
                    String[] rowDetails = new String[4];
                    rowDetails[0] = resultSet.getString("userId");
                    rowDetails[1] = resultSet.getString("orderId");
                    rowDetails[2] = resultSet.getString("prodId");
                    rowDetails[3] = resultSet.getString("amount");
                    details.add(rowDetails);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }
    
    public void setLastOID(String lastOrderId){
        this.lastOrderId = lastOrderId;
    }
}
