package com.tecsup.orientatec.DTO;

import java.time.LocalDateTime;

public class TestDTO {
    private int idtest;
    private String usuarioNombreCompleto;
    private String departamentoNombre;
    private LocalDateTime fechaRealizacion;

    // Constructor
    public TestDTO(int idtest, String usuarioNombreCompleto, String departamentoNombre, LocalDateTime fechaRealizacion) {
        this.idtest = idtest;
        this.usuarioNombreCompleto = usuarioNombreCompleto;
        this.departamentoNombre = departamentoNombre;
        this.fechaRealizacion = fechaRealizacion;
    }

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    public String getUsuarioNombreCompleto() {
        return usuarioNombreCompleto;
    }

    public void setUsuarioNombreCompleto(String usuarioNombreCompleto) {
        this.usuarioNombreCompleto = usuarioNombreCompleto;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
}
