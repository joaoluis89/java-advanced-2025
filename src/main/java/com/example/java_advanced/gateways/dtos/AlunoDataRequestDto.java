package com.example.java_advanced.gateways.dtos;

import com.example.java_advanced.domains.Aluno;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class AlunoDataRequestDto {

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String matricula;
    @Min(17)
    @Max(30)
    private int idade;


    public Aluno toAluno() {
        String[] nomes = nomeCompleto.split(" ");
        return Aluno.builder()
                .nome(nomes[0])
                .sobrenome(nomes[1])
                .matricula(matricula)
                .idade(idade)
                .build();

    }
}
