package br.com.barriga.service;

import static br.com.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.service.repository.UsuarioRepository;

public class UsuarioServiceTest {

	private UsuarioService service;
	
	@Test
	public void deveRetornarEmptyQuandoUsuarioInexistente() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test
	public void deveRetornarUsuarioPorEmail() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		when(repository.getUsarioByEmail("mail@mail.com"))
				.thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()), Optional.of(UsuarioBuilder.umUsuario().agora()));
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertTrue(user.isPresent());
		
		verify(repository, times(1)).getUsarioByEmail("mail@mail.com");
		verify(repository, never()).getUsarioByEmail("outro@mail.com");
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	public void deveSalvarUsuarioComSucesso() {
		UsuarioRepository repository = mock(UsuarioRepository.class);
		service = new UsuarioService(repository);
		
		Usuario userToSave = umUsuario().comId(null).agora();
		
		when(repository.getUsarioByEmail(userToSave.email()))
			.thenReturn(Optional.empty());
		when(repository.salvar(userToSave))
			.thenReturn(umUsuario().agora());
		
		
		Usuario savedUser = service.salvar(userToSave);
		
		Assertions.assertNotNull(savedUser.id());
		
		verify(repository).getUsarioByEmail(userToSave.email());
		verify(repository).salvar(userToSave);
	}
	
}




