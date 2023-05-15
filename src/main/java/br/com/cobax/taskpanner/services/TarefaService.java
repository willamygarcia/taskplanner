package br.com.cobax.taskpanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobax.taskpanner.exceptions.TarefaStatusException;
import br.com.cobax.taskpanner.models.Tarefa;
import br.com.cobax.taskpanner.models.enums.TarefaStatus;
import br.com.cobax.taskpanner.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Long id) {
		return tarefaRepository.findById(id).orElse(new Tarefa());
	}
	
	public Tarefa save(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public void update(Tarefa tarefa, Long id) {
		tarefa.setId(id);
		tarefaRepository.save(tarefa);
	}
	
	public void delete(Long id) {
		tarefaRepository.deleteById(id);
	}
	
	public Tarefa initTarefa(Long id) {
		Tarefa tarefa = findById(id);
		tarefa.setStatus(TarefaStatus.EM_ANDAMENTO);
		return save(tarefa);
	}
	
	public void cancelTarefa(Long id) {
		Tarefa tarefa = findById(id);
		if(!TarefaStatus.ABERTA.equals(tarefa.getStatus())) {
			
			throw new TarefaStatusException();
		}
		
	}

}
