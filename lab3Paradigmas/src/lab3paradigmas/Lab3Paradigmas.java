
package lab3paradigmas;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Paradigmas {

    public static void main(String[] args) {
        Repositorio repo = new Repositorio();
        repo.gitInit();
        repo.addArchivo(repo);
        
    }

}
