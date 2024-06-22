package com.plushealth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.plushealth.domains.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	UserDetails findByLogin(String login);
	Usuario findUserByLogin(String login);
}
