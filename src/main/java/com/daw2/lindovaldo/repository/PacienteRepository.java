package com.daw2.lindovaldo.repository;

import com.daw2.lindovaldo.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long>{}
