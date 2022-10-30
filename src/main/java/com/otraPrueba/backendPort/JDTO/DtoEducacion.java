package com.otraPrueba.backendPort.JDTO;

import javax.validation.constraints.NotBlank;



public class DtoEducacion {
   @NotBlank
   private String nombreEdu;
   @NotBlank
   private String descripcionEdu;
   @NotBlank
   private String imagenPath;
   @NotBlank
   private String imagenURL;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descripcionEdu, String imagenPath, String imagenURL) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.imagenPath = imagenPath;
        this.imagenURL = imagenURL;
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
   
}
