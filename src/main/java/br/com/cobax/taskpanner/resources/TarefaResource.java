package br.com.cobax.taskpanner.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobax.taskpanner.models.Tarefa;
import br.com.cobax.taskpanner.repositories.TarefaRepository;

@RestController
@RequestMapping(value = "tarefa")
public class TarefaResource {
	
	@Autowired
	TarefaRepository tarefaRepository; 
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll(){
		List<Tarefa> tarefas = new ArrayList<>();
		tarefas = tarefaRepository.findAll();
		return ResponseEntity.ok().body(tarefas);
	}

}
