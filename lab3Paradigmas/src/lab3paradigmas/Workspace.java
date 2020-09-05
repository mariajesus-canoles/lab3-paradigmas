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
                output = output + this.archivos.get(i) + ", ";
            }
        }
        return output;
    }
    
    public void addArchivo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el contenido del archivo:");
        String autor = input.nextLine();
        Archivo arch = new Archivo(nombre, autor);
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
