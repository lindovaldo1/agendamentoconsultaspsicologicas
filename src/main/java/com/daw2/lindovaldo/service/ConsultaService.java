package com.daw2.lindovaldo.service;

import com.daw2.lindovaldo.model.Consulta;
import com.daw2.lindovaldo.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void salvar(Consulta consulta) {
    }

    public void alterar(Consulta consulta) {
    }

}
