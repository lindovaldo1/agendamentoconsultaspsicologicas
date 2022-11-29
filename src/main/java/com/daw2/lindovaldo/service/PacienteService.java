package com.daw2.lindovaldo.service;

import com.daw2.lindovaldo.model.PacienteModel;
import com.daw2.lindovaldo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

}
