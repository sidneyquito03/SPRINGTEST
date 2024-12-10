package com.tecsup.orientatec.repository;

import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.TestPregunta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestPreguntaRepository extends CrudRepository<TestPregunta, Integer> {
    @Query("SELECT tp FROM TestPregunta tp WHERE tp.test = :test")
    List<TestPregunta> findByTest(@Param("test") Test test);
}
