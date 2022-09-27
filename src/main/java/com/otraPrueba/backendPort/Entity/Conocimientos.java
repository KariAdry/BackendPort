package com.otraPrueba.backendPort.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Conocimientos
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreCo;
    private int porcentajeCo;

    public Conocimientos() {
    }

    public Conocimientos(String nombreCo, int porcentajeCo) {
        this.nombreCo = nombreCo;
        this.porcentajeCo = porcentajeCo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
