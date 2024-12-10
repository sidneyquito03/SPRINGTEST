package com.tecsup.orientatec.services;

import com.tecsup.orientatec.DTO.TestPreguntaConRespuestas;
import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.TestPregunta;
import com.tecsup.orientatec.models.TestRespuesta;
import com.tecsup.orientatec.repository.TestPreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TestPreguntaService {
    @Autowired
    private TestPreguntaRepository testPreguntaRepository;
    @Autowired
    private TestRespuestaService testRespuestaService;


    public List<TestPregunta> findByTest(Test test) {
        return testPreguntaRepository.findByTest(test);
    }

    public TestPregunta saveTestPregunta(TestPregunta testPregunta) {
        return testPreguntaRepository.save(testPregunta);
    }

    public Optional<TestPregunta> findById(int id) {
        return testPreguntaRepository.findById(id);
    }

    // Método para obtener todas las preguntas con sus respuestas
    public List<TestPreguntaConRespuestas> obtenerTodasLasPreguntasConRespuestas() {
        List<TestPregunta> preguntas = (List<TestPregunta>) testPreguntaRepository.findAll(); // Obtiene todas las preguntas
        List<TestPreguntaConRespuestas> preguntasConRespuestas = new ArrayList<>();
        for (TestPregunta pregunta : preguntas) {
            // Crear un objeto que contenga tanto la pregunta como las respuestas
            TestPreguntaConRespuestas preguntaConRespuestas = new TestPreguntaConRespuestas();
            preguntaConRespuestas.setPregunta(pregunta);

            // Obtener las respuestas asociadas a la pregunta
            List<TestRespuesta> respuestas = testRespuestaService.findByTestPregunta(pregunta);
            preguntaConRespuestas.setRespuestas(respuestas);

            // Añadir a la lista
            preguntasConRespuestas.add(preguntaConRespuestas);
        }
        return preguntasConRespuestas; // Devuelve las preguntas con sus respuestas
    }
}
