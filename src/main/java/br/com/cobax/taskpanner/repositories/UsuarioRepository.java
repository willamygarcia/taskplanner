package br.com.cobax.taskpanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cobax.taskpanner.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
