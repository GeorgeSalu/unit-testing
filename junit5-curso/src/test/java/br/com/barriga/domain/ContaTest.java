package br.com.barriga.domain;

import static br.com.barriga.domain.builders.ContaBuilder.umaConta;
import static br.com.barriga.domain.builders.UsuarioBuilder.umUsuario;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.barriga.domain.exceptions.ValidationException;

public class ContaTest {

	@Test
	public void deveCriarContaValida() {
		
		Conta conta = umaConta().agora();
		
		Assertions.assertAll("Conta", 
				() -> Assertions.assertEquals(1l, conta.id()),
				() -> Assertions.assertEquals("conta valida", conta.nome()),
				() -> Assertions.assertEquals(umUsuario().agora(), conta.usuario())
		);
		
	}
	
	@ParameterizedTest(name = "[{index}] = {3}")
	@MethodSource(value = "dataProvider")
	public void deveRejeitarContaInvalida(Long id,String nome,Usuario usuario,String mensagem) {
		Assertions.assertThrows(ValidationException.class, () -> 
			umaConta().comId(id).comNome(nome).comUsuario(usuario).agora()
		);
	}
	
	private static Stream<Arguments> dataProvider() {
		return Stream.of(
			Arguments.of(1l, null, umUsuario().agora(), "Nome é obrigatorio"),
			Arguments.of(1l, "conta valida", null, "Usuario é obrigatorio")
		);
	}
	
}
