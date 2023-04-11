package br.com.cobax.taskpanner.config;

import java.time.ZonedDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cobax.taskpanner.models.Tarefa;
import br.com.cobax.taskpanner.models.TarefaCategoria;
import br.com.cobax.taskpanner.models.Usuario;
import br.com.cobax.taskpanner.models.enums.TarefaStatus;
import br.com.cobax.taskpanner.repositories.TarefaCategoriaRepository;
import br.com.cobax.taskpanner.repositories.TarefaRepository;
import br.com.cobax.taskpanner.repositories.UsuarioRepository;

@Configuration
@Profile("dev")
public class LoadDatabase {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TarefaCategoriaRepository tarefaCategoriaRepository;

	@Autowired
	TarefaRepository tarefaRepository;

	@Bean
	CommandLineRunner cmd() {
		return args -> {
			loadUsuario();
			loadTarefas();
		};
	};

	private void loadUsuario() {
		Usuario u1 = new Usuario(1l, "willamy.garcia", "Wget@#2099");
		Usuario u2 = new Usuario(2l, "beatriz.garcia", "Wget@#2099");
		Usuario u3 = new Usuario(3l, "livia.garcia", "Wget@#2099");
		Usuario u4 = new Usuario(4l, "junior.garcia", "Wget@#2099");
		Usuario u5 = new Usuario(5l, "lindomar.garcia", "Wget@#2099");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
	}

	private void loadTarefas() {
		
		Usuario u1 = usuarioRepository.findById(1l).orElse(null);

		TarefaCategoria tc1 = new TarefaCategoria(null, "Dia a Dia");
		TarefaCategoria tc2 = new TarefaCategoria(null, "Trabalho");
		TarefaCategoria tc3 = new TarefaCategoria(null, "Casa");

		Tarefa t1 = new Tarefa(null, "Arrumar a cama", tc1, ZonedDateTime.now(), true, TarefaStatus.CONCLUIDO);
		Tarefa t2 = new Tarefa(null, "Criar Crud", tc2, ZonedDateTime.now(), true, TarefaStatus.PENDENTE);
		Tarefa t3 = new Tarefa(null, "Arrumar a casa", tc3, ZonedDateTime.now(), true, TarefaStatus.PENDENTE);
		Tarefa t4 = new Tarefa(null, "Lavar a louça", tc3, ZonedDateTime.now(), true, TarefaStatus.PENDENTE);
		
		t1.setUsuario(u1);
		t2.setUsuario(u1);
		t3.setUsuario(u1);
		t4.setUsuario(u1);

		tarefaCategoriaRepository.saveAll(Arrays.asList(tc1, tc2, tc3));
		tarefaRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}