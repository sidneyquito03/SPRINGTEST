package com.tecsup.orientatec.models;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para manejar el AUTO_INCREMENT
    private int idtest;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "idusuarios")
    private User usuario;
    private LocalDateTime fecha_realizacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "result_departamento", referencedColumnName = "iddepartamentos")
    private Departamento departamento;

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }
    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha_realizacion() {
        return fecha_realizacion;
    }

    public void setFecha_realizacion(LocalDateTime fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
