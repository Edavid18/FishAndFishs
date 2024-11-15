/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DataBase.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author eliasvidal
 */
public class SignUpModel {
    
    
    
    public boolean signUpUser(String user, String password, String name, String number) {
        Conexion conexion = Conexion.getInstance();
        Connection conn = conexion.Connection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO user (user, password, name, number) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.setString(3, name);
            stmt.setString(4, number); // In a real application, password should be hashed!

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
