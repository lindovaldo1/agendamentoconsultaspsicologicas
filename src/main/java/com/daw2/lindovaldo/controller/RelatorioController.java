package com.daw2.lindovaldo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw2.lindovaldo.service.RelatorioService;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

	private static final Logger logger = LoggerFactory.getLogger(RelatorioController.class);
	
	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping("/vacinas")
	public ResponseEntity<byte[]> gerarRelatorioSimples() {
		logger.trace("Entrou em gerarRelatorioSimples");
		logger.debug("Gerando relatório simples");
		
		byte[] relatorio = relatorioService.gerarRelatorioSimples();
		
		logger.debug("Relatório simples de todas as pessoas gerado");
		logger.debug("Retornando o relatório simples de todas as pessoas");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Relatorio.pdf")
				.body(relatorio);
	}
	
	
}
