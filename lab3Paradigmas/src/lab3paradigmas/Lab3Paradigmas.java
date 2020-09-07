//@author Maria Jesus Canoles
//Rut 20300159-2
//Ultimo Edit 06/09/2020
//@version 1.0
package lab3paradigmas;
      
import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Paradigmas {

    public static void main(String[] args) {
        Repositorio repo = new Repositorio();
        repo.workspace.addArchivo();
        repo.menu();
    }
}
