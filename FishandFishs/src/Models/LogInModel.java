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
import java.sql.Statement;
import userSession.UserSession;

/**
 *
 * @author eliasvidal
 */
public class LogInModel {
    
    public boolean logInUser(String us, String pw){
        try{
            Conexion cx = Conexion.getInstance();

            String query="SELECT * FROM user WHERE user='"+us+"' and password='"+pw+"'" ;
            Statement st = cx.Connection().createStatement ();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                UserSession.getInstance(getUserDetails(us, pw), us);
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            
        }
        return false;
    }
    
    public String[] getUserDetails(String username, String password) {
    Connection connection = Conexion.getInstance().Connection();
    String[] details = new String[3];

    String query = "SELECT userid, name, number FROM user WHERE user = ? AND password = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, username); // Set username in the query
        preparedStatement.setString(2, password); // Set password in the query
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            details[0] = resultSet.getString("userid");
            details[1] = resultSet.getString("name");
            details[2] = resultSet.getString("number");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return details; // Return the User object
    }
    
    public int getUserId(String username, String password) {
        int userId = -1;  // Default value if no user is found
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Conexion conexion = Conexion.getInstance();
            connection = conexion.Connection();

            String query = "SELECT userid FROM user WHERE user = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("userID");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userId;
    }
}
