package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.RecomendacaoMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecomendacaoMedicaRepository extends JpaRepository<RecomendacaoMedica, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM RecomendacaoMedica obj JOIN obj.crianca c ON c.id = :id_crianca")
    List<RecomendacaoMedica> findAllByCrianca(@Param("id_crianca") Integer id);

}
