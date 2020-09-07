package lab3paradigmas;

import java.util.ArrayList;
import java.util.Scanner;

public class Workspace {
   //Atributos
    ArrayList<Archivo> archivos;
    
    //Constructor
    public Workspace(){
        this.archivos = new ArrayList();
    }
    
    //Metodos
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
    
    public void addArchivo(){
        Archivo arch = new Archivo();
        this.archivos.add(arch);
    }
    
    
    public int posNombreArchivo(String archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).nombre.equals(archivo)){
                return i;
            }
        }
        return -1;
    }
    
    public boolean verificarArchivo(Archivo archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).equals(archivo)){
                return true;
            }
        }
        return false;
    }
    
}
