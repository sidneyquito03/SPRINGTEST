package com.tecsup.orientatec.repository;

import com.tecsup.orientatec.models.Test;
import com.tecsup.orientatec.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {

    @Query("SELECT t FROM Test t WHERE t.usuario = :usuario")
    List<Test> findTestsByUserId(@Param("usuario") User usuario);

    @Query("SELECT t FROM Test t WHERE t.usuario = :usuario")
    List<Test> findByUsuario(@Param("usuario") User usuario);
}
