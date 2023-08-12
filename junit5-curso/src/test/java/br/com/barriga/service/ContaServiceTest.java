package br.com.barriga.service;

import static br.com.barriga.domain.builders.ContaBuilder.umaConta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.barriga.domain.Conta;
import br.com.barriga.service.repository.ContaRepository;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

	@InjectMocks
	private ContaService service;
	
	@Mock
	private ContaRepository repository;
	
	@Test
	public void deveSalvarComSucesso() {
		Conta contaToSave = umaConta().comId(null).agora();
		
		Mockito.when(repository.salvar(contaToSave)).thenReturn(umaConta().agora());
		
		Conta savedConta = service.salvar(contaToSave);
		
		Assertions.assertNotNull(savedConta.id());
		
	}
	
}
