package com.plushealth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Consulta;
import com.plushealth.domains.Medico;
import com.plushealth.domains.Paciente;
import com.plushealth.domains.dtos.ConsultaDTO;
import com.plushealth.domains.enums.Status;
import com.plushealth.repositories.ConsultaRepository;
import com.plushealth.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	@Autowired
	private MedicoService medicoService;
	@Autowired 
	private PacienteService pacienteService;
	
	public Consulta findById(Integer id){
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Consulta> findAll() {
		return repository.findAll();
	}

	public Consulta create(@Valid ConsultaDTO objDTO) {
		return repository.save(newConsulta(objDTO));
	}
	
	private Consulta newConsulta(ConsultaDTO obj) {
		Medico medico = medicoService.findById(obj.getMedico());
		Paciente paciente = pacienteService.findById(obj.getPaciente());
		
		Consulta consulta = new Consulta();
		if(obj.getId() != null) {
			consulta.setId(obj.getId());
		}
		
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setDataConsulta(obj.getDataConsulta());
		consulta.setHoraConsulta(obj.getHoraConsulta());
		consulta.setStatusConsulta(Status.toEnum(obj.getStatusConsulta()));
		return consulta;
	}
}
