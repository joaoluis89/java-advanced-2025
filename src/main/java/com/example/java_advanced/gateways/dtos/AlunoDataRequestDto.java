package com.example.java_advanced.gateways.dtos;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.domains.Pessoa;
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
    private String documento;


    public Aluno toAluno() {
        String[] nomes = nomeCompleto.split(" ");
        return Aluno.builder()
                .pessoa(
                        Pessoa.builder()
                                .nome(nomes[0])
                                .sobrenome(nomes[1])
                                .idade(idade)
                                .documento(documento)
                                .build()
                )
                .matricula(matricula)
                .build();

    }
}
