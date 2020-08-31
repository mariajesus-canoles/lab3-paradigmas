
package lab3paradigmas;

import java.util.Scanner;
import java.util.ArrayList;

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
    public void gitInit(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del repositorio:\n");
        String _nombreRep = input.nextLine();
        System.out.println("Ingrese el autor del repositorio:\n");
        String _autor = input.nextLine();
        //Repositorio repo = new Repositorio();
        Workspace _workspace = new Workspace();
        Index _index = new Index();
        Local _local = new Local();
        Remote _remote = new Remote();
        this.crearRepositorio(_nombreRep, _autor, _workspace, _index, _local, _remote);
        //System.out.println(repo.nombreRep + repo.autor + repo.workspace + repo.index + repo.local + repo.remote);         
        //return repo;
    }
    
    public void addArchivo(Repositorio repo){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo a crear:\n");
        String nombreArchivo = input.nextLine();
        System.out.println("Ingrese el contenido del archivo:\n");
        String contenidoArchivo = input.nextLine();
        Archivo arch = new Archivo();
        arch.crearArchivo(nombreArchivo, contenidoArchivo);
        System.out.println(arch.nombre + arch.fecha + arch.contenido);
        this.workspace.archivos.add(arch);
        //System.out.println(repo.workspace.archivos.get(0).nombre + repo.workspace.archivos.get(0).fecha + repo.workspace.archivos.get(0).contenido);
        //return repo;
    }
    
}
