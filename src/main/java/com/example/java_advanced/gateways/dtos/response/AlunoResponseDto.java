package com.example.java_advanced.gateways.dtos.response;


import com.example.java_advanced.domains.Aluno;

public record AlunoResponseDto (
        String nome,
        String sobrenome,
        String matricula,
        int idade
) {

    public static AlunoResponseDto fromAluno(Aluno aluno) {
        return new AlunoResponseDto(
                aluno.getNome(),
                aluno.getSobrenome(),
                aluno.getMatricula(),
                aluno.getIdade()
        );
    }
}
