package com.tecsup.orientatec.rest_controllers;

import com.tecsup.orientatec.DTO.TestPreguntaConRespuestas;
import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.TestPregunta;
import com.tecsup.orientatec.models.TestRespuesta;
import com.tecsup.orientatec.services.TestPreguntaService;
import com.tecsup.orientatec.services.TestRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/test-pregunta")
public class TestPreguntaApiController {

    @Autowired
    private TestPreguntaService testPreguntaService;
    @Autowired
    private TestRespuestaService testRespuestaService;

    @GetMapping("/test/{testId}")
    public ResponseEntity<List<TestPregunta>> getPreguntasByTest(@PathVariable Integer testId) {
        Test test = new Test();
        test.setIdtest(testId); // Asigna el ID al objeto Test
        List<TestPregunta> preguntas = testPreguntaService.findByTest(test);
        if (preguntas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping
    public ResponseEntity<TestPregunta> saveTestPregunta(@RequestBody TestPregunta testPregunta) {
        TestPregunta savedPregunta = testPreguntaService.saveTestPregunta(testPregunta);
        return ResponseEntity.ok(savedPregunta);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<TestPreguntaConRespuestas>> getTodasLasPreguntasConRespuestas() {
        List<TestPreguntaConRespuestas> preguntasConRespuestas = testPreguntaService.obtenerTodasLasPreguntasConRespuestas();
        return ResponseEntity.ok(preguntasConRespuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestPregunta> getPreguntaById(@PathVariable int id) {
        Optional<TestPregunta> pregunta = testPreguntaService.findById(id);
        return pregunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
