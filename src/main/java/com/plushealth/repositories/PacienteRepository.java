package com.plushealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plushealth.domains.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
