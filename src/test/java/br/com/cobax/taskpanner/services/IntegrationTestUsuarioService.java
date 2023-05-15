package br.com.cobax.taskpanner.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegrationTestUsuarioService {

	@Autowired
	UsuarioService usuarioService;

	@Test
	void testFindById() {
		System.out.println(usuarioService.findById(1L));
	}
	
	@Test
	void testFindAll() {
		System.out.println(usuarioService.findAll());
	}

}
