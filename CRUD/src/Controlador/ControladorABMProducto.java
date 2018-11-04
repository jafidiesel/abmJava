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
        
        Criterio c1 = new Criterio();
        Criterio c2 = new Criterio();
        Criterio c3 = new Criterio();
        Criterio c4 = new Criterio();
        
        //Codigo
        c1.setAtributo("codigo");
        c1.setOperacion("=");
        c1.setValor( String.valueOf( codigo ) );
        arraylist.add(c1);
        
        
        //Nombre
        c2.setAtributo("nombre");
        c2.setOperacion("=");
        c2.setValor( nombre );
        arraylist.add(c2);
        
        
        //Precio
        c3.setAtributo("precio");
        c3.setOperacion("=");
        c3.setValor( String.valueOf( precio ) );
        arraylist.add(c3);
        
        //Cantidad
        c1.setAtributo("cantidad");
        c1.setOperacion("=");
        c1.setValor( String.valueOf( cantidad ) );
        arraylist.add(c4);
        
        try{
            result = consultaProducto.guardar("Producto", arraylist);
        } catch( Exception e ){
            return false;
        }
        
        return result;
        
    }
    
}
