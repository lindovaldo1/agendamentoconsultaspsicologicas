package com.daw2.lindovaldo.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@DynamicUpdate
public class ConsultaModel {

    @Id
    @SequenceGenerator(name = "generator3", sequenceName = "consulta_code_seq", allocationSize = 1)
    @GeneratedValue(generator = "generator3", strategy = GenerationType.SEQUENCE)
    private Long code;

    @ManyToOne
    @JoinColumn(name="codigo")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name="codigo")
    private PsicologoModel psicologo;

    private LocalDateTime consultedTime;

    @Enumerated(EnumType.STRING)
    private SituationModel situation = SituationModel.NONE;
}
