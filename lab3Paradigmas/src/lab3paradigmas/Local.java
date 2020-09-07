//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0
package lab3paradigmas;

import java.util.ArrayList;

/**
* Clase para representar una zona local,
* determinada por commits
* @version 1.8
* @author Maria Jesus Canoles
*/
public class Local {
    //Atributos
    ArrayList<Commit> commits;
    
    //Constructor
    /**
     * @param commits commits contenidos en la zona local
     */
    public Local(){
        this.commits = new ArrayList();
    }
    
    //Metodos
    /**
     * metodo que genera un string con el conenido del local
     * @return contenido del local
     */
    public String toString(){
        String output = "";
        if (this.commits.isEmpty()){
            output = output + "Sin contenido en el Local";
        }
        else{
            for(int i=0;i<this.commits.size(); i++){
                if(i+1 == this.commits.size()){
                    output = output + this.commits.get(i);
                }
                else{
                    output = output + this.commits.get(i) + "; ";
                }
            }
        }
        return output;
    }
    
}
