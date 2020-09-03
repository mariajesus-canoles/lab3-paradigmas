
package lab3paradigmas;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Paradigmas {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del repositorio:");
        String nombreRep = input.nextLine();
        System.out.println("Ingrese el autor del repositorio:");
        String autorRep = input.nextLine();
        Repositorio repo = new Repositorio(nombreRep, autorRep);
        
        System.out.println("Ingrese el autor del archivo:");
        String nombreArch = input.nextLine();
        System.out.println("Ingrese el contenido del archivo:");
        String autorArch = input.nextLine();
        repo.workspace.addArchivo(nombreArch, autorArch);
        
        
        
        System.out.println(repo);
        
        //repo.gitInit();
        //repo.addArchivo(repo);
        //repo.addArchivo(repo);
        //repo.gitAdd(repo);
        //repo.gitCommit(repo);
        
    }

}
