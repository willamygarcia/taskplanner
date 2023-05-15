package br.com.cobax.taskpanner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.cobax.taskpanner.models.Usuario;
import br.com.cobax.taskpanner.repositories.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

		return UserDetailsImpl.build(usuario);
	}

}
