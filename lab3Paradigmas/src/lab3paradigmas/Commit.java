package lab3paradigmas;

import java.util.ArrayList;

public class Commit {
    //Atributos
    String rama;
    String mensaje;
    ArrayList<Archivo> archivos; 
    
    //Constructor
    public Commit(String rama, String mensaje, ArrayList<Archivo> archivos){
        this.rama = rama;
        this.mensaje = mensaje;
        this.archivos = archivos;
    }
    
    //Metodos
    public String toString(){
        String output = "Rama: " + this.rama + ", Mensaje: " + this.mensaje + ", Archivos: ";
        for(int i=0;i<this.archivos.size(); i++){
                if(i+1 == this.archivos.size()){
                    output = output + this.archivos.get(i);
                }
                else{
                    output = output + this.archivos.get(i) + ", ";
                }
        }
        return output;
    }
    
}
