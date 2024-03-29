package com.plushealth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plushealth.domains.Usuario;
import com.plushealth.domains.dtos.AutheticationDTO;
import com.plushealth.domains.dtos.LoginResponseDTO;
import com.plushealth.domains.dtos.RegistroDTO;
import com.plushealth.repositories.UsuarioRepository;
import com.plushealth.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AutheticationDTO dados) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok()
			.header("Authorization", token)
			.body(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registro")
	public ResponseEntity registro(@RequestBody @Valid RegistroDTO dados) {
		if(this.usuarioRepository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(dados.password());
		Usuario novoUsuario = new Usuario(dados.nome(), dados.login(), encryptedPassword, dados.role());
		
		this.usuarioRepository.save(novoUsuario);
		return ResponseEntity.ok().build();
	}

}
