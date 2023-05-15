package br.com.cobax.taskpanner.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

import br.com.cobax.taskpanner.models.TarefaCategoria;
import br.com.cobax.taskpanner.models.assembler.TarefaCategoriaAssembler;
import br.com.cobax.taskpanner.services.TarefaCategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("categoriaTarefa")
public class TarefaCategoriaResource {

	@Autowired
	private TarefaCategoriaService tarefaCategoriaService;
	
	@Autowired
	private TarefaCategoriaAssembler assemblerCategoria;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EntityModel<TarefaCategoria>> findById(@PathVariable Long id) {
		TarefaCategoria tarefa = tarefaCategoriaService.findById(id);
		return ResponseEntity.ok().body(assemblerCategoria.toModel(tarefa));
	}
	
	@GetMapping
	public ResponseEntity<CollectionModel<EntityModel<TarefaCategoria>>> findAll(){
		List<TarefaCategoria> listCategoria = tarefaCategoriaService.findAll();
		return ResponseEntity.ok().body(assemblerCategoria.toModel(listCategoria));
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody TarefaCategoria categoria) {
		TarefaCategoria tarefa = tarefaCategoriaService.create(categoria);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(tarefa.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody TarefaCategoria categoria) {
		tarefaCategoriaService.update(categoria);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> detele(@PathVariable Long id) {
		tarefaCategoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
