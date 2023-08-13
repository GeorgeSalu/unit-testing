package br.com.barriga.service;

import br.com.barriga.domain.Transacao;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.repository.TransacaoDao;

public class TransacaoService {

	private TransacaoDao dao;
	
	public Transacao salvar(Transacao transacao) {
		if(transacao.getDescricao() == null) throw new ValidationException("Descricao inexistente");
		if(transacao.getValor() == null) throw new ValidationException("Valor inexistente");
		if(transacao.getData() == null) throw new ValidationException("Data inexistente");
		if(transacao.getConta() == null) throw new ValidationException("Conta inexistente");
		if(transacao.getStatus() == null) transacao.setStatus(false);
		
		return dao.salvar(transacao);
	}
}
