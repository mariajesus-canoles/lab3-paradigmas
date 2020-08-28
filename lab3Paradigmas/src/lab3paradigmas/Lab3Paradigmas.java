/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab3paradigmas;

import java.*;
import java.util.ArrayList;
/**
 *
 * @author mariajesuscanoles
 */
public class Lab3Paradigmas {

    public static void main(String[] args) {
        // TODO code application logic here
        Archivo arch1 = new Archivo();
        arch1.crearArchivo("Jesus", "28/08", "contenido random");
        
        Archivo arch2 = new Archivo();
        arch2.crearArchivo("Jose", "30/08", "contenido random 2");
        
        
        ArrayList<Archivo> archivos = new ArrayList<Archivo>();
        archivos.add(arch1);
        archivos.add(arch2);

        for(int i=0; i<archivos.size(); i++){
            System.out.println("Nombre: " + archivos.get(i).nombre);
            System.out.println("Fecha: " + archivos.get(i).fechaModificacion);
            System.out.println("Contenido: " + archivos.get(i).contenido);
        }
    }
    

}
