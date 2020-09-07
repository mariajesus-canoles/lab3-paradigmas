//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0
package lab3paradigmas;

import java.util.ArrayList;

/**
* Clase para representar un commit,
* determinada por un rama, mensaje y archivos
* @version 1.8
* @author Maria Jesus Canoles
*/
public class Commit {
    //Atributos
    String rama;
    String mensaje;
    ArrayList<Archivo> archivos; 
    
    //Constructor
    /**
     * @param rama rama en la cual el repositorio trabaja
     * @param mensaje mensaje descriptivo del commit
     * @param archivos archivos contenidos en el commit
     */
    public Commit(String rama, String mensaje, ArrayList<Archivo> archivos){
        this.rama = rama;
        this.mensaje = mensaje;
        this.archivos = archivos;
    }
    
    //Metodos
    /**
     * metodo que genera un string con el contenido del commit
     * @return nombre del archivo
     */
    public String toString(){
        String output = "Rama: " + this.rama + ", Mensaje: " + this.mensaje + ", Archivos: ";
        for(int i=0;i<this.archivos.size(); i++){
                if(i+1 == this.archivos.size()){
                    output = output + this.archivos.get(i);
                }
                else{
                    output = output + this.archivos.get(i) + " - ";
                }
        }
        return output;
    }
    
}
