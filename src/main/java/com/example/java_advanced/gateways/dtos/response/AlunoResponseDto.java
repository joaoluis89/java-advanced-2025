package com.example.java_advanced.gateways.dtos.response;


public record AlunoResponseDto (
        String nome,
        String sobrenome,
        String matricula,
        int idade
) {

}
