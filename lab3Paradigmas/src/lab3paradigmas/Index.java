package lab3paradigmas;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {
    //Atributos
    ArrayList<Archivo> archivos; 
    
    //Constructor
    public Index(){
        this.archivos = new ArrayList();
    }
    
    //Metodos
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
