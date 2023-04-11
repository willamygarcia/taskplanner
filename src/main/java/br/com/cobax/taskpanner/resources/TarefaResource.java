package br.com.cobax.taskpanner.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cobax.taskpanner.models.Tarefa;
import br.com.cobax.taskpanner.services.TarefaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "tarefa")
public class TarefaResource {

	@Autowired
	TarefaService tarefaService;

	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		return ResponseEntity.ok().body(tarefaService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(tarefaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Tarefa tarefa) {
		Tarefa t = new Tarefa();
		t = tarefaService.save(tarefa);

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(t.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Tarefa tarefa,  @PathVariable Long id){
		tarefaService.update(tarefa, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> dalete(@PathVariable Long id){
		tarefaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
