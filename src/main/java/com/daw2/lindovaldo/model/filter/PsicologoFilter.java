package com.daw2.lindovaldo.model.filter;

import com.daw2.lindovaldo.model.Specialty;

public class PsicologoFilter {

    private Long code;
    private String firstName;
    private String lastName;
    private Specialty specialty;
    
    
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
    
}
