package lab3paradigmas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


class Archivo {
    //Atributos
    String nombre;
    String fecha;
    String contenido;
    
    //Constructor
    public Archivo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el contenido del archivo:");
        String autor = input.nextLine();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        this.nombre = nombre;
        this.fecha = df.format(fechaActual);
        this.contenido = contenido;
    }
     
    //Metodos
    public String toString(){
        //String output = "Nombre: " + this.nombre + ", Fecha: " + this.fecha + ", Contenido: " + this.contenido;
        String output = this.nombre;
        return output;
    }
    
}
