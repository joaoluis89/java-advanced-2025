package com.example.java_advanced.domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@With
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany(
            mappedBy = "materia",
            fetch = FetchType.LAZY
    )
    private List<Professor> professores;
    @OneToMany(
            mappedBy = "materia",
            fetch = FetchType.LAZY
    )
    private List<AlunoMateria>  alunoMaterias;
}
