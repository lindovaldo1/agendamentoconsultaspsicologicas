package com.daw2.lindovaldo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PacienteModel {

    @Id
    @SequenceGenerator(name = "generator1", sequenceName = "aplication_code_seq", allocationSize = 1)
    @GeneratedValue(generator = "generator1", strategy = GenerationType.SEQUENCE)
    private Long code;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "First name is required")
    private String lastName;

    @NotNull(message = "CPF is required")
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteModel that = (PacienteModel) o;
        return Objects.equals(code, that.code) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, firstName, lastName, cpf);
    }

    @Override
    public String toString() {
        return "PacienteModel{" +
                "code=" + code +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}

