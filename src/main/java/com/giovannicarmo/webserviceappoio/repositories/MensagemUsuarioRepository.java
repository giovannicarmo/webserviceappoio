package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.MensagemUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MensagemUsuarioRepository extends JpaRepository<MensagemUsuario, Integer> {

    @Query("SELECT obj FROM MensagemUsuario obj WHERE obj.usuarioRemetente.id = :id_usuario_remetente AND " +
            "obj.usuarioReceptor.id = :id_usuario_receptor")
    List<MensagemUsuario> chats(@Param("id_usuario_remetente") Integer usuarioRemetenteId,
                                @Param("id_usuario_receptor") Integer usuarioReceptorId);
}
