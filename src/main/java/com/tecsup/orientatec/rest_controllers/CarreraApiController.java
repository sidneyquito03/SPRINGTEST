package com.tecsup.orientatec.rest_controllers;

import com.tecsup.orientatec.models.Carrera;
import com.tecsup.orientatec.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carreras")
public class CarreraApiController {

    @Autowired
    private CarreraRepository carreraRepository;

    @GetMapping
    public ResponseEntity<List<Carrera>> getAllCarreras() {
        List<Carrera> carreras = (List<Carrera>) carreraRepository.findAll();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable int id) {
        Optional<Carrera> carrera = carreraRepository.findById(id);
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrera> saveCarrera(@RequestBody Carrera carrera) {
        Carrera savedCarrera = carreraRepository.save(carrera);
        return ResponseEntity.ok(savedCarrera);
    }
}
