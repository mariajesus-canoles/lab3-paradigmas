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
    public Repositorio(){
        this.gitInit();
    }
    
    //Metodos
    public String toString(){
        String output = "Nombre Rep: " + this.nombreRep + ", Autor: " + this.autor
                + "\nWorkspace: " + this.workspace + "\nIndex: " + this.index + "\nLocal: " 
                + this.local + "\nRemote: " + this.remote;
        return output;
    }
    
    private void gitInit(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del repositorio:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el autor del repositorio:");
        String autor = input.nextLine();
        this.nombreRep = nombre;
        this.autor = autor;
        this.workspace = new Workspace();
        this.index = new Index();
        this.local = new Local();
        this.remote = new Remote();
    }
    
    public void gitAdd(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el o los archivos que desea agregar al Index:");
        String[] archivos = input.nextLine().split(" ");
        if(archivos.length == 1 && archivos[0].equals("all")){
            for(int i=0; i<this.workspace.archivos.size(); i++){
                this.index.archivos.add(this.workspace.archivos.get(i));
            }
        }
        else{
            for(int j=0; j<archivos.length ; j++){
                int aux = this.workspace.verificarArchivo(archivos[j]);
                if(aux != -1){
                    this.index.archivos.add(this.workspace.archivos.get(aux));
                }
            }
        }
    }

    public void gitCommit(){
        if(this.index.archivos.isEmpty()){
            System.out.println("Sin archivos en el Index");
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.println("Ingrese el mensaje del commit:");
            String mensaje = input.nextLine();
            Commit commit = new Commit("Master", mensaje, this.index.archivos);
            this.local.commits.add(commit);
            this.index = new Index();
        }
    }
    
    public void gitPush(){
        if(this.local.commits.isEmpty()){
            System.out.println("Sin commits en el Local");
        }
        else{
            for(int i=0; i<this.local.commits.size(); i++){
                if (! this.remote.commits.contains(this.local.commits.get(i))){
                    this.remote.commits.add(this.local.commits.get(i));
                }
            }
        }
    }
}
