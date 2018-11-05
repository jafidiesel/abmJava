/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jafidiesel
 */
public class Consulta {
    PreparedStatement ps = null;
    Connection connection;
    Conexion conexion;
        
    public boolean guardar( String objetoAGuardar, ArrayList<Criterio> arrayListCriterios){
        conexion = new Conexion();
        connection = conexion.getConexion();
        
        String sql;
        String campos = "";
        String valores = "";
        
        
        sql = "INSERT INTO " + objetoAGuardar;
        
        int index = 0;
        for ( Criterio elemento : arrayListCriterios){
            System.out.println(index);
            String comillas = "";
            if( elemento.getTipo() == "String"){
                comillas = "'";
            }
            
            if( index == 0 ){
                campos = " (" + elemento.getAtributo() + ",";
                valores = " VALUES (" + comillas + elemento.getValor() + comillas + ",";
            } else if ( index == (arrayListCriterios.size() -1) ){
                campos = campos + elemento.getAtributo() + ")";
                valores = valores+ comillas + elemento.getValor() + comillas + ")";
            } else{
                campos = campos + elemento.getAtributo() + ",";
                valores = valores + comillas + elemento.getValor() + comillas + ",";
            }
            
            index++;
        }
        
        sql = sql + campos + valores;
        
        try{
            System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.execute();
            return true;
            
        }catch( SQLException e ){
            
            System.err.println(e);
            System.out.println("Consulta.java");
            return false;
            
        }finally{
            try {
                
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
    }
    
}
