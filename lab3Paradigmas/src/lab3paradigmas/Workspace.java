
package lab3paradigmas;

import java.util.ArrayList;

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
                output = output + this.archivos.get(i) + "\n";
            }
        }
        return output;
    }
    
    public void addArchivo(String nombreArch, String autorArch){
        Archivo arch = new Archivo(nombreArch, autorArch);
        this.archivos.add(arch);
    }
    
    /*
    //Metodos
    public int verificarArchivo(ArrayList<Archivo> workspace, String archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).nombre.equals(archivo)){
                return i;
            }
        }
        return -1;
    }*/
}
