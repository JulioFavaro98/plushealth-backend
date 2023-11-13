package com.plushealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plushealth.domains.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
