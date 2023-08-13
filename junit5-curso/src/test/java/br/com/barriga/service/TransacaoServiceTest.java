package br.com.barriga.service;

import static br.com.barriga.domain.builders.TransacaoBuilder.umTransacao;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.barriga.domain.Transacao;
import br.com.barriga.service.repository.TransacaoDao;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

	@InjectMocks
	private TransacaoService service;
	
	@Mock
	private TransacaoDao dao;
	
	
	@Test
	public void deveSalvarTransacaoValida() {
		Transacao transacaoParaSalvar = umTransacao().comId(null).agora();
		Mockito.when(dao.salvar(transacaoParaSalvar)).thenReturn(umTransacao().agora());
		
		Transacao transacaoSalva = service.salvar(transacaoParaSalvar);
		Assertions.assertNotNull(transacaoSalva.getId());
		Assertions.assertAll("Transacao", 
				() -> assertEquals(1l, transacaoSalva.getId()),
				() -> assertEquals("Transacao valida", transacaoSalva.getDescricao()),
				() -> {
					assertAll("Conta", 
							() -> assertEquals("Conta Valida", transacaoSalva.getConta().nome())
					);
				}
		);
	}
}
