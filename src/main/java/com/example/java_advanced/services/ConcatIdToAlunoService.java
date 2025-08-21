package com.example.java_advanced.services;

import org.springframework.stereotype.Service;

public class ConcatIdToAlunoService {
    public String execute(String id) {
        return "Aluno ".concat(id);
    }
}
