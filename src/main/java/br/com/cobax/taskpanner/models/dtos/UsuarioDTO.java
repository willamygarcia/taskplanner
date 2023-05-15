package br.com.cobax.taskpanner.models.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.cobax.taskpanner.models.Usuario;

public record UsuarioDTO(Long id, String usuario) {

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setUsuario(null);
		return usuario;
	}

	public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
		return new UsuarioDTO(usuario.getId(), usuario.getUsuario());
	}

	public static List<UsuarioDTO> toUsuarioDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> list = new ArrayList<>();
		for (Usuario user : usuarios) {
			list.add(new UsuarioDTO(user.getId(), user.getUsuario()));
		}

		return list;
	}
}