package lab3paradigmas;
               
import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Paradigmas {

    public static void main(String[] args) {
        Repositorio repo = new Repositorio();
        repo.workspace.addArchivo();
        repo.workspace.addArchivo();
        repo.gitAdd();
        System.out.println(repo);
        repo.gitCommit();
        System.out.println(repo);
        repo.gitPush();
        System.out.println(repo);
        
        
    }

}
