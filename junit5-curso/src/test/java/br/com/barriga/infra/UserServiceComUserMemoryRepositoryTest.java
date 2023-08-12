package br.com.barriga.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.UsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {

	private static UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());
	
	@Test
	@Order(1)
	public void deveSalvarUsuarioValido() {
		Usuario user = service.salvar(UsuarioBuilder.umUsuario().comId(null).agora());
		Assertions.assertNotNull(user.id());
	}
	
	@Test
	@Order(2)
	public void deveRejeitarUsuarioExistiente() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
			service.salvar(UsuarioBuilder.umUsuario().comId(null).agora());
		});
		
		Assertions.assertEquals("Usuario user@gmail.com ja cadastrado!", ex.getMessage());
	}
	
}
