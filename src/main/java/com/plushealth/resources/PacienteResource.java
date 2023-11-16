package com.plushealth.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.plushealth.domains.Paciente;
import com.plushealth.domains.dtos.PacienteDTO;
import com.plushealth.services.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> findById(@PathVariable Integer id){
		Paciente obj = pacienteService.findById(id);
		return ResponseEntity.ok().body(new PacienteDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll(){
		List<Paciente> list = pacienteService.findAll();
		List<PacienteDTO> listDTO = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> create(@Valid @RequestBody PacienteDTO objDTO){
		Paciente newObj = pacienteService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> update(@PathVariable Integer id, @Valid @RequestBody PacienteDTO objDTO){
		Paciente obj = pacienteService.update(id, objDTO);
		return ResponseEntity.ok().body(new PacienteDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> delete(@PathVariable Integer id){
		pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
