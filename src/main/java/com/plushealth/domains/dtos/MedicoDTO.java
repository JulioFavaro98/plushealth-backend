package com.plushealth.domains.dtos;

import java.io.Serializable;

import com.plushealth.domains.Medico;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String crm;
	private String especialidade;
	private String email;
	private String telefone;
	
	public MedicoDTO() {
		super();
	}

	public MedicoDTO(Medico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.crm = obj.getCrm();
		this.especialidade = obj.getEspecialidade();
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
