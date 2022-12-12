package com.daw2.lindovaldo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.support.SessionStatus;

import com.daw2.lindovaldo.model.Consulta;
import com.daw2.lindovaldo.model.Psicologo;
import com.daw2.lindovaldo.model.Status;
import com.daw2.lindovaldo.model.filter.ConsultaFilter;
import com.daw2.lindovaldo.model.filter.PsicologoFilter;
import com.daw2.lindovaldo.repository.ConsultaRepository;
import com.daw2.lindovaldo.repository.PsicologoRepository;
import com.daw2.lindovaldo.service.ConsultaService;

import pagination.PageWrapper;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @GetMapping("/cadastrar")
	public String abrirCadastro(HttpSession sessao) {
		Consulta consulta = buscarConsultaNaSessao(sessao);
		sessao.setAttribute("consulta", consulta);
		return "consulta/cadastrar";
	}


    private Consulta buscarConsultaNaSessao(HttpSession sessao) {
		Consulta consulta = (Consulta) sessao.getAttribute("consulta");
		if (consulta == null) {
			consulta = new Consulta();
		}
		return consulta;
	}
	
	@GetMapping("/abrirescolherpsicologo")
	public String abrirEscolhaPsicologo() {
		return "consulta/escolherpsicologo";
	}
	
	@GetMapping("/pesquisarpsicologo")
	public String pesquisarPessoa(PsicologoFilter filtro, Model model,
			@PageableDefault(size = 10) 
    		@SortDefault(sort = "codigo", direction = Sort.Direction.ASC)
    		Pageable pageable, HttpServletRequest request) {
		
		Page<Psicologo> pagina = psicologoRepository.pesquisar(filtro, pageable);
		PageWrapper<Psicologo> paginaWrapper = new PageWrapper<>(pagina, request);
		model.addAttribute("pagina", paginaWrapper);
		
		return "consulta/mostrarpsicologo";
	}
	
	@PostMapping("/escolherpsicologo")
	public String escolherPsicologo(Psicologo psicologo, HttpSession sessao) {
		Consulta consulta = buscarConsultaNaSessao(sessao);
		consulta.setPsicologo(psicologo);
		sessao.setAttribute("consulta", consulta);
		return "consulta/cadastrar";
	}
		
	// @GetMapping("/abrirescolherlote")
	// public String abrirEscolhaLote() {
	// 	return "aplicacao/escolherlote";
	// }
	
	// @GetMapping("/pesquisarlote")
	// public String pesquisarLote(LoteFilter filtro, Model model,
	// 		@PageableDefault(size = 10) @SortDefault(sort = "codigo", direction = Sort.Direction.ASC) Pageable pageable,
	// 		HttpServletRequest request) {
	// 	Page<Lote> pagina = loteRepository.pesquisar(filtro, pageable, true);
	// 	PageWrapper<Lote> paginaWrapper = new PageWrapper<>(pagina, request);
	// 	model.addAttribute("pagina", paginaWrapper);
	// 	return "aplicacao/mostrarlotes";
	// }
	
	// @PostMapping("/escolherlote")
	// public String escolherLote(Lote lote, HttpSession sessao) {
	// 	Aplicacao aplicacao = buscarAplicacaoNaSessao(sessao);
	// 	aplicacao.setLote(lote);
	// 	sessao.setAttribute("aplicacao", aplicacao);
	// 	return "aplicacao/cadastrar";
	// }
	
	// @GetMapping("/efetuarcadastro")
	// public String cadastrar(HttpSession sessao, SessionStatus status) {
	// 	Consulta consulta = buscarConsultaNaSessao(sessao);
	// 	consulta.setData(LocalDate.now());
	// 	consultaService.salvar(consulta);
	// 	consulta.getLote().setNroDosesAtual(consulta.getLote().getNroDosesAtual() - 1);
	// 	loteService.alterar(consulta.getLote());
	// 	status.setComplete();
	// 	sessao.invalidate();
	// 	return "redirect:/consultas/cadastro/sucesso";
	// }
	
	@GetMapping("/cadastro/sucesso")
	public String mostrarMensagemCadastroSucesso(Model model) {
		model.addAttribute("mensagem", "Agendamento de Consulta efetuado com sucesso.");
		return "mostrarmensagem";
	}
	

}
