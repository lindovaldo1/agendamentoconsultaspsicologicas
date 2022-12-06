package com.daw2.lindovaldo.model.filter;

import com.daw2.lindovaldo.model.Specialty;

public class PsicologoFilter {

    private Long codigo;
    private String name;
    private String cpf;
    private Specialty specialty;
    
    
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long code) {
		this.codigo = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String firstName) {
		this.name = firstName;
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
