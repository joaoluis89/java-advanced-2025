package com.example.java_advanced.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAlunosService {

    public List<String> listarAlunos() {
        return List.of("Aluno 1");
    }
}
