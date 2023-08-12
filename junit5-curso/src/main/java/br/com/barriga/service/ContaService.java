package br.com.barriga.service;

import java.util.List;

import br.com.barriga.domain.Conta;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.external.ContaEvent;
import br.com.barriga.service.external.ContaEvent.EventType;
import br.com.barriga.service.repository.ContaRepository;

public class ContaService {

	private ContaRepository repository;
	private ContaEvent event;

	public ContaService(ContaRepository repository,ContaEvent event) {
		this.repository = repository;
		this.event = event;
	}
	
	public Conta salvar(Conta conta) {
		List<Conta> contas = repository.obterContasPorUsuario(conta.usuario().id());
		contas.stream().forEach(contaExistente -> {
			if(conta.nome().equalsIgnoreCase(contaExistente.nome())) 
				throw new ValidationException("usuario ja possui uma conta com este nome");
				
		});
		Conta contaPersistida = repository.salvar(conta);
		event.dispatch(contaPersistida, EventType.CREATED);
		return repository.salvar(conta);
	}
}
