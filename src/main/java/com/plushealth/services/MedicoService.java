package com.plushealth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Medico;
import com.plushealth.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	
}
