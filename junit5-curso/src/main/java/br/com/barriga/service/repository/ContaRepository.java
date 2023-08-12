package br.com.barriga.service.repository;

import java.util.List;

import br.com.barriga.domain.Conta;

public interface ContaRepository {

	Conta salvar(Conta conta);
	List<Conta> obterContasPorUsuario(Long usuarioId);
}
