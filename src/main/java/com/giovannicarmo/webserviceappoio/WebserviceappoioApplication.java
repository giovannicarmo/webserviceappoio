package com.giovannicarmo.webserviceappoio;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WebserviceappoioApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebserviceappoioApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Usuario usuario = new Usuario(1, "Giovanni Carmo", "g@gmail.com", "12345", "(32) 32113269", "teste", TipoUsuario.DIRETOR);

		usuarioRepository.save(Arrays.asList(usuario));

	}
}
