package com.tecsup.orientatec.rest_controllers;

import com.tecsup.orientatec.models.*;
import com.tecsup.orientatec.services.TestRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/test-respuesta")
public class TestRespuestaApiController {

    @Autowired
    private TestRespuestaService testRespuestaService;

    @GetMapping("/pregunta/{preguntaId}")
    public ResponseEntity<List<TestRespuesta>> getRespuestasByPregunta(@PathVariable Integer preguntaId) {
        TestPregunta testPregunta = new TestPregunta();
        testPregunta.setId_testpregunta(preguntaId); // Asigna el ID al objeto TestPregunta
        List<TestRespuesta> respuestas = testRespuestaService.findByTestPregunta(testPregunta);
        if (respuestas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TestRespuesta>> getRespuestasByUsuario(@PathVariable Integer usuarioId) {
        User user = new User();
        user.setIdusuario(usuarioId); // Asigna el ID al objeto User
        List<TestRespuesta> respuestas = testRespuestaService.findByUsuario(user);
        if (respuestas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(respuestas);
    }

    @PostMapping
    public ResponseEntity<TestRespuesta> saveTestRespuesta(@RequestBody TestRespuesta testRespuesta) {
        TestRespuesta savedRespuesta = testRespuestaService.saveTestRespuesta(testRespuesta);
        return ResponseEntity.ok(savedRespuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestRespuesta> getRespuestaById(@PathVariable int id) {
        Optional<TestRespuesta> respuesta = testRespuestaService.findById(id);
        return respuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/simular/{id}")
    public ResponseEntity<?> simularTest(@PathVariable Long id) {
        try {
            String resultado = testRespuestaService.simularTest(id);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
