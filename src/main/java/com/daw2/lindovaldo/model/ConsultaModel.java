package com.daw2.lindovaldo.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
@DynamicUpdate
public class ConsultaModel {

    @Id
    @SequenceGenerator(name = "generator3", sequenceName = "consulta_code_seq", allocationSize = 1)
    @GeneratedValue(generator = "generator3", strategy = GenerationType.SEQUENCE)
    private Long code;

    @ManyToOne
    @JoinColumn(name="codigo_paciente")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name="codigo_psicologo")
    private PsicologoModel psicologo;

    private LocalDateTime consultedTime;

    @Enumerated(EnumType.STRING)
    private SituationModel situation = SituationModel.NONE;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public PsicologoModel getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(PsicologoModel psicologo) {
        this.psicologo = psicologo;
    }

    public LocalDateTime getConsultedTime() {
        return consultedTime;
    }

    public void setConsultedTime(LocalDateTime consultedTime) {
        this.consultedTime = consultedTime;
    }

    public SituationModel getSituation() {
        return situation;
    }

    public void setSituation(SituationModel situation) {
        this.situation = situation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaModel that = (ConsultaModel) o;
        return Objects.equals(code, that.code) && Objects.equals(paciente, that.paciente) && Objects.equals(psicologo, that.psicologo) && Objects.equals(consultedTime, that.consultedTime) && situation == that.situation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, paciente, psicologo, consultedTime, situation);
    }
}
