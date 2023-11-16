package com.plushealth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plushealth.domains.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	Optional<Paciente> findByEmail(String email);
}
