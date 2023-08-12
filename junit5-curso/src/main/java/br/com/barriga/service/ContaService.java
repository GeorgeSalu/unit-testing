package br.com.barriga.service;

import java.util.List;

import br.com.barriga.domain.Conta;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.repository.ContaRepository;

public class ContaService {

	private ContaRepository repository;

	public ContaService(ContaRepository repository) {
		this.repository = repository;
	}
	
	public Conta salvar(Conta conta) {
		List<Conta> contas = repository.obterContasPorUsuario(conta.usuario().id());
		contas.stream().forEach(contaExistente -> {
			if(conta.nome().equalsIgnoreCase(contaExistente.nome())) 
				throw new ValidationException("usuario ja possui uma conta com este nome");
				
		});
		return repository.salvar(conta);
	}
}
