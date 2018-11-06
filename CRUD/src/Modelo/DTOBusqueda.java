/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jafidiesel
 */
public class DTOBusqueda {
    private ArrayList<String> atributo = new ArrayList<>();
    private ArrayList<String> valor = new ArrayList<>();

    public String getAtributo(int index) {
        return atributo.get(index);
    }

    public void addAtributo(String atributo) {
        this.atributo.add(atributo);
    }

    public ArrayList<String> getAtributos(){
        return this.atributo;
    }
    
    public String getValor(int index) {
        return valor.get(index);
    }

    public void addValor(String valor) {
        this.valor.add(valor);
    }

    public ArrayList<String> getValores(){
        return this.valor;
    }    
    
}
