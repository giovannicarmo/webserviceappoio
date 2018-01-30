package com.giovannicarmo.webserviceappoio;

import com.giovannicarmo.webserviceappoio.domain.Crianca;
import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.domain.enums.CategoriaTea;
import com.giovannicarmo.webserviceappoio.domain.enums.Sexo;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;
import com.giovannicarmo.webserviceappoio.repositories.CriancaRepository;
import com.giovannicarmo.webserviceappoio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class WebserviceappoioApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CriancaRepository criancaRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebserviceappoioApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Usuario usuario1 = new Usuario(null, "Giovanni Carmo", "g@gmail.com", "12345", "(32) 32113269", "teste", TipoUsuario.DIRETOR);
		Usuario usuario2 = new Usuario(null, "Reinaldo Luna", "r@gmail.com", "12345", "(32) 32113269", "teste", TipoUsuario.PAI);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Crianca crianca1 = new Crianca(null, "Bruno Campos", "Jesuitas", "file/file.png", sdf.parse("02/02/1982"), Sexo.MASCULINO, CategoriaTea.GRAVIDADE1);
		Crianca crianca2 = new Crianca(null, "Anderson Segunda", "Clorindo", "file/file.png", sdf.parse("24/04/1984"), Sexo.MASCULINO, CategoriaTea.GRAVIDADE3);

		usuario1.getCriancas().addAll(Arrays.asList(crianca1, crianca2));
		usuario2.getCriancas().addAll(Arrays.asList(crianca1, crianca2));

		crianca1.getUsuarios().addAll(Arrays.asList(usuario1, usuario2));
		crianca2.getUsuarios().addAll(Arrays.asList(usuario1, usuario2));

		usuarioRepository.save(Arrays.asList(usuario1, usuario2));
		criancaRepository.save(Arrays.asList(crianca1, crianca2));

	}
}
