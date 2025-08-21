package com.example.java_advanced.gateways.dtos;

import com.example.java_advanced.domains.Aluno;
import lombok.*;

@Data
public class AlunoDataRequest {

    private String nomeCompleto;
    private String matricula;
    private int idade;


    public Aluno toAluno() {
        String[] nomes = nomeCompleto.split(" ", 1);
        return Aluno.builder()
                .nome(nomes[0])
                .sobrenome(nomes[1])
                .matricula(matricula)
                .idade(idade)
                .build();

    }
}
