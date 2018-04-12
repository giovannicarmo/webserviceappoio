package com.giovannicarmo.webserviceappoio.repositories;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Transactional(readOnly = true)
    Usuario findByEmail(String email);
}
