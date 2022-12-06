package com.daw2.lindovaldo.repository;

import com.daw2.lindovaldo.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}
