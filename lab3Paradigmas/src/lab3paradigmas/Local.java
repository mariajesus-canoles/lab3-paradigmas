package lab3paradigmas;

import java.util.ArrayList;

public class Local {
    //Atributos
    ArrayList<Commit> commits;
    
    //Constructor
    public Local(){
        this.commits = new ArrayList();
    }
    
    //Metodos
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
