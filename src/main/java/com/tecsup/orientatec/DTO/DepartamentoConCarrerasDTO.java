package com.tecsup.orientatec.DTO;

import com.tecsup.orientatec.models.Carrera;

import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoConCarrerasDTO {
    private int iddepartamentos;
    private String nombre_departamentos;
    private int puntaje_minimo;
    private List<CarreraDTO> carreras; // Lista de DTOs de carreras
    private String descripcion_departamento;

    // Constructor
    public DepartamentoConCarrerasDTO(int iddepartamentos, String nombre_departamentos, int puntaje_minimo, String descripcionDepartamento, List<Carrera> carreras) {
        this.iddepartamentos = iddepartamentos;
        this.nombre_departamentos = nombre_departamentos;
        this.puntaje_minimo = puntaje_minimo;
        this.descripcion_departamento = descripcionDepartamento;
        this.carreras = carreras.stream().map(carrera -> new CarreraDTO(
                carrera.getIdcarreras(),
                carrera.getNombre_carrera(),
                carrera.getDescripcion_carrera(),
                carrera.getDuracion()
        )).collect(Collectors.toList());
    }

    // Getters y setters
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

    public List<CarreraDTO> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<CarreraDTO> carreras) {
        this.carreras = carreras;
    }

    public String getDescripcion_departamento() {
        return descripcion_departamento;
    }

    public void setDescripcion_departamento(String descripcion_departamento) {
        this.descripcion_departamento = descripcion_departamento;
    }
}
