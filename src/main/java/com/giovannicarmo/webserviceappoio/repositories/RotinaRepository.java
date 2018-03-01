package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.Rotina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RotinaRepository extends JpaRepository<Rotina, Integer> {

    @Query("SELECT obj FROM Rotina obj WHERE obj.crianca.id = :id_crianca")
    Page<Rotina> search(@Param("id_crianca") Integer criancaId, Pageable pageRequest);
}
