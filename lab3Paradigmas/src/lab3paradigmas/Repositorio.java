
package lab3paradigmas;

public class Repositorio {
    //Atributos
    String nombreRep;
    String autor;
    Workspace workspace;
    Index index;
    Local local;
    Remote remote;
    
    //Constructor
    public void crearRepositorio(String nombreRep, String autor, Workspace workspace, Index index, Local local, Remote remote){
        this.nombreRep = nombreRep;
        this.autor = autor;
        this.workspace = workspace;
        this.index = index;
        this.local = local;
        this.remote = remote;
    }
    
    //Metodos
    
    
}
