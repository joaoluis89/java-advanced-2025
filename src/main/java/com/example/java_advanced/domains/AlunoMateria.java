package com.example.java_advanced.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@With
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlunoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private Materia materia;
    @ManyToOne
    private Aluno aluno;
    private Double nota;
    private LocalDate dataMatricula;
}
