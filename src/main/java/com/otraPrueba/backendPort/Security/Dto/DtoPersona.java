package com.otraPrueba.backendPort.Security.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
   @NotBlank
   private String nombre;
   @NotBlank
   private String apellido;
   @NotBlank
   private String imagenURL;
   @NotBlank
   private String descripcion;
   @NotBlank
   private String imagenPath;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String imagenURL, String descripcion,String imagenPath) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagenURL = imagenURL;
        this.descripcion = descripcion;
        this.imagenPath = imagenPath;
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

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getimagenPath() {
        return imagenPath;
    }

    public void setimagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }


   
   
}
