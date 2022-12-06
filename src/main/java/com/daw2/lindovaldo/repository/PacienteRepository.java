package com.daw2.lindovaldo.repository;

import com.daw2.lindovaldo.model.Paciente;
import com.daw2.lindovaldo.repository.helper.paciente.PacienteQueries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteQueries {
}
