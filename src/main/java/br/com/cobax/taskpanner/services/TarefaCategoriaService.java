package br.com.cobax.taskpanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobax.taskpanner.models.TarefaCategoria;
import br.com.cobax.taskpanner.repositories.TarefaCategoriaRepository;

@Service
public class TarefaCategoriaService {

	@Autowired
	private TarefaCategoriaRepository categoriaRepository;

	public TarefaCategoria create(TarefaCategoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public TarefaCategoria update(TarefaCategoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public TarefaCategoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(new TarefaCategoria());
	}
	
	public List<TarefaCategoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
	

}
