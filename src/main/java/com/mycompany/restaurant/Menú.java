
package com.mycompany.restaurant;

import javax.swing.JOptionPane;

public class Menú {
    Platos platos[];
    int datos[][];
    String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    
    public void crearMenu(int cantidad){
       platos = new Platos[cantidad]; 
        
        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del plato");
            int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del plato"));
            platos[i] = new Platos(nombre, precio);
        }
        
        
    }
    
    public void consultarMenu(){
        
        String menu = "";
        for (Platos plato : platos) {
            menu += plato.getName();
            menu += "\n";
        }
        JOptionPane.showMessageDialog(null, "Menu : \n" +menu);
    }
    
    public void ingresarDatos(){
        datos = new int[dias.length][platos.length];
        for (int f = 0; f < dias.length; f++) {
            for (int c = 0; c < platos.length; c++) {
                datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Ventas para el dia "+dias[f]+" de "+platos[c].getName()+": "));
            }
        }
    }
    public String platosVendidosALaSemana(){
        String message ;
        int total = 0;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < platos.length; j++) {
                total += datos[i][j];
            }
        }
        int totalRecaudado = 0;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < platos.length; j++) {
                totalRecaudado += platos[j].getPrice() * datos[i][j];
            }
        }
      return message =  "El total de platos vendidos en la semana es de: "+ total +" y se recaudaron en total: "+totalRecaudado;
       
    }
    
    public String totalVendidosDeCadaPlato(){
    String message = "";
    for (int j = 0; j < platos.length; j++) {
        int totalRecaudadoPorPlato = 0;
        int platoVendido = 0;
        for (int i = 0; i < dias.length; i++) {
            platoVendido += datos[i][j];
            totalRecaudadoPorPlato += platos[j].getPrice() * datos[i][j];
        }
         message +=  "Se vendieron del plato de " + platos[j].getName() + ": " + platoVendido +" platos" +" y se recaudaron: "+totalRecaudadoPorPlato +"\n";
    }
    return message;
    }
    
    public String diaMasVendidoParaCadaPlato() {
    String message = "";
        for (int i = 0; i < platos.length; i++) {
             int pivote = datos[0][i];
             String diaMasVendido = dias[0];
            for (int j = 1; j < dias.length; j++) {
               if(datos[j][i]>pivote){
                 pivote = datos[j][i];
                 diaMasVendido = dias[j];
               }
            }
            message +=  "El día en el que más se vendió el plato " + platos[i].getName() + " fue el: " + diaMasVendido +"\n";
        }
        return message;
}
    public String diaMenosVendidoParaCadaPlato(){
        String message = "";
         for (int i = 0; i < platos.length; i++) {
             int pivote = datos[0][i];
             String diaMasVendido = dias[0];
            for (int j = 1; j < dias.length; j++) {
               if(datos[j][i]<pivote){
                 pivote = datos[j][i];
                 diaMasVendido = dias[j];
               }
            }
              message += "El día en el que menos se vendió el plato " + platos[i].getName() + " fue el: " + diaMasVendido +"\n";
        }
        return message;
    }
    public String diaDeLaSemanaQueMasYMenosSeVende(){
        String message = "";
       int[] totalVentasPorDia = new int[dias.length]; 
       int[] totalRecaudadoPorDia = new int[dias.length];
    for (int i = 0; i < dias.length; i++) {
        for (int j = 0; j < platos.length; j++) {
            totalVentasPorDia[i] += datos[i][j];
            totalRecaudadoPorDia[i] += datos[i][j] * platos[j].getPrice();
        }
    }
    int maxVentas = totalRecaudadoPorDia[0];
    int minVentas = totalRecaudadoPorDia[0];
    int maxPlatos = totalVentasPorDia[0];
    int minPlatos = totalVentasPorDia[0];
    String diaMasVendido = dias[0];
    String diaMenosVendido = dias[0];

    for (int i = 0; i < dias.length; i++) {
        if (totalVentasPorDia[i] > maxPlatos) {
            maxPlatos = totalVentasPorDia[i];
            diaMasVendido = dias[i];
        }
        if (totalVentasPorDia[i] < minPlatos) {
            minPlatos = totalVentasPorDia[i];
            diaMenosVendido = dias[i];
        }
    }
    message += "El día en el que más se venden platos es el: " + diaMasVendido +" con "+maxPlatos +"\n";
    message += "El día en el que menos se venden platos es el: " + diaMenosVendido + "con "+minPlatos +"\n";
    
    
    for (int i = 0; i < dias.length; i++) {
        if(totalRecaudadoPorDia[i] >maxVentas){
            maxVentas = totalRecaudadoPorDia[i];
            diaMasVendido = dias[i];
        }    
         if(totalRecaudadoPorDia[i] <minVentas){
            minVentas = totalRecaudadoPorDia[i];
            diaMenosVendido = dias[i];
        }    
        }
    message += "El día en el que más se vende es el: " + diaMasVendido +" donde se recaudo "+maxVentas +"\n";
    message += "El día en el que menos se vende es el: " + diaMenosVendido +" donde se recaudo "+minVentas;
    return message;
    }
    
    public String promedioDePlatosVendidosALaSemana(){
        String message;
        int total = 0;
        int promedio = 0;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < platos.length; j++) {
                total += datos[i][j];
                promedio += platos[j].getPrice() * datos[i][j];
            }
        }
        
       return message = "El promedio de platos vendidos en la semana es de: "+ total/dias.length +" Y el promedio recaudado en la semana es de: "+promedio/dias.length;
    }
    
    public String promedioDePlatosVendidosCadaDia(){
        String message = "";
        for (int i = 0; i < dias.length; i++) {
            int suma = 0;
            int promedioCadaDia = 0;
            for (int j = 0; j < platos.length; j++) {
                suma += datos[i][j];
                promedioCadaDia += platos[j].getPrice() * datos[i][j];
            }
            message += "El promedio de platos vendidos el dia "+dias[i]+ " es de: " +suma/platos.length +" y se recaudo ese día "+promedioCadaDia +"\n";
        }
        return message;
    }
    public String totalDePlatosVendidosCadaDia(){
        String message = "";
        for (int i = 0; i < dias.length; i++) {
            int suma = 0;
            int totalDeCadaDia = 0;
            for (int j = 0; j < platos.length; j++) {
                totalDeCadaDia +=  datos[i][j]*platos[j].getPrice();
                suma += datos[i][j];
            }
            message += "El total de platos vendidos el dia "+dias[i]+ " es de: " +suma +" y se recaudaron : "+totalDeCadaDia +"\n";
        }
        return message;
    }
}
