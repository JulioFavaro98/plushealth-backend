package com.plushealth.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plushealth.domains.Consulta;
import com.plushealth.domains.Medico;
import com.plushealth.domains.Paciente;
import com.plushealth.domains.Usuario;
import com.plushealth.domains.enums.Role;
import com.plushealth.domains.enums.Status;
import com.plushealth.repositories.ConsultaRepository;
import com.plushealth.repositories.MedicoRepository;
import com.plushealth.repositories.PacienteRepository;
import com.plushealth.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instanciaDb() {
		
		Paciente paciente1 = new Paciente(null, "João Silva", 25, "Masculino", "joao.silva@email.com", "123456789");
        Paciente paciente2 = new Paciente(null, "Maria Oliveira", 30, "Feminino", "maria.oliveira@email.com", "987654321");
        Paciente paciente3 = new Paciente(null, "Carlos Santos", 40, "Masculino", "carlos.santos@email.com", "555123456");
        Paciente paciente4 = new Paciente(null, "Ana Pereira", 22, "Feminino", "ana.pereira@email.com", "999888777");
        Paciente paciente5 = new Paciente(null, "Pedro Souza", 35, "Masculino", "pedro.souza@email.com", "111222333");
        
        Medico medico1 = new Medico(null, "Dr. João Silva", "12345", "Cardiologia", "joao.silva@email.com", "123456789");
        Medico medico2 = new Medico(null, "Dra. Maria Oliveira", "67890", "Ortopedia", "maria.oliveira@email.com", "987654321");
        Medico medico3 = new Medico(null, "Dr. Carlos Santos", "54321", "Dermatologia", "carlos.santos@email.com", "555123456");
        Medico medico4 = new Medico(null, "Dra. Ana Pereira", "98765", "Ginecologia", "ana.pereira@email.com", "999888777");
        Medico medico5 = new Medico(null, "Dr. Pedro Souza", "11111", "Pediatria", "pedro.souza@email.com", "111222333");
        
        Consulta consulta1 = new Consulta(null, LocalDate.now(), LocalTime.of(10, 0), Status.ABERTO, medico1, paciente1);
        Consulta consulta2 = new Consulta(null, LocalDate.now().plusDays(1), LocalTime.of(14, 30), Status.ANDAMENTO, medico2, paciente2);
        Consulta consulta3 = new Consulta(null, LocalDate.now().plusDays(2), LocalTime.of(16, 0), Status.ENCERRADO, medico1, paciente1);
        Consulta consulta4 = new Consulta(null, LocalDate.now().plusDays(3), LocalTime.of(11, 30), Status.ABERTO, medico2, paciente2);
        Consulta consulta5 = new Consulta(null, LocalDate.now().plusDays(4), LocalTime.of(15, 45), Status.ANDAMENTO, medico1, paciente1);
        Consulta consulta6 = new Consulta(null, LocalDate.now().plusDays(5), LocalTime.of(9, 0), Status.ENCERRADO, medico2, paciente2);
        Consulta consulta7 = new Consulta(null, LocalDate.now().plusDays(6), LocalTime.of(13, 15), Status.ABERTO, medico1, paciente1);
        Consulta consulta8 = new Consulta(null, LocalDate.now().plusDays(7), LocalTime.of(17, 30), Status.ANDAMENTO, medico2, paciente2);
        Consulta consulta9 = new Consulta(null, LocalDate.now().plusDays(8), LocalTime.of(12, 0), Status.ENCERRADO, medico1, paciente1);
        Consulta consulta10 = new Consulta(null, LocalDate.now().plusDays(9), LocalTime.of(14, 0), Status.ABERTO, medico2, paciente2);
        

        pacienteRepository.saveAll(List.of(paciente1, paciente2, paciente3, paciente4, paciente5));
        medicoRepository.saveAll(List.of(medico1, medico2, medico3, medico4, medico5));
        consultaRepository.saveAll(List.of(consulta1, consulta2, consulta3, consulta4, consulta5, consulta6, consulta7, consulta8, consulta9, consulta10));
	}
}
