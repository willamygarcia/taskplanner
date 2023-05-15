package br.com.cobax.taskpanner.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.cobax.taskpanner.models.Usuario;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Long id;

	private String username;

	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		
		return new UserDetailsImpl(
				usuario.getId(),
				usuario.getUsuario(),
				usuario.getSenha(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
