package com.plushealth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Consulta;
import com.plushealth.repositories.ConsultaRepository;
import com.plushealth.services.exceptions.ObjectNotFoundException;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository repository;
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}
	

}
