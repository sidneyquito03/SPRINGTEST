package com.tecsup.orientatec.DTO;

public class CarreraDTO {
    private int idcarreras;
    private String nombre_carrera;
    private String descripcion_carrera;
    private int duracion;

    // Constructor
    public CarreraDTO(int idcarreras, String nombre_carrera, String descripcion_carrera, int duracion) {
        this.idcarreras = idcarreras;
        this.nombre_carrera = nombre_carrera;
        this.descripcion_carrera = descripcion_carrera;
        this.duracion = duracion;
    }

    // Getters y setters
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
}
