package com.otraPrueba.backendPort.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
   
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    
    @NotNull
    private String descripcion;

    
    private String imagenURL;
    
    private String imagenPath;

    

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String imagenURL,String imagenPath) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imagenURL = imagenURL;
        this.imagenPath = imagenPath;
    }

    public String getimagenPath() {
        return imagenPath;
    }

    public void setimagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }  


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getimagenURL() {
        return imagenURL;
    }

    public void setimagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }   
    
   }
    

