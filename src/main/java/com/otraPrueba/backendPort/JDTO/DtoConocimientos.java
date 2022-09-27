package com.otraPrueba.backendPort.JDTO;

import javax.validation.constraints.NotBlank;



public class DtoConocimientos 
{
    @NotBlank
  private String nombreCo;
    @NotBlank
  private int porcentajeCo;

    public DtoConocimientos() {
    }

    public DtoConocimientos(String nombreCo, int porcentajeCo) {
        this.nombreCo = nombreCo;
        this.porcentajeCo = porcentajeCo;
    }

    public String getNombreCo() {
        return nombreCo;
    }

    public void setNombreCo(String nombreCo) {
        this.nombreCo = nombreCo;
    }

    public int getPorcentajeCo() {
        return porcentajeCo;
    }

    public void setPorcentajeCo(int porcentajeCo) {
        this.porcentajeCo = porcentajeCo;
    }
    
}
