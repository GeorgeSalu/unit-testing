package br.com.barriga.service.repository;

import java.util.Optional;

import br.com.barriga.domain.Usuario;

public interface UsuarioRepository {

	Usuario salvar(Usuario usuario);
	Optional<Usuario> getUsarioByEmail(String email);
	
}
