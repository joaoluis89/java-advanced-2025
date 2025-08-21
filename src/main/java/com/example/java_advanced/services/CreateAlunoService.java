package com.example.java_advanced.services;

import com.example.java_advanced.domains.Aluno;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateAlunoService implements AlunoDataServiceInterface {

    public Aluno execute(Aluno aluno) {
        return aluno.
                withId(UUID.randomUUID().toString());
    }

}
