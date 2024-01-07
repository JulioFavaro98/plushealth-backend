package com.plushealth.domains.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plushealth.domains.Usuario;

import jakarta.validation.constraints.NotNull;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O campo NOME é requerido")
	private String nome;
	@NotNull(message = "O campo ROLE é requerido")
	@JsonIgnore
	private Integer role;
	@NotNull(message = "O campo LOGIN é requerido")
	private String login;
	@NotNull(message = "O campo SENHA é requerido")
	private String password;
	
	private String nomeRole;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.role = obj.getRole().getCodigo();
		this.login = obj.getLogin();
		this.password = obj.getPassword();
		this.nomeRole = obj.getRole().getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getRole() {
		return role;
	}
	
	public void setRole(Integer role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNomeRole() {
		return nomeRole;
	}
	
	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

}
