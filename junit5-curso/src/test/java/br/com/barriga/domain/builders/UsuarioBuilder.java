package br.com.barriga.domain.builders;

import br.com.barriga.domain.Usuario;

public class UsuarioBuilder {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		inicializarDadosPadroes(builder);
		return builder;
	}
	
	private static void inicializarDadosPadroes(UsuarioBuilder builder) {
		builder.id = 1l;
		builder.nome = "usuario valido";
		builder.email = "user@gmail.com";
		builder.senha = "1234";
	}
	
	public UsuarioBuilder comId(Long param) {
		id = param;
		return this;
	}
	
	public UsuarioBuilder comNome(String param) {
		nome = param;
		return this;
	}
	
	public UsuarioBuilder comEmail(String param) {
		email = param;
		return this;
	}
	
	public UsuarioBuilder comSenha(String param) {
		senha = param;
		return this;
	}
	
	public Usuario agora() {
		return new Usuario(id, nome, email, senha);
	}
	
}
