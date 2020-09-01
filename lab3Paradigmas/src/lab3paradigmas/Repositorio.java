
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
        System.out.println("Ingrese el nombre del repositorio:");
        String _nombreRep = input.nextLine();
        System.out.println("Ingrese el autor del repositorio:");
        String _autor = input.nextLine();
        Workspace _workspace = new Workspace();
        Index _index = new Index();
        Local _local = new Local();
        Remote _remote = new Remote();
        this.crearRepositorio(_nombreRep, _autor, _workspace, _index, _local, _remote);
    }
    
    public void addArchivo(Repositorio repo){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo a crear:");
        String nombreArchivo = input.nextLine();
        System.out.println("Ingrese el contenido del archivo:");
        String contenidoArchivo = input.nextLine();
        Archivo arch = new Archivo();
        arch.crearArchivo(nombreArchivo, contenidoArchivo);
        this.workspace.archivos.add(arch);
    }
    
    
    
    public void gitAdd(Repositorio repo){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el o los archivos que desea agregar al Index:");
        String[] _archivos = input.nextLine().split(" ");
        for(int i=0; i < _archivos.length ; i++){
            int aux = this.workspace.verificarArchivo(this.workspace.archivos, _archivos[i]);
            if(aux != -1){
                this.index.archivos.add(this.workspace.archivos.get(aux));
            }
        }
    }
    
    
    
}
