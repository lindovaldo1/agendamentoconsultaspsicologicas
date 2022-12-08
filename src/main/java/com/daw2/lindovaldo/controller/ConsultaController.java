package com.daw2.lindovaldo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw2.lindovaldo.model.Consulta;
import com.daw2.lindovaldo.model.Status;
import com.daw2.lindovaldo.model.filter.ConsultaFilter;
import com.daw2.lindovaldo.repository.ConsultaRepository;
import com.daw2.lindovaldo.service.ConsultaService;

import pagination.PageWrapper;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/abrirpesquisar")
    public String abrirPesquisa() {
        return "consulta/pesquisar";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(ConsultaFilter filtro, Model model,
            @PageableDefault(size = 10) @SortDefault(sort = "codigo", direction = Sort.Direction.ASC) Pageable pageable,
            HttpServletRequest request) {
        Page<Consulta> pagina = consultaRepository.pesquisar(filtro, pageable);
        PageWrapper<Consulta> paginaWrapper = new PageWrapper<>(pagina, request);
        model.addAttribute("pagina", paginaWrapper);
        return "consulta/mostrartodas";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Consulta consulta, Model model) {
        List<Consulta> consultas = consultaRepository.findByStatus(Status.ATIVO);
        model.addAttribute("consultas", consultas);
        return "paciente/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Consulta consulta) {
        consultaService.salvar(consulta);
        return "redirect:/consultas/cadastrar/sucesso";
    }

    @GetMapping("/cadastrar/sucesso")
    public String mostrarMensagemCadastroSucesso(Model model) {
        model.addAttribute("mensagem", "Cadastro da Consulta efetuado com sucesso.");
        return "mostrarmensagem";
    }

    @PostMapping("/abriralterar")
    public String abrirAlterar(Consulta consulta, Model model) {
        List<Consulta> consultas = consultaRepository.findAll();
        model.addAttribute("consultas", consultas);
        return "consulta/alterar";
    }

    @PostMapping("/alterar")
    public String alterar(Consulta consulta) {
        consultaService.alterar(consulta);
        return "redirect:/consultas/alterar/sucesso";
    }

    @GetMapping("/alterar/sucesso")
    public String mostrarMensagemAlterarSucesso(Model model) {
        model.addAttribute("mensagem", "Alteração da Consulta efetuada com sucesso.");
        return "mostrarmensagem";
    }

    @PostMapping("/abrirremover")
    public String abrirRemover(Consulta consulta) {
        return "consulta/remover";
    }

    @PostMapping("/remover")
    public String remover(Consulta consulta) {
        consulta.setStatus(Status.INATIVO);
        consultaService.alterar(consulta);
        return "redirect:/consultas/remover/sucesso";
    }

    @GetMapping("/remover/sucesso")
    public String mostrarMensagemRemoverSucesso(Model model) {
        model.addAttribute("mensagem", "Remoção (INATIVO) de Consulta efetuada com sucesso.");
        return "mostrarmensagem";
    }

}
