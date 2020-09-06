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
        if(archivos.length == 1 && archivos[0].equals("ALL")){
            for(int i=0; i<this.workspace.archivos.size(); i++){
                this.index.archivos.add(this.workspace.archivos.get(i));
            }
        }
        else{
            for(int j=0; j<archivos.length ; j++){
                int aux = this.workspace.posNombreArchivo(archivos[j]);
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
    
    public void gitPull(){
        if(this.remote.commits.isEmpty()){
            System.out.println("Sin commits en el Remote");
        }
        else{
            for(int i=0; i<this.remote.commits.size(); i++){
                for(int j=0; j<this.remote.commits.get(i).archivos.size(); j++){
                    if(! this.workspace.verificarArchivo(this.remote.commits.get(i).archivos.get(j))){
                        this.workspace.archivos.add(this.remote.commits.get(i).archivos.get(j));
                    } 
                }
            }
        }
    }
    
    public String gitStatus(){
        String output = "Nombre Repositorio: " + this.nombreRep + "\nAutor Repositorio: " + this.autor 
                + "\nCantidad archivos en el Workspace: " + this.workspace.archivos.size() 
                + "\nCantidad archivos en el Index: " + this.index.archivos.size()
                + "\nCantidad commits en el Local: " + this.local.commits.size();
                if(this.local.commits.equals(this.remote.commits)){
                    output = output + "\nRemote se encuentra al dia";
                }
                else{
                    output = output + "\nRemote no se encuentra al dia";
                }
        return output;
    }
    
    public void menu(){
        String aux = "### SIMULACION DE GIT ###\nEscoja su opcion:\n1. add\n2. commit\n3. pull\n4. push\n5. status\n"
                + "6. Crear nuevo archivo\n7. Log\n8. Branch\n9. Salir\nIntroduzca su opcion:";
        Scanner input = new Scanner(System.in);
        System.out.println(aux);
        String aux2 = input.nextLine();
        int opcion = Integer.parseInt(aux2);
        if(opcion == 1){
            this.gitAdd();
            System.out.println(this);
            this.menu();
        }
        if(opcion == 2){
            this.gitCommit();
            System.out.println(this);
            this.menu();
        }
        if(opcion == 3){
            this.gitPull();
            System.out.println(this);
            this.menu();
        }
        if(opcion == 4){
            this.gitPush();
            System.out.println(this);
            this.menu();
        }
        if(opcion == 5){
            System.out.println(this.gitStatus());
            System.out.println(this);
            this.menu();
        }
        if(opcion == 6){
            this.workspace.addArchivo();
            System.out.println(this);
            this.menu();
        }
        if(opcion == 7){
            this.gitLog();
            this.menu();
        }
        if(opcion == 8){
            this.gitBranch();
            this.menu();
        }
        if(opcion == 9){
            System.out.println("### FIN SIMULACION GIT ###");
            System.exit(0);
        }
        else{
            System.out.println("Opcion ingresada invalida\n");
            this.menu();
        }
    }
   
    public void gitLog(){
       int largo = this.local.commits.size();
       if(largo<=5){
           System.out.println("Los ultimos " + largo + " commits agregados al Local son:");
           for(int i=largo; i>0; i--){
               System.out.println(this.local.commits.get(i-1));
           }
       }
       else{
           System.out.println("Los ultimos 5 commits agregados al Local son:\n");
           for(int j=5; j>0; j--){
               System.out.println(this.local.commits.get(j-1));
           }
       }
    }
   
    public void gitBranch(){
        if(this.index.archivos.isEmpty()){
           System.out.println("Sin archivos en el Index");
        }
        else{
           Scanner input = new Scanner(System.in);
           System.out.println("Ingrese el nombre de la nueva rama:");
           String rama = input.nextLine();
           System.out.println("Ingrese el mensaje del commit:");
           String mensaje = input.nextLine();
           Commit commit = new Commit(rama, mensaje, this.index.archivos);
           this.local.commits.add(commit);
           this.index = new Index();
        }
    }
    
}
