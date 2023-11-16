package com.plushealth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Medico;
import com.plushealth.domains.dtos.MedicoDTO;
import com.plushealth.repositories.MedicoRepository;
import com.plushealth.services.exceptions.DataIntegrityViolationException;
import com.plushealth.services.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! Id: " + id));
	}

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico create(MedicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCrmEEmail(objDTO);
		Medico newObj = new Medico(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCrmEEmail(MedicoDTO objDTO) {
		Optional<Medico> obj = repository.findByCrm(objDTO.getCrm());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CRM já cadastrado no sistema!");
		}
		
		obj = repository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}
	
	
}
