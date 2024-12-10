package com.tecsup.orientatec.rest_controllers;

import com.tecsup.orientatec.DTO.DepartamentoConCarrerasDTO;
import com.tecsup.orientatec.models.Carrera;
import com.tecsup.orientatec.models.Departamento;
import com.tecsup.orientatec.repository.CarreraRepository;
import com.tecsup.orientatec.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoApiController {

    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    @GetMapping
    public ResponseEntity<List<DepartamentoConCarrerasDTO>> getAllDepartamentos() {
        List<Departamento> departamentos = (List<Departamento>) departamentoRepository.findAll();

        if (departamentos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        List<DepartamentoConCarrerasDTO> departamentosConCarreras = new ArrayList<>();

        for (Departamento departamento : departamentos) {
            List<Carrera> carreras = carreraRepository.findByDepartamentoId(departamento.getIddepartamentos());

            // Crear el DTO con la descripción del departamento incluida
            DepartamentoConCarrerasDTO departamentoConCarrerasDTO = new DepartamentoConCarrerasDTO(
                    departamento.getIddepartamentos(),
                    departamento.getNombre_departamentos(),
                    departamento.getPuntaje_minimo(),
                    departamento.getDescripcion_departamento(), // Asignar la descripción
                    carreras
            );

            departamentosConCarreras.add(departamentoConCarrerasDTO);
        }

        return ResponseEntity.ok(departamentosConCarreras);
    }
}
