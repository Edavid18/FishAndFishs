/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userSession;

import DataBase.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eliasvidal
 */
public class UserSession {
    private static UserSession instance; 
    private static int userId;
    private static String user;
    private static String name;
    private static String phone;

    private UserSession(String[] details, String user) { 
        UserSession.user = user;
        UserSession.userId = Integer.parseInt(details[0]);
        UserSession.name = details[1];
        UserSession.phone = details[2];
    }

    public static UserSession setInstance(String[] details, String user) {
        if (instance == null) {
            instance = new UserSession(details, user);
        }
        return instance;
    }

    public static void setUserId(int userId) {
        UserSession.userId = userId;
    }

    public static void setUser(String user) {
        UserSession.user = user;
    }

    public static void setName(String name) {
        UserSession.name = name;
    }

    public static void setPhone(String phone) {
        UserSession.phone = phone;
    }
    
    public static int getUserId() {
        return userId;
    }
    
    public static String getName() {
        return name;
    }

    public static String getUser() {
        return user;
    }

    public static String getPhone() {
        return phone;
    }
    

    public static void logout() {
        instance = null;
    }
}

