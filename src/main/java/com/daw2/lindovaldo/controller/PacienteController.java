package com.daw2.lindovaldo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw2.lindovaldo.model.Paciente;
import com.daw2.lindovaldo.model.filter.PacienteFilter;
import com.daw2.lindovaldo.repository.PacienteRepository;
import com.daw2.lindovaldo.service.PacienteService;

import pagination.PageWrapper;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/abrirpesquisar")
    public String abrirPesquisa() {
        return "paciente/pesquisar";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(PacienteFilter filtro, Model model,
            @PageableDefault(size = 10) @SortDefault(sort = "codigo", direction = Sort.Direction.ASC) Pageable pageable,
            HttpServletRequest request) {
        Page<Paciente> pagina = pacienteRepository.pesquisar(filtro, pageable);
        PageWrapper<Paciente> paginaWrapper = new PageWrapper<>(pagina, request);
        model.addAttribute("pagina", paginaWrapper);
        return "paciente/mostrartodas";
    }

}
