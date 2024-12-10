package com.tecsup.orientatec.repository;

import com.tecsup.orientatec.models.Carrera;
import com.tecsup.orientatec.models.Departamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    @Query("SELECT c FROM Carrera c WHERE c.departamento = :departamento")
    List<Carrera> findByDepartamento(@Param("departamento") Departamento departamento);

    @Query("SELECT c FROM Carrera c WHERE c.departamento.iddepartamentos = :iddepartamentos")
    List<Carrera> findByDepartamentoId(@Param("iddepartamentos") int iddepartamentos);

}
