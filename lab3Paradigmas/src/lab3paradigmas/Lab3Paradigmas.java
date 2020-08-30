
package lab3paradigmas;

import java.util.Scanner;

public class Lab3Paradigmas {
    
    public static Repositorio gitInit(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del repositorio:\n");
        String nombreRep = input.nextLine();
        System.out.println("Ingrese el autor del repositorio:\n");
        String autor = input.nextLine();
        Repositorio repo = new Repositorio();
        Workspace workspace = new Workspace();
        Index index = new Index();
        Local local = new Local();
        Remote remote = new Remote();
        repo.crearRepositorio(nombreRep, autor, workspace, index, local, remote);
        System.out.println(repo.nombreRep + repo.autor + repo.workspace + repo.index + repo.local + repo.remote);         
        return repo;
    }

    public static void main(String[] args) {
        /*
        Archivo arch = new Archivo();
        arch.crearArchivo("jesus", "hola como estas");
        System.out.println(arch.nombre + arch.fecha + arch.contenido);
        */
        Repositorio repo = new Repositorio();
        repo = gitInit();
        
    }

}
