package br.com.barriga.service;

import static br.com.barriga.domain.builders.ContaBuilder.umaConta;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.barriga.domain.Conta;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.external.ContaEvent;
import br.com.barriga.service.external.ContaEvent.EventType;
import br.com.barriga.service.repository.ContaRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ContaServiceTest {

	@InjectMocks
	private ContaService service;
	
	@Mock
	private ContaRepository repository;
	
	@Mock
	private ContaEvent event;
	
	@Test
	public void deveSalvarPrimeiraContaComSucesso() {
		Conta contaToSave = umaConta().comId(null).agora();
		
		Mockito.when(repository.salvar(contaToSave)).thenReturn(umaConta().agora());
		Mockito.doNothing().when(event).dispatch(umaConta().agora(), EventType.CREATED);
		
		Conta savedConta = service.salvar(contaToSave);
		
		Assertions.assertNotNull(savedConta.id());
		
	}

	@Test
	public void deveSalvarSegundaContaComSucesso() {
		Conta contaToSave = umaConta().comId(null).agora();
		when(repository.obterContasPorUsuario(contaToSave.usuario().id())).thenReturn(Arrays.asList(umaConta().comNome("outr conta").agora()));
		Mockito.when(repository.salvar(contaToSave)).thenReturn(umaConta().agora());
		
		Conta savedConta = service.salvar(contaToSave);
		Assertions.assertNotNull(savedConta.id());
	}
	
	@Test
	public void deveRejeitarContaRepetida() {
		Conta contaToSave = umaConta().comId(null).agora();
		when(repository.obterContasPorUsuario(contaToSave.usuario().id())).thenReturn(Arrays.asList(umaConta().agora()));
		
		String mensagem = Assertions.assertThrows(ValidationException.class, () -> service.salvar(contaToSave)).getMessage();
		Assertions.assertEquals("usuario ja possui uma conta com este nome", mensagem);
	}
	
}








