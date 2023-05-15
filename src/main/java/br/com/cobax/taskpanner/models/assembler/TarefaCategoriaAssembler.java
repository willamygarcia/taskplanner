package br.com.cobax.taskpanner.models.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.cobax.taskpanner.models.TarefaCategoria;
import br.com.cobax.taskpanner.resources.TarefaCategoriaResource;

@Component
public class TarefaCategoriaAssembler implements RepresentationModelAssembler<TarefaCategoria, EntityModel<TarefaCategoria>> {

	@Override
	public EntityModel<TarefaCategoria> toModel(TarefaCategoria entity) {
		
		EntityModel<TarefaCategoria> emTarefaCategori = EntityModel.of(entity,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TarefaCategoriaResource.class).findById(entity.getId())).withSelfRel(),
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TarefaCategoriaResource.class).findAll()).withRel("Todas Categorias")
				);
		

		
		return emTarefaCategori;
	}
	
	public CollectionModel<EntityModel<TarefaCategoria>> toModel(List<TarefaCategoria> entitys) {
		List<EntityModel<TarefaCategoria>> listEmTarefasCategorias = entitys.stream().map(e -> toModel(e)).collect(Collectors.toList());
		
		CollectionModel<EntityModel<TarefaCategoria>> cmTarefasCategoria = CollectionModel.of(listEmTarefasCategorias,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TarefaCategoriaResource.class).findAll()).withSelfRel()
				);
		return cmTarefasCategoria;
	}

}
