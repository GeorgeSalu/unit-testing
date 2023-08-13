package br.com.barriga.service;

import static br.com.barriga.domain.builders.ContaBuilder.umaConta;
import static br.com.barriga.domain.builders.TransacaoBuilder.umTransacao;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.barriga.domain.Conta;
import br.com.barriga.domain.Transacao;
import br.com.barriga.domain.builders.ContaBuilder;
import br.com.barriga.domain.exceptions.ValidationException;
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
	
	@ParameterizedTest(name = "{6}")
	@MethodSource(value = "cenariosObrigatorios")
	public void deveValidarCamposObrigatoriosAoSalvar(Long id,String descricao,Double valor,LocalDate data, 
			Conta conta, Boolean status,String mensagem) {
		String exMessage = Assertions.assertThrows(ValidationException.class, () -> {
			Transacao transacao = umTransacao().comId(id).comDescricao(descricao)
					.comValor(valor).comData(data).comStatus(status).comConta(conta).agora();
			service.salvar(transacao);
		}).getMessage();
		
		Assertions.assertEquals(mensagem, exMessage);
	}
	
	static Stream<Arguments> cenariosObrigatorios() {
		return Stream.of(
				Arguments.of(1l, null, 10D, LocalDate.now(), umaConta().agora(), true, "Descricao inexistente"),
				Arguments.of(1l, "Descricao", null, LocalDate.now(), umaConta().agora(), true, "Valor inexistente"),
				Arguments.of(1l, "Descricao", 10D, null, umaConta().agora(), true, "Data inexistente"),
				Arguments.of(1l, "Descricao", 10D, LocalDate.now(), null, true, "Conta inexistente")
				);
	}
}









