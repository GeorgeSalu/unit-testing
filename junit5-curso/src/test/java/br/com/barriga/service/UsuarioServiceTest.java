package br.com.barriga.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.infra.UsuarioDummyRepository;

public class UsuarioServiceTest {

	private UsuarioService service;
	
	@Test
	public void deveSalvarUsuario() {
		service = new UsuarioService(new UsuarioDummyRepository());
		Usuario user = UsuarioBuilder.umUsuario().comId(null).comEmail("outro@email.com").agora();
		Usuario saverUser = service.salvar(user);
		Assertions.assertNotNull(saverUser.id());
	}
	
}
