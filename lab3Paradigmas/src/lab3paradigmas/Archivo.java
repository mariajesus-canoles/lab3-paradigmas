/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3paradigmas;

/**
 *
 * @author mariajesuscanoles
 */
public class Archivo {
    String nombre;
    String fechaModificacion;
    String contenido;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public void crearArchivo(String _nombre, String _fechaModificacion, String _contenido){
        nombre = _nombre;
        fechaModificacion = _fechaModificacion;
        contenido = _contenido; 
    }
    
}
