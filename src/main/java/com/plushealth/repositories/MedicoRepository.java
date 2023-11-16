package com.plushealth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plushealth.domains.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
	
	Optional<Medico> findByCrm(String crm);
	Optional<Medico> findByEmail(String email);
}
