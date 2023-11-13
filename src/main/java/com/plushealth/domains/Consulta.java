package com.plushealth.domains;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.plushealth.domains.enums.Status;

public class Consulta {
	
	private Integer id;
	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	private Status statusConsulta;
	
	private Medico medico;
	private Paciente paciente;
	
	public Consulta() {
		super();
	}

	public Consulta(Integer id, LocalDate dataConsulta, LocalTime horaConsulta, Status statusConsulta, Medico medico,
			Paciente paciente) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.statusConsulta = statusConsulta;
		this.medico = medico;
		this.paciente = paciente;
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

	public Status getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(Status statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataConsulta, horaConsulta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(dataConsulta, other.dataConsulta) && Objects.equals(horaConsulta, other.horaConsulta);
	}
	
	
	
}
