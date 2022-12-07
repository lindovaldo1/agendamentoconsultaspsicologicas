package com.daw2.lindovaldo.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
@DynamicUpdate
public class Consulta {

    @Id
    @SequenceGenerator(name = "generator3", sequenceName = "consulta_code_seq", allocationSize = 1)
    @GeneratedValue(generator = "generator3", strategy = GenerationType.SEQUENCE)
    private Long code;

    @ManyToOne
    @JoinColumn(name = "codigo_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "codigo_psicologo")
    private Psicologo psicologo;

    private LocalDateTime consultedTime;

    @Enumerated(EnumType.STRING)
    private Status situation = Status.NONE;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public LocalDateTime getConsultedTime() {
        return consultedTime;
    }

    public void setConsultedTime(LocalDateTime consultedTime) {
        this.consultedTime = consultedTime;
    }

    public Status getSituation() {
        return situation;
    }

    public void setSituation(Status situation) {
        this.situation = situation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Consulta that = (Consulta) o;
        return Objects.equals(code, that.code) && Objects.equals(paciente, that.paciente)
                && Objects.equals(psicologo, that.psicologo) && Objects.equals(consultedTime, that.consultedTime)
                && situation == that.situation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, paciente, psicologo, consultedTime, situation);
    }
}
