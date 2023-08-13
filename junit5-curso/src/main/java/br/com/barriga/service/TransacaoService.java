package br.com.barriga.service;

import br.com.barriga.domain.Transacao;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.external.ClockService;
import br.com.barriga.service.repository.TransacaoDao;

public class TransacaoService {

	private TransacaoDao dao;
	private ClockService clock;
	
	public Transacao salvar(Transacao transacao) {
		if(clock.getCurrentTime().getHour() > 10) {
			throw new RuntimeException("tente novamente amanha");
		}
		if(transacao.getDescricao() == null) throw new ValidationException("Descricao inexistente");
		if(transacao.getValor() == null) throw new ValidationException("Valor inexistente");
		if(transacao.getData() == null) throw new ValidationException("Data inexistente");
		if(transacao.getConta() == null) throw new ValidationException("Conta inexistente");
		if(transacao.getStatus() == null) transacao.setStatus(false);
		
		return dao.salvar(transacao);
	}
}
