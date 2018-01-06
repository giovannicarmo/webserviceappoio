package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriancaRepository extends JpaRepository<Crianca, Integer> {
}
