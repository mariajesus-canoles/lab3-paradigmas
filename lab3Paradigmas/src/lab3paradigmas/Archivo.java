package lab3paradigmas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


class Archivo {
    //Atributos
    String nombre;
    String fecha;
    String contenido;
    
    //Constructor
    public Archivo(String nombre, String contenido){
        this.nombre = nombre;
        this.fecha = obtenerFecha();
        this.contenido = contenido;
    }
     
    //Metodos
    public String toString(){
        String output = "Nombre: " + this.nombre + ", Fecha: " + this.fecha + ", Contenido: " + this.contenido;
        return output;
    }
    
    public String obtenerFecha(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
    
}
