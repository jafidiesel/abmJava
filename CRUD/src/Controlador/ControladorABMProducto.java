/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta;
import Modelo.Criterio;
import Modelo.DTOBusqueda;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jafidiesel
 */
public class ControladorABMProducto {
    Consulta consultaProducto;
    ArrayList<Criterio> arraylistCriterios;
    DTOBusqueda dtoRecibido;
    DTOBusqueda dtoEnviado;
    
    
    public boolean agregarProducto ( int codigo, String nombre, int precio, int cantidad){
        consultaProducto = new Consulta();
        arraylistCriterios = new ArrayList<>();
        boolean result;
        
        Criterio c1 = new Criterio();
        Criterio c2 = new Criterio();
        Criterio c3 = new Criterio();
        Criterio c4 = new Criterio();
        
        //Codigo
        c1.setAtributo("codigo");
        c1.setOperacion("=");
        c1.setValor( String.valueOf( codigo ) );
        c1.setTipo("int");
        arraylistCriterios.add(c1);
        
        
        //Nombre
        c2.setAtributo("nombre");
        c2.setOperacion("=");
        c2.setValor( nombre );
        c2.setTipo("String");
        arraylistCriterios.add(c2);
        
        
        //Precio
        c3.setAtributo("precio");
        c3.setOperacion("=");
        c3.setValor( String.valueOf( precio ) );
        c3.setTipo("int");
        arraylistCriterios.add(c3);
        
        //Cantidad
        c4.setAtributo("cantidad");
        c4.setOperacion("=");
        c4.setValor( String.valueOf( cantidad ) );
        c4.setTipo("int");
        arraylistCriterios.add(c4);
        
        try{
            result = consultaProducto.guardar("producto", arraylistCriterios);
        } catch( Exception e ){
            return false;
        }
        
        return result;
        
    }
    
    
    public DTOBusqueda buscarProductoPorId ( int codigo ){
        Criterio c1 = new Criterio();
        consultaProducto = new Consulta();
        dtoRecibido = new DTOBusqueda();
        dtoEnviado = new DTOBusqueda();
        
        c1.setAtributo("codigo");
        c1.setValor(String.valueOf(codigo));
        
        dtoRecibido = consultaProducto.buscar("producto", c1);
        
        Producto prod = new Producto();
        
        ArrayList<String> arrayAtributos = dtoRecibido.getAtributos();
        ArrayList<String> arrayValores = dtoRecibido.getValores();
        
        for( int i=0; i< arrayAtributos.size(); i++ ){
            dtoEnviado.addAtributo(dtoRecibido.getAtributo(i));
            dtoEnviado.addValor(dtoRecibido.getValor(i));
        }
        
        
        return dtoEnviado;
    }


    public boolean actualizarProducto ( int id, int codigo, String nombre, int precio, int cantidad){
        consultaProducto = new Consulta();
        arraylistCriterios = new ArrayList<>();
        boolean result;
        
        Criterio c0 = new Criterio();
        Criterio c1 = new Criterio();
        Criterio c2 = new Criterio();
        Criterio c3 = new Criterio();
        Criterio c4 = new Criterio();
        
        //Id
        c0.setAtributo("id");
        c0.setOperacion("=");
        c0.setValor( String.valueOf( id ) );
        c0.setTipo("int");
        arraylistCriterios.add(c0);
        
        //Codigo
        c1.setAtributo("codigo");
        c1.setOperacion("=");
        c1.setValor( String.valueOf( codigo ) );
        c1.setTipo("int");
        arraylistCriterios.add(c1);
        
        
        //Nombre
        c2.setAtributo("nombre");
        c2.setOperacion("=");
        c2.setValor( nombre );
        c2.setTipo("String");
        arraylistCriterios.add(c2);
        
        
        //Precio
        c3.setAtributo("precio");
        c3.setOperacion("=");
        c3.setValor( String.valueOf( precio ) );
        c3.setTipo("int");
        arraylistCriterios.add(c3);
        
        //Cantidad
        c4.setAtributo("cantidad");
        c4.setOperacion("=");
        c4.setValor( String.valueOf( cantidad ) );
        c4.setTipo("int");
        arraylistCriterios.add(c4);
        
        try{
            result = consultaProducto.actualizar("producto", arraylistCriterios);
        } catch (Exception e){
            System.err.println(e);
            result = false;
        }
        
        return result;
    }
    
}