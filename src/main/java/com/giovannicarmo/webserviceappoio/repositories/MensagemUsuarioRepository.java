package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import com.giovannicarmo.webserviceappoio.domain.MensagemUsuarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemUsuarioRepository extends JpaRepository<MensagemUsuario, Integer> {
    MensagemUsuario findOne(MensagemUsuarioPK id);
    MensagemUsuario delete(MensagemUsuarioPK id);
}
