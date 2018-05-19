package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Rotina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RotinaRepository extends JpaRepository<Rotina, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Rotina obj WHERE obj.crianca.nome = :nome_crianca")
    Page<Rotina> search(@Param("nome_crianca") String nome, Pageable pageRequest);

    @Transactional
    List<Rotina> deleteAllByCrianca(Crianca crianca);
}
