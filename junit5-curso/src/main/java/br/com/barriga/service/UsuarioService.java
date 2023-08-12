package br.com.barriga.service;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.exceptions.ValidationException;
import br.com.barriga.service.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario salvar(Usuario usuario) {
		repository.getUsarioByEmail(usuario.email()).ifPresent(user -> {
			throw new ValidationException(String.format("Usuario %s ja cadastrado!", usuario.email()));
		});;
		return repository.salvar(usuario);
	}

}
