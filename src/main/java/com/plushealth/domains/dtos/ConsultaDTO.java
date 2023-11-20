package com.plushealth.domains.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.plushealth.domains.Consulta;

public class ConsultaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	private Integer statusConsulta;
	private Integer medico;
	private Integer paciente;
	private String nomeMedico;
	private String nomePaciente;
	
	public ConsultaDTO() {
		super();
	}

	public ConsultaDTO(Consulta obj) {
		this.id = obj.getId();
		this.dataConsulta = obj.getDataConsulta();
		this.horaConsulta = obj.getHoraConsulta();
		this.statusConsulta = obj.getStatusConsulta().getCodigo();
		this.medico = obj.getMedico().getId();
		this.paciente = obj.getPaciente().getId();
		this.nomeMedico = obj.getMedico().getNome();
		this.nomePaciente = obj.getPaciente().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public Integer getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(Integer statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	
	
}
