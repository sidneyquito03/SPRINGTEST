package com.tecsup.orientatec.rest_controllers;

import com.tecsup.orientatec.DTO.TestDTO;
import com.tecsup.orientatec.models.Departamento;
import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.TestRespuesta;
import com.tecsup.orientatec.models.User;
import com.tecsup.orientatec.repository.DepartamentoRepository;
import com.tecsup.orientatec.services.TestRespuestaService;
import com.tecsup.orientatec.services.TestService;
import com.tecsup.orientatec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/test")
public class TestApiController {

    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private TestRespuestaService testRespuestaService;

    @GetMapping("/user/{usuarioId}")
    public ResponseEntity<List<Test>> getTestsByUsuario(@PathVariable Integer usuarioId) {
        try {
            User user = new User();
            user.setIdusuario(usuarioId);
            List<Test> tests = testService.getTestsByUsuario(user);
            if (tests.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tests);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Test> saveTest(@RequestBody Test test) {
        try {
            Test savedTest = testService.saveTest(test);
            return ResponseEntity.ok(savedTest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable Integer id) {
        try {
            Test test = testService.findById(id); // Implementa este método en tu servicio si aún no lo tienes.
            if (test != null) {
                TestDTO testDTO = new TestDTO(
                        test.getIdtest(),
                        test.getUsuario().getNombre_completo(),
                        test.getDepartamento().getNombre_departamentos(),
                        test.getFecha_realizacion()
                );
                return ResponseEntity.ok(testDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/simular/{id}")
    public ResponseEntity<?> simularTestRespuesta(@PathVariable int id) {
        try {
            // Obtener respuestas por usuario
            List<TestRespuesta> respuestas = testRespuestaService.obtenerRespuestasPorUsuario(id);

            if (respuestas.isEmpty()) {
                return ResponseEntity.badRequest().body("No se encontraron respuestas para el usuario con ID: " + id);
            }

            // Calcular puntajes por departamento
            Map<Integer, Integer> puntajes = new HashMap<>();
            for (TestRespuesta respuesta : respuestas) {
                Integer departamentoId = respuesta.getPuntuacion_departamento();
                puntajes.put(departamentoId, puntajes.getOrDefault(departamentoId, 0) + 1);
            }

            // Determinar el departamento con mayor puntaje
            Integer departamentoGanadorId = puntajes.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            if (departamentoGanadorId == null) {
                return ResponseEntity.badRequest().body("No se pudo determinar un departamento ganador.");
            }

            // Obtener las entidades relacionadas
            Optional<User> usuarioOptional = userService.findById(id);
            if (!usuarioOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Usuario no encontrado.");
            }

            Optional<Departamento> departamentoOptional = departamentoRepository.findById(departamentoGanadorId);
            if (!departamentoOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Departamento no encontrado.");
            }

            // Crear y guardar el resultado del test
            Test test = new Test();
            test.setUsuario(usuarioOptional.get());
            test.setDepartamento(departamentoOptional.get());
            test.setFecha_realizacion(LocalDateTime.now());
            testService.saveTest(test);

            return ResponseEntity.ok("Simulación completada. Departamento asignado: " + departamentoOptional.get().getNombre_departamentos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la simulación: " + e.getMessage());
        }
    }
}
