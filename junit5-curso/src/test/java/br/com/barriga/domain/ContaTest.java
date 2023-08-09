package br.com.barriga.domain;

import static br.com.barriga.domain.builders.ContaBuilder.umaConta;
import static br.com.barriga.domain.builders.UsuarioBuilder.umUsuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
	
}
