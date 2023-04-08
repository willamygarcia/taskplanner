package br.com.cobax.taskpanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cobax.taskpanner.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
