//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0
package lab3paradigmas;

import java.util.ArrayList;
import java.util.Scanner;

/**
* Clase para representar un zona workspace,
* determinada por archivos
* @version 1.8
* @author Maria Jesus Canoles
*/
public class Workspace {
   //Atributos
    ArrayList<Archivo> archivos;
    
    //Constructor
    /**
     * @param archivos archivos contenidos en la zona workspace
     */
    public Workspace(){
        this.archivos = new ArrayList();
    }
    
    //Metodos
    /**
     * metodo que genera un string con el contenido del workspace
     * @return nombre del archivo
     */
    public String toString(){
        String output = "";
        if (this.archivos.isEmpty()){
            output = output + "Sin contenido en el Workspace";
        }
        else{
            for(int i=0;i<this.archivos.size(); i++){
                if(i+1 == this.archivos.size()){
                    output = output + this.archivos.get(i);
                }
                else{
                    output = output + this.archivos.get(i) + " +- ";
                }
            }
        }
        return output;
    }
    
    /**
     * metodo que agrega un archivo al workspace
     * @return workspace con un archivo agregado
     */
    public void addArchivo(){
        Archivo arch = new Archivo();
        this.archivos.add(arch);
    }
    
    /**
     * metodo que entrega la posicion de un archivo en el workspace a partir de un string con el nombre de un archivo
     * @param archivo nombre de un archivo
     * @return posicion del archivo, si es -1 es porque no se encontro
     */
    public int posNombreArchivo(String archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).nombre.equals(archivo)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * metodo que verifica si un archivo se encuentra en el workspace
     * @param archivo archivo
     * @return boolean que indica true si se encuentra el archivo en el workspace, false en caso contrario
     */
    public boolean verificarArchivo(Archivo archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).equals(archivo)){
                return true;
            }
        }
        return false;
    }
    
}
