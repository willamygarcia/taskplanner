package br.com.cobax.taskpanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cobax.taskpanner.models.TarefaCategoria;

public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Long> {

}
