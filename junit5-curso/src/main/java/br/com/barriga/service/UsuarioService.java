package br.com.barriga.service;

import br.com.barriga.domain.Usuario;
import br.com.barriga.service.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario salvar(Usuario usuario) {
		return repository.salvar(usuario);
	}

}
