package com.tecsup.orientatec.repository;

import com.tecsup.orientatec.models.TestPregunta;
import com.tecsup.orientatec.models.TestRespuesta;
import com.tecsup.orientatec.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TestRespuestaRepository extends CrudRepository<TestRespuesta, Integer> {
    @Query("SELECT tr FROM TestRespuesta tr WHERE tr.testPregunta = :testPregunta")
    List<TestRespuesta> findByTestPregunta(@Param("testPregunta") TestPregunta testPregunta);

    @Query("SELECT tr FROM TestRespuesta tr WHERE tr.usuario = :usuario")
    List<TestRespuesta> findByUsuario(@Param("usuario") User usuario);

    @Query("SELECT tr FROM TestRespuesta tr WHERE tr.usuario.idusuarios = :usuarioId")
    List<TestRespuesta> findByUsuarioId(@Param("usuarioId") int usuarioId);

    @Query("SELECT u FROM User u WHERE u.idusuarios = :id")
    Optional<User> findUsuarioById(@Param("id") Long id);

}
