package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemUsuarioRepository extends JpaRepository<MensagemUsuario, Integer> {
}
