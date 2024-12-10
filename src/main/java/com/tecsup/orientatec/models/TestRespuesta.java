package com.tecsup.orientatec.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "test_respuesta")
public class TestRespuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para el AUTO_INCREMENT
    private Integer idtest_respuesta;
    @ManyToOne
    @JoinColumn(name = "testpregunta_id", referencedColumnName = "id_testpregunta")
    private TestPregunta testPregunta;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "idusuarios")
    private User usuario;
    private String respuesta_test;
    private Integer puntuacion_departamento;

    public Integer getIdtest_respuesta() {
        return idtest_respuesta;
    }

    public void setIdtest_respuesta(Integer idtest_respuesta) {
        this.idtest_respuesta = idtest_respuesta;
    }

    public TestPregunta getTestPregunta() {
        return testPregunta;
    }

    public void setTestPregunta(TestPregunta testPregunta) {
        this.testPregunta = testPregunta;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getRespuesta_test() {
        return respuesta_test;
    }

    public void setRespuesta_test(String respuesta_test) {
        this.respuesta_test = respuesta_test;
    }

    public Integer getPuntuacion_departamento() {
        return puntuacion_departamento;
    }

    public void setPuntuacion_departamento(Integer puntuacion_departamento) {
        this.puntuacion_departamento = puntuacion_departamento;
    }
}