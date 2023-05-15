package br.com.cobax.taskpanner.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cobax.taskpanner.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String username);

}
