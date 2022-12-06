package com.daw2.lindovaldo.model.filter;

import com.daw2.lindovaldo.model.Specialty;

public class PsicologoFilter {

	private Long codigo;
	private String nome;
	private String cpf;
	private Specialty specialty;

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

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

}
