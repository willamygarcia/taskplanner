package br.com.cobax.taskpanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobax.taskpanner.models.Usuario;
import br.com.cobax.taskpanner.models.dtos.UsuarioDTO;
import br.com.cobax.taskpanner.repositories.UsuarioRepository;
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario); 
	}
	
	public UsuarioDTO findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(new Usuario());
		return UsuarioDTO.toUsuarioDTO(usuario);
		
	}
	
	public List<UsuarioDTO> findAll(){
		return UsuarioDTO.toUsuarioDTO(usuarioRepository.findAll());
	}

}
