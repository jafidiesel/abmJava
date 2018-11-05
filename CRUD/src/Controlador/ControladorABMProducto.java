/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta;
import Modelo.Criterio;
import java.util.ArrayList;

/**
 *
 * @author jafidiesel
 */
public class ControladorABMProducto {
    Consulta consultaProducto;
    ArrayList<Criterio> arraylist;
    
    
    public boolean agregarProducto ( int codigo, String nombre, int precio, int cantidad){
        consultaProducto = new Consulta();
        arraylist = new ArrayList<>();
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
        arraylist.add(c1);
        
        
        //Nombre
        c2.setAtributo("nombre");
        c2.setOperacion("=");
        c2.setValor( nombre );
        c2.setTipo("String");
        arraylist.add(c2);
        
        
        //Precio
        c3.setAtributo("precio");
        c3.setOperacion("=");
        c3.setValor( String.valueOf( precio ) );
        c3.setTipo("int");
        arraylist.add(c3);
        
        //Cantidad
        c4.setAtributo("cantidad");
        c4.setOperacion("=");
        c4.setValor( String.valueOf( cantidad ) );
        c4.setTipo("int");
        arraylist.add(c4);
        
        try{
            result = consultaProducto.guardar("producto", arraylist);
        } catch( Exception e ){
            return false;
        }
        
        return result;
        
    }
    
}
