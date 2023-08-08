package br.com.barriga.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.barriga.domain.exceptions.ValidationException;

@DisplayName("Dominio: Usuario")
public class UsuarioTest {

	@Test
	void deveCriarUsuarioValido() {
		
		Usuario usuario = new Usuario(1l, "usuario valido", "user@gmail.com", "1234");
		
		Assertions.assertAll("Usuario", 
				() -> assertEquals(1l, usuario.id()),				
				() -> assertEquals("usuario valido", usuario.nome()),
				() -> assertEquals("user@gmail.com", usuario.email()),
				() -> assertEquals("1234", usuario.senha())
		);
	}

	@Test
	public void deveRejeitarUsaurioSemNome() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {			
			new Usuario(1l, null, "usuario@gmail.com", "1234");
		});
		
		assertEquals("Nome é obrigatorio", ex.getMessage());
	}
	
}
