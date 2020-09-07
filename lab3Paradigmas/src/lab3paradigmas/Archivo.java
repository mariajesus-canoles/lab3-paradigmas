//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0

package lab3paradigmas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
* Clase para representar un archivo de texto plano,
* determinada por un nombre, fecha y contenido
* @version 1.8
* @author Maria Jesus Canoles
*/
class Archivo {
    //Atributos
    String nombre;
    String fecha;
    String contenido;
    
    //Constructor
    /**
     * @param nombre nombre del archivo
     * @param fecha fecha actual
     * @param contenido contenido del archivo
     */
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
    /**
     * metodo que genera un string con el nombre del archivo
     * @return nombre del archivo
     */
    public String toString(){
        //String output = "Nombre: " + this.nombre + ", Fecha: " + this.fecha + ", Contenido: " + this.contenido;
        String output = this.nombre;
        return output;
    }
    
}
