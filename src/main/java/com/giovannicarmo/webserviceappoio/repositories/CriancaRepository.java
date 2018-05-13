package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CriancaRepository extends JpaRepository<Crianca, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Crianca obj JOIN obj.usuarios u ON u.id = :id_usuario")
    List<Crianca> findCriancaByUsuario(@Param("id_usuario") Integer id);
}
