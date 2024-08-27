/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurant;

import javax.swing.JOptionPane;

public class Menú {
     String platos[]; 
    int datos[][];
    String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    
    public void crearMenu(int cantidad){
        platos = new String[cantidad];
        
        int i = 0;
        
        while(i<cantidad){
            platos[i] = JOptionPane.showInputDialog("Ingrese el nombre del plato "+ (i+1) +":");
            i++;
        }
    }
    
    public void consultarMenu(){
        
        String plato = "";
        for (String plato1 : platos) {
            plato += plato1 + ",";
            plato += "\n";
        }
        JOptionPane.showMessageDialog(null, "Platos :" +plato);
    }
    
    public void ingresarDatos(){
        datos = new int[6][platos.length];
        for (int f = 0; f < 6; f++) {
            for (int c = 0; c < platos.length; c++) {
                datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Ventas para el dia "+dias[f]+" de "+platos[c]+": "));
            }
        }
    }
    public void platosVendidosALaSemana(){
        int total = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < platos.length; j++) {
                total += datos[i][j];
            }
        }
        JOptionPane.showMessageDialog(null, "El total de platos vendidos en la semana es de: "+ total);
    }
    
    public void totalVendidosDeCadaPlato(){
    for (int j = 0; j < platos.length; j++) {
        int platoVendido = 0;
        for (int i = 0; i < 6; i++) {
            platoVendido += datos[i][j];
        }
        JOptionPane.showMessageDialog(null, "Plato " + (j + 1) + ": " + platoVendido);
    }
    }
    
    public void diaMasVendidoParaCadaPlato() {
       
        for (int i = 0; i < platos.length; i++) {
             int pivote = datos[0][i];
             String diaMasVendido = dias[0];
            for (int j = 1; j < dias.length; j++) {
               if(datos[j][i]>pivote){
                 pivote = datos[j][i];
                 diaMasVendido = dias[j];
               }
            }
             JOptionPane.showMessageDialog(null, "El día en el que más se vendió el plato " + (i + 1) + " fue el: " + diaMasVendido);
        }
}
    public void diaMenosVendidoParaCadaPlato(){
         for (int i = 0; i < platos.length; i++) {
             int pivote = datos[0][i];
             String diaMasVendido = dias[0];
            for (int j = 1; j < dias.length; j++) {
               if(datos[j][i]<pivote){
                 pivote = datos[j][i];
                 diaMasVendido = dias[j];
               }
            }
             JOptionPane.showMessageDialog(null, "El día en el que menos se vendió el plato " + (i + 1) + " fue el: " + diaMasVendido);
        }
    }
    public void diaDeLaSemanaQueMasYMenosSeVende(){
       int[] totalVentasPorDia = new int[dias.length]; 

    for (int i = 0; i < dias.length; i++) {
        for (int j = 0; j < platos.length; j++) {
            totalVentasPorDia[i] += datos[i][j];
        }
    }

    int maxVentas = totalVentasPorDia[0];
    int minVentas = totalVentasPorDia[0];
    String diaMasVendido = dias[0];
    String diaMenosVendido = dias[0];

    for (int i = 0; i < dias.length; i++) {
        if (totalVentasPorDia[i] > maxVentas) {
            maxVentas = totalVentasPorDia[i];
            diaMasVendido = dias[i];
        }
        if (totalVentasPorDia[i] < minVentas) {
            minVentas = totalVentasPorDia[i];
            diaMenosVendido = dias[i];
        }
    }
    JOptionPane.showMessageDialog(null, "El día en el que más se venden platos es el: " + diaMasVendido);
    JOptionPane.showMessageDialog(null, "El día en el que menos se venden platos es el: " + diaMenosVendido);
    }
    
    public void promedioDePlatosVendidosALaSemana(){
        int total = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < platos.length; j++) {
                total += datos[i][j];
            }
        }
        JOptionPane.showMessageDialog(null, "El promedio de platos vendidos en la semana es de: "+ total/dias.length);
    }
    
    public void promedioDePlatosVendidosCadaDia(){
        for (int i = 0; i < dias.length; i++) {
            int suma = 0;
            for (int j = 0; j < platos.length; j++) {
                suma += datos[i][j];
            }
            JOptionPane.showMessageDialog(null,"El promedio de platos vendidos el dia "+dias[i]+ " es de: " +suma/platos.length);
        }
    }
    public void totalDePlatosVendidosCadaDia(){
        for (int i = 0; i < dias.length; i++) {
            int suma = 0;
            for (int j = 0; j < platos.length; j++) {
                suma += datos[i][j];
            }
            JOptionPane.showMessageDialog(null,"El total de platos vendidos el dia "+dias[i]+ " es de: " +suma);
        }
    }
}
