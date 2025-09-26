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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String matricula;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pessoa pessoa;
    @OneToMany(
            mappedBy = "aluno",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<AlunoMateria> alunoMaterias;
}
