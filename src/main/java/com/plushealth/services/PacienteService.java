package com.plushealth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Paciente;
import com.plushealth.domains.dtos.PacienteDTO;
import com.plushealth.repositories.PacienteRepository;
import com.plushealth.services.exceptions.DataIntegrityViolationException;
import com.plushealth.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	public Paciente findById(Integer id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! Id: " + id));
	}

	public List<Paciente> findAll() {
		return repository.findAll();
	}

	public Paciente create(PacienteDTO objDTO) {
		objDTO.setId(null);
		validaPorEmail(objDTO);
		Paciente newObj = new Paciente(objDTO);
		return repository.save(newObj);
	}
	
	public Paciente update(Integer id, @Valid PacienteDTO objDTO) {
		objDTO.setId(id);
		Paciente oldObj = findById(id);
		validaPorEmail(objDTO);
		oldObj = new Paciente(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Paciente obj = findById(id);
		if(obj.getConsultas().size() > 0) {
			throw new DataIntegrityViolationException("Paciente possui consultas e não pode ser deletado!");
		} 
		repository.deleteById(id);
	}
	
	private void validaPorEmail(PacienteDTO objDTO) {	
		Optional<Paciente> obj = repository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

	
	
}
