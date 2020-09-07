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
        System.out.println("Ingrese los archivos que desea agregar al Index, en caso\nde querer"
                + " agregar todos los archivos escribir 'ALL':");
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
                    output = output + "\nRemote NO se encuentra al dia";
                }
        return output;
    }
    
    public void menu(){
        String aux = "### SIMULACION DE GIT ###\nEscoja su opcion:\n1. add\n2. commit\n3. pull\n4. push\n5. status\n"
                + "6. Crear nuevo archivo\n7. Log\n8. Branch\n9. Salir\nIntroduzca su opcion:";
        Scanner input = new Scanner(System.in);
        System.out.println(aux);
        String opcion = input.nextLine();
        //int opcion = Integer.parseInt(aux2);
        if(opcion.equals("1")){
            this.gitAdd();
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("2")){
            this.gitCommit();
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("3")){
            this.gitPull();
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("4")){
            this.gitPush();
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("5")){
            System.out.println(this.gitStatus());
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("6")){
            this.workspace.addArchivo();
            System.out.println(this);
            this.menu();
        }
        if(opcion.equals("7")){
            System.out.println(this.gitLog());
            this.menu();
        }
        if(opcion.equals("8")){
            this.gitBranch();
            this.menu();
        }
        if(opcion.equals("9")){
            System.out.println("### FIN SIMULACION GIT ###");
            System.exit(0);
        }
        else{
            System.out.println("*************************\nOpcion ingresada invalida\n*************************");
            this.menu();
        }
    }
   
    public String gitLog(){
        if(this.local.commits.isEmpty()){
            return "Sin commits en el Local";
        }
        else{
            int largo = this.local.commits.size();
            String output;
            if(largo<=5){
                output = "Los ultimos " + largo + " commits agregados al Local son:\n";
                for(int i=largo; i>0; i--){
                    output = output + this.local.commits.get(i-1) + "\n";
                }
            }
            else{
                output = "Los ultimos 5 commits agregados al Local son:\n";
                for(int j=5; j>0; j--){
                    output = output + this.local.commits.get(j-1) + "\n";
                }
            }
            return output; 
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
