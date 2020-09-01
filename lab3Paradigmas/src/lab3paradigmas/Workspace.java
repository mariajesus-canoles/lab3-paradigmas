
package lab3paradigmas;

import java.util.ArrayList;

public class Workspace {
   //Atributos
    ArrayList<Archivo> archivos = new ArrayList();
    
    //Constructor
    public void crearWorkspace(ArrayList<Archivo> workspace){
        this.archivos = workspace;
    }
    
    //Metodos
    public int verificarArchivo(ArrayList<Archivo> workspace, String archivo){
        for(int i = 0; i<this.archivos.size(); i++){
            if(this.archivos.get(i).nombre.equals(archivo)){
                return i;
            }
        }
        return -1;
    }
}
