package com.example.java_advanced.domains;

import lombok.*;

@Builder
@Getter
@With
public class Aluno {

    private String id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private int idade;
}
