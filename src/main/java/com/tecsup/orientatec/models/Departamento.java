package com.tecsup.orientatec.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.Date;

@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    private int iddepartamentos;
    private String nombre_departamentos;
    private int puntaje_minimo;
    private String descripcion_departamento;
    private String imagen_departamento;



    public String getImagen_departamento() {
        return imagen_departamento;
    }

    public void setImagen_departamento(String imagen_departamento) {
        this.imagen_departamento = imagen_departamento;
    }



    public int getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(int iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public String getNombre_departamentos() {
        return nombre_departamentos;
    }

    public void setNombre_departamentos(String nombre_departamentos) {
        this.nombre_departamentos = nombre_departamentos;
    }

    public int getPuntaje_minimo() {
        return puntaje_minimo;
    }

    public void setPuntaje_minimo(int puntaje_minimo) {
        this.puntaje_minimo = puntaje_minimo;
    }

    public String getDescripcion_departamento() {
        return descripcion_departamento;
    }

    public void setDescripcion_departamento(String descripcion_departamento) {
        this.descripcion_departamento = descripcion_departamento;
    }



}