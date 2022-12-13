package com.Integrador.repository;

import com.Integrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    @Modifying
    @Query(value = "update paciente p set p.domicilio= ?1 where id = ?2", nativeQuery = true)
    void modificar(@Param("domicilio") String domicilio, @Param("id") Integer id);
}
