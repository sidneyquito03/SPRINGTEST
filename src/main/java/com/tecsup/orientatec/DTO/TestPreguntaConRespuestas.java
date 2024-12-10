package com.tecsup.orientatec.DTO;

import com.tecsup.orientatec.models.TestPregunta;
import com.tecsup.orientatec.models.TestRespuesta;

import java.util.List;

public class TestPreguntaConRespuestas {
    private TestPregunta pregunta;
    private List<TestRespuesta> respuestas;

    // Getters y Setters
    public TestPregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(TestPregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<TestRespuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<TestRespuesta> respuestas) {
        this.respuestas = respuestas;
    }
}

