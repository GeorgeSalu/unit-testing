package br.com.barriga.domain;

import static br.com.barriga.domain.builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import br.com.barriga.domain.exceptions.ValidationException;

@DisplayName("Dominio: Usuario")
public class UsuarioTest {

	@Test
	void deveCriarUsuarioValido() {
		
		Usuario usuario = umUsuario().agora();
		
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
			umUsuario().comNome(null).agora();
		});
		
		assertEquals("Nome é obrigatorio", ex.getMessage());
	}
	
	@Test
	public void deveRejeitarUsaurioSemEmail() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {			
			umUsuario().comEmail(null).agora();
		});
		
		assertEquals("Email é obrigatorio", ex.getMessage());
	}
	
	@Test
	public void deveRejeitarUsaurioSemSenhal() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {			
			umUsuario().comSenha(null).agora();
		});
		
		assertEquals("Senha é obrigatorio", ex.getMessage());
	}
	
	@ParameterizedTest(name = "[{index}] - {4}")
	@CsvFileSource(files = "src/test/resources/camposObrigatoriosUsario.csv", nullValues = "NULL", numLinesToSkip = 1)
	public void deveValidarCamposObrigatorios(Long id,String nome,String email,String senha,String mensagem) {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {			
			umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora();
		});
		
		assertEquals(mensagem, ex.getMessage());
	}
	
}
