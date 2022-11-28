package com.daw2.lindovaldo.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "psicologo")
@DynamicUpdate
public class PsicologoModel implements Serializable {

    @Id
    @SequenceGenerator(name = "generator2", sequenceName = "psicologo_code_seq", allocationSize = 1)
    @GeneratedValue(generator = "generator2", strategy = GenerationType.SEQUENCE)
    private Long code;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "First name is required")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private SpecialtyModel specialty = SpecialtyModel.NONE;

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

    public SpecialtyModel getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyModel specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PsicologoModel that = (PsicologoModel) o;
        return Objects.equals(code, that.code) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && specialty == that.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, firstName, lastName, specialty);
    }

}
