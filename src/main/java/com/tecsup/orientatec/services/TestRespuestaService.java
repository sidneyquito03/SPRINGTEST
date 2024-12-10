package com.tecsup.orientatec.services;

import com.tecsup.orientatec.models.*;
import com.tecsup.orientatec.repository.CarreraRepository;
import com.tecsup.orientatec.repository.TestRepository;
import com.tecsup.orientatec.repository.TestRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestRespuestaService {
    @Autowired
    private TestRespuestaRepository testRespuestaRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    // Método que devuelve las respuestas para una pregunta específica
    public List<TestRespuesta> findByTestPregunta(TestPregunta testPregunta) {
        return testRespuestaRepository.findByTestPregunta(testPregunta);
    }


    public List<TestRespuesta> findByUsuario(User usuario) {
        return testRespuestaRepository.findByUsuario(usuario);
    }

    public TestRespuesta saveTestRespuesta(TestRespuesta testRespuesta) {
        return testRespuestaRepository.save(testRespuesta);
    }

    public Optional<TestRespuesta> findById(int id) {
        return testRespuestaRepository.findById(id);
    }
    public List<TestRespuesta> obtenerRespuestasPorUsuario(int usuarioId) {
        return testRespuestaRepository.findByUsuarioId(usuarioId);
    }
    // Nuevo método para simular un test
    public String simularTest(Long id) {
        // Busca el usuario por ID
        User usuario = testRespuestaRepository.findUsuarioById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con el ID: " + id));

        // Supongamos que un Test tiene un departamento asociado
        List<Test> tests = testRepository.findByUsuario(usuario);
        if (tests.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron tests para el usuario: " + usuario.getNombre_completo());
        }

        Departamento departamento = tests.get(0).getDepartamento(); // Usar el primer test como ejemplo
        List<Carrera> carreras = carreraRepository.findByDepartamento(departamento);

        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("Simulación para %s completada.\n", usuario.getNombre_completo()));
        resultado.append(String.format("Departamento relacionado: %s\n", departamento.getNombre_departamentos()));
        resultado.append("Carreras disponibles:\n");

        for (Carrera carrera : carreras) {
            resultado.append(String.format("- %s\n", carrera.getNombre_carrera()));
        }

        return resultado.toString();
    }

}
