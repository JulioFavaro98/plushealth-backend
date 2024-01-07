package com.plushealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plushealth.domains.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
