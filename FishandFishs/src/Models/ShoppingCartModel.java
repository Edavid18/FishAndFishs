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
public class ShoppingCartModel {

    public ArrayList<Integer> getProdID(int userId) {
        Connection connection = Conexion.getInstance().Connection();
        ArrayList<Integer> prodID = new ArrayList();

        String query = "SELECT prodId FROM shoppingList WHERE userId = ?";
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

        String query = "SELECT amount, orderId FROM shoppingList WHERE userId = ? AND prodId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, prodId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                amount[0] = resultSet.getString("amount");
                amount[1] = resultSet.getString("orderId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amount;
    }
    
    public int TableSize() {
        Connection connection = Conexion.getInstance().Connection();
        String query = "SELECT COUNT(*) FROM shoppingList";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                return rowCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
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
}
