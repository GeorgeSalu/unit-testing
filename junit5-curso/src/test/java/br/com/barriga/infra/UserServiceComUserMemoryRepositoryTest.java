package br.com.barriga.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.UsuarioService;

public class UserServiceComUserMemoryRepositoryTest {

	private static UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());
	
	@Test
	public void deveSalvarUsuarioValido() {
		Usuario user = service.salvar(UsuarioBuilder.umUsuario().comId(null).agora());
		Assertions.assertNotNull(user.id());
	}
	
	@Test
	public void deveRejeitarUsuarioExistiente() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
			service.salvar(UsuarioBuilder.umUsuario().comId(null).agora());
		});
		
		
	}
	
}
