package com.plushealth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plushealth.domains.Consulta;
import com.plushealth.domains.dtos.ConsultaDTO;
import com.plushealth.services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaResource {
	
	@Autowired 
	private ConsultaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaDTO> findById(@PathVariable Integer id){
		Consulta obj = service.findById(id);
		return ResponseEntity.ok().body(new ConsultaDTO(obj));
	}

}
