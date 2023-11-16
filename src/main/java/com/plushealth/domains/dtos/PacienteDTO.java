package com.plushealth.domains.dtos;

import java.io.Serializable;

import com.plushealth.domains.Paciente;

import jakarta.validation.constraints.NotNull;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotNull(message = "O campo NOME é requerido")
	private String nome;
	@NotNull(message = "O campo IDADE é requerido")
	private Integer idade;
	@NotNull(message = "O campo SEXO é requerido")
	private String sexo;
	@NotNull(message = "O campo E-MAIL é requerido")
	private String email;
	@NotNull(message = "O campo TELEFONE é requerido")
	private String telefone;
	
	public PacienteDTO() {
		super();
	}

	public PacienteDTO(Paciente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.idade = obj.getIdade();
		this.sexo = obj.getSexo();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	

}
