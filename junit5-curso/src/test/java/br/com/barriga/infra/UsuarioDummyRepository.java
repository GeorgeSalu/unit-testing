package br.com.barriga.infra;

import java.util.Optional;

import br.com.barriga.domain.Usuario;
import br.com.barriga.domain.builders.UsuarioBuilder;
import br.com.barriga.service.repository.UsuarioRepository;

public class UsuarioDummyRepository implements UsuarioRepository {

	@Override
	public Usuario salvar(Usuario usuario) {
		return UsuarioBuilder.umUsuario().comNome(usuario.nome()).comEmail(usuario.email()).comSenha(usuario.senha()).agora();
	}

	@Override
	public Optional<Usuario> getUsarioByEmail(String email) {
		if("user@gmail.com".equalsIgnoreCase(email))
			return Optional.of(UsuarioBuilder.umUsuario().comEmail(email).agora());
		return Optional.empty();
	}

}
