package com.plushealth.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plushealth.domains.Medico;
import com.plushealth.domains.dtos.MedicoDTO;
import com.plushealth.services.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> findById(@PathVariable Integer id){
		Medico obj = medicoService.findById(id);
		return ResponseEntity.ok().body(new MedicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<MedicoDTO>> findAll(){
		List<Medico> list = medicoService.findAll();
		List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
