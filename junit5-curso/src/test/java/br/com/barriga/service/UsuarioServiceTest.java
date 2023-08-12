package br.com.barriga.service;

import static br.com.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

	@InjectMocks
	private UsuarioService service;
	
	@Mock
	private UsuarioRepository repository;
	
	
	@Test
	public void deveRetornarEmptyQuandoUsuarioInexistente() {
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertTrue(user.isEmpty());
	}
	
	@Test
	public void deveRetornarUsuarioPorEmail() {
		
		when(repository.getUserByEmail("mail@mail.com"))
				.thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()), Optional.of(UsuarioBuilder.umUsuario().agora()));
		
		Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
		Assertions.assertTrue(user.isPresent());
		
		verify(repository, times(1)).getUserByEmail("mail@mail.com");
		verify(repository, never()).getUserByEmail("outro@mail.com");
	}
	
	@Test
	public void deveSalvarUsuarioComSucesso() {
		
		Usuario userToSave = umUsuario().comId(null).agora();
		
		when(repository.getUserByEmail(userToSave.email()))
			.thenReturn(Optional.empty());
		when(repository.salvar(userToSave))
			.thenReturn(umUsuario().agora());
		
		
		Usuario savedUser = service.salvar(userToSave);
		
		Assertions.assertNotNull(savedUser.id());
		
		verify(repository).getUserByEmail(userToSave.email());
		verify(repository).salvar(userToSave);
	}
	
	@Test
	public void deveRejeitarUsuarioExistente() {
		Usuario userToSave = umUsuario().comId(null).agora();
		
		when(repository.getUserByEmail(userToSave.email())).thenReturn(Optional.of(umUsuario().agora()));
		
		
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> service.salvar(userToSave));
		
		Assertions.assertTrue(ex.getMessage().endsWith("ja cadastrado!"));
		
		verify(repository, Mockito.never()).salvar(userToSave);
	}
}










