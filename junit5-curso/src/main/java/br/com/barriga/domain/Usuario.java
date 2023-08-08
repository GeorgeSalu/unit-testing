package br.com.barriga.domain;

import br.com.barriga.domain.exceptions.ValidationException;

public class Usuario {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario(Long id, String nome, String email, String senha) {
		if(nome == null) throw new ValidationException("Nome é obrigatorio");
		if(email == null) throw new ValidationException("Email é obrigatorio");
		if(senha == null) throw new ValidationException("Senha é obrigatorio");
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long id() {
		return id;
	}

	public String nome() {
		return nome;
	}

	public String email() {
		return email;
	}

	public String senha() {
		return senha;
	}
	
}
