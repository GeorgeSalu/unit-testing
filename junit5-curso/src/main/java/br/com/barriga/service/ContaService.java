package br.com.barriga.service;

import br.com.barriga.domain.Conta;
import br.com.barriga.service.repository.ContaRepository;

public class ContaService {

	private ContaRepository repository;

	public ContaService(ContaRepository repository) {
		this.repository = repository;
	}
	
	public Conta salvar(Conta conta) {
		return repository.salvar(conta);
	}
}
