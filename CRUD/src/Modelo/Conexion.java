/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jafidiesel
 */
public class Conexion {
    
    private final String base = "tienda?serverTimezone=GMT";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection connection = null;
    
    public Connection getConexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e){
            System.err.println(e);
        } catch(ClassNotFoundException e2){
            System.err.println(e2);
        }
    
    return connection;
    }
    
    
}
