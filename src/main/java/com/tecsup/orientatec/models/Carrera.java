package com.tecsup.orientatec.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "carreras")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcarreras;
    private String nombre_carrera;
    private String descripcion_carrera;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "departamentos_id", referencedColumnName = "iddepartamentos")
    @JsonIgnore  // Evita que la relación con Departamento se incluya en la serialización
    private Departamento departamento;

    public int getIdcarreras() {
        return idcarreras;
    }

    public void setIdcarreras(int idcarreras) {
        this.idcarreras = idcarreras;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getDescripcion_carrera() {
        return descripcion_carrera;
    }

    public void setDescripcion_carrera(String descripcion_carrera) {
        this.descripcion_carrera = descripcion_carrera;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }




}

