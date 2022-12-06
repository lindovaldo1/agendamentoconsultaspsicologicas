package com.daw2.lindovaldo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw2.lindovaldo.repository.ConsultaRepository;
import com.daw2.lindovaldo.service.ConsultaService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/abrirpesquisar")
	public String abrirConsultas() {
		return "consultas";
	}
}
