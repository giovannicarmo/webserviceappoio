package com.giovannicarmo.webserviceappoio;

import com.giovannicarmo.webserviceappoio.domain.*;
import com.giovannicarmo.webserviceappoio.domain.enums.*;
import com.giovannicarmo.webserviceappoio.repositories.*;
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
	@Autowired
	private RecomendacaoMedicaRepository medicaRepository;
	@Autowired
	private RotinaRepository rotinaRepository;
	@Autowired
	private MensagemUsuarioRepository mensagemUsuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebserviceappoioApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Usuario usuario1 = new Usuario(null, "Giovanni Carmo", "g@gmail.com", "12345",
				"(32) 32113269", "teste", TipoUsuario.DIRETOR);
		Usuario usuario2 = new Usuario(null, "Reinaldo Luna", "r@gmail.com", "12345",
				"(32) 32113269", "teste", TipoUsuario.PAI);

		Crianca crianca1 = new Crianca(null, "Bruno Campos", "Jesuitas", "file/file.png",
				sdf.parse("02/02/1982"), Sexo.MASCULINO, CategoriaTea.GRAVIDADE1);
		Crianca crianca2 = new Crianca(null, "Anderson Segunda", "Clorindo", "file/file.png",
				sdf.parse("24/04/1984"), Sexo.MASCULINO, CategoriaTea.GRAVIDADE3);

		usuario1.getCriancas().addAll(Arrays.asList(crianca1, crianca2));
		usuario2.getCriancas().addAll(Arrays.asList(crianca1, crianca2));

		crianca1.getUsuarios().addAll(Arrays.asList(usuario1, usuario2));
		crianca2.getUsuarios().addAll(Arrays.asList(usuario1, usuario2));

		RecomendacaoMedica recomendacaoMedica1 = new RecomendacaoMedica(null, "Lorem ipsum dolor sit amet," +
				"consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
				"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
				"nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +
				"mollit anim id est laborum.", usuario1, crianca1);
		RecomendacaoMedica recomendacaoMedica2 = new RecomendacaoMedica(null, "Lorem ipsum dolor sit" +
				"amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
				"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla" +
				"pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit" +
				"anim id est laborum.", usuario1, crianca2);


		Rotina rotina1 = new Rotina(usuario1, crianca1, sdf.parse("01/02/2018 12:09"),sdf.parse("01/02/2018"), TipoRotina.ESCOLA,
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt" +
						"ut labore et dolore magna aliqua.",
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
						"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
						"fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui" +
						"officia deserunt mollit anim id est laborum.",
				Avaliacao.BOM, Avaliacao.REGULAR, Avaliacao.REGULAR, Avaliacao.BOM);

		Rotina rotina2 = new Rotina(usuario2, crianca2, sdf.parse("22/02/2018 17:49"), sdf.parse("22/02/2018"), TipoRotina.CASA,
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt" +
						"ut labore et dolore magna aliqua.",
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
						"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
						"fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui" +
						"officia deserunt mollit anim id est laborum.",
				Avaliacao.RUIM, Avaliacao.REGULAR, Avaliacao.REGULAR, Avaliacao.OTIMO);

		MensagemUsuario mensagemUsuario = new MensagemUsuario(null, usuario1, usuario2, sdf.parse("02/02/2018 18:18"), "corpo", "anexo");

		usuario1.getRotinas().addAll(Arrays.asList(rotina1));

		crianca1.getRotinas().addAll(Arrays.asList(rotina1));

		usuario2.getRotinas().addAll(Arrays.asList(rotina2));

		crianca2.getRotinas().addAll(Arrays.asList(rotina2));

		usuarioRepository.save(Arrays.asList(usuario1, usuario2));
		criancaRepository.save(Arrays.asList(crianca1, crianca2));
		medicaRepository.save(Arrays.asList(recomendacaoMedica1, recomendacaoMedica2));
		rotinaRepository.save(Arrays.asList(rotina1, rotina2));
		mensagemUsuarioRepository.save(Arrays.asList(mensagemUsuario));
	}
}
