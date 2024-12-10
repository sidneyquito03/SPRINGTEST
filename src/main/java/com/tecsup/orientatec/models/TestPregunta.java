package com.tecsup.orientatec.models;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_pregunta")
public class TestPregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para el AUTO_INCREMENT
    private int id_testpregunta;
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "idtest")
    private Test test;
    private String pregunta;

    public int getId_testpregunta() {
        return id_testpregunta;
    }

    public void setId_testpregunta(int id_testpregunta) {
        this.id_testpregunta = id_testpregunta;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}