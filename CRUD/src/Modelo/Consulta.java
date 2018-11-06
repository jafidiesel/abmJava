/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

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
            ps = connection.prepareStatement(sql);
            ps.execute();
            return true;
            
        }catch( SQLException e ){
            
            System.err.println(e);
            return false;
            
        }finally{
            try {
                
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
    }
    
    public DTOBusqueda buscar ( String objetoABuscar,Criterio criterio ){
        conexion = new Conexion();
        connection = conexion.getConexion();
        ResultSet rs = null;


        DTOBusqueda dto = new DTOBusqueda();
       
        String sql = "SELECT * FROM " + objetoABuscar + " WHERE " + criterio.getAtributo() + " = " + criterio.getValor();
        System.out.println(sql);
        
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    
                    dto.addAtributo(rsmd.getColumnName(i));
                    dto.addValor(rs.getString(i));
                }
            }
            
        }catch( SQLException e ){
            
            System.err.println(e);
            
        }finally{
            try {
                
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return dto;
        
    }

    public boolean actualizar ( String objetoAActualizar, ArrayList<Criterio> arrayListCriterios ){
        conexion = new Conexion();
        connection = conexion.getConexion();
        
        String sql;
        String campos = "";
        String valores = "";
        
        sql = "UPDATE "+ objetoAActualizar + " SET ";
        
        int index = 0;
        for ( Criterio elemento : arrayListCriterios){
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
            ps = connection.prepareStatement(sql);
            ps.execute();
            return true;
            
        }catch( SQLException e ){
            
            System.err.println(e);
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

    