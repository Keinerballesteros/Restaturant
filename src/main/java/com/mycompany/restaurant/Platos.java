/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant;

public class Platos {
    private  String nombre;
    private  int precio;
    private int costo;

    public Platos(String nombre, int precio, int costo) {
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCosto() {
        return costo;
    }
    
    
    
    
}
