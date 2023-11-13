package com.plushealth.domains;

import java.util.ArrayList;
import java.util.List;

public class Medico {
	
	private Integer id;
	private String nome;
	private String crm;
	private String especialidade;
	private String email;
	private String telefone;
	private List<Consulta> consultas = new ArrayList<>();
	
	public Medico() {
		super();
	}

	public Medico(Integer id, String nome, String crm, String especialidade, String email, String telefone,
			List<Consulta> consultas) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
		this.email = email;
		this.telefone = telefone;
		this.consultas = consultas;
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

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
}
