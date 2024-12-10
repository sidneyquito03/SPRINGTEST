package com.tecsup.orientatec.repository;

import com.tecsup.orientatec.models.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {}
