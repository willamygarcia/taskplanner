package br.com.cobax.taskpanner.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cobax.taskpanner.models.Tarefa;

@SpringBootTest
public class IntegrationTestTarefaService {
	
	@Autowired
	private TarefaService tarefaService;
	
	
	@Test
	public void findAllTest() {
		List<Tarefa> tarefas = tarefaService.findAll();
		
		Assertions.assertEquals(4, tarefas.size());
		
	}

}
