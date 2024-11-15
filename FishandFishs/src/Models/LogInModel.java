/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DataBase.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eliasvidal
 */
public class LogInModel {
    
    public boolean logInUser(String us, String pw){
        try{
            Conexion cx = new Conexion();

            String query="SELECT * FROM user WHERE user='"+us+"' and password='"+pw+"'" ;
            Statement st = cx.Connection().createStatement ();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            
        }
        return false;
    }
}
