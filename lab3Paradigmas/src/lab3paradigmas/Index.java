//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0
package lab3paradigmas;

import java.util.ArrayList;
import java.util.Scanner;

/**
* Clase para representar una zona index,
* determinada por archivos
* @version 1.8
* @author Maria Jesus Canoles
*/
public class Index {
    //Atributos
    ArrayList<Archivo> archivos; 
    
    //Constructor
    /**
     * @param archivos archivos contenidos en la zona index
     */
    public Index(){
        this.archivos = new ArrayList();
    }
    
    //Metodos
    /**
     * metodo que genera un string con el contenido del index
     * @return contenido del index
     */
    public String toString(){
        String output = "";
        if (this.archivos.isEmpty()){
            output = output + "Sin contenido en el Index";
        }
        else{
            for(int i=0;i<this.archivos.size(); i++){
                if(i+1 == this.archivos.size()){
                    output = output + this.archivos.get(i);
                }
                else{
                    output = output + this.archivos.get(i) + " -- ";
                }
            }
        }
        return output;
    }
    
}
