package com.daw2.lindovaldo.model.filter;

public class PacienteFilter {

	private Long codigo;
	private String nome;
	private String cpf;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long code) {
		this.codigo = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
