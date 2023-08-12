package br.com.barriga.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.service.repository.UsuarioRepository;

public class UsuarioServiceTest {

	private UsuarioService service;
	
	@Test
	public void deveRetornarEmptyQuandoUsuarioInexistente() {
		UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		Mockito.when(repository.getUsarioByEmail("mail@mail.com")).thenReturn(Optional.empty());
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test
	public void deveRetornarUsuarioPorEmail() {
		UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		Mockito.when(repository.getUsarioByEmail("mail@mail.com"))
				.thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()));
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertFalse(user.isEmpty());
	}
	
}
