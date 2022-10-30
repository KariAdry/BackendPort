package com.otraPrueba.backendPort.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    private String imagenPath;
    private String imagenURL;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String imagenPath, String imagenURL) {
        
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.imagenPath = imagenPath;
        this.imagenURL = imagenURL;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
    
    
}
