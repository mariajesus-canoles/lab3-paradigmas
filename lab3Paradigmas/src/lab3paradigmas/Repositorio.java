
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
    public Repositorio(String nombreRep, String autor){
        this.gitInit(nombreRep, autor);
    }
    
    //Metodos
    public String toString(){
        String output = "Nombre Rep: " + this.nombreRep + ", Autor: " + this.autor
                + "\nWorkspace: " + this.workspace + "\nIndex: " + this.index + "\nLocal: " 
                + this.local + "\nRemote: " + this.remote;
        return output;
    }
    
    private void gitInit(String nombreRep, String autor){
        this.nombreRep = nombreRep;
        this.autor = autor;
        this.workspace = new Workspace();
        this.index = new Index();
        this.local = new Local();
        this.remote = new Remote();
    }

    
    
    
    //----------------------------------------------
    
    /*
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
    
    public void gitCommit(Repositorio repo){
        if(this.index.archivos.isEmpty()){
            System.out.println("Sin archivos en el Index");
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese el mensaje del commit:");
            String mensaje = input.nextLine();
            Commit _commit = new Commit();
            _commit.crearCommit("Master", mensaje, this.index.archivos);
            this.local.commits.add(_commit);
            System.out.println("Commit: " + this.local.commits.get(0).mensaje + this.local.commits.get(0).archivos.get(0).nombre);
        }
    }*/
    
    
    
}
