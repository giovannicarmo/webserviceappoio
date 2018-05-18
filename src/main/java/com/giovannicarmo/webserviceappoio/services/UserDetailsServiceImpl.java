package com.giovannicarmo.webserviceappoio.services;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import com.giovannicarmo.webserviceappoio.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getProfiles());
    }
}
