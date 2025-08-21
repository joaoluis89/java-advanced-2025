package com.example.java_advanced.services;

import com.example.java_advanced.domains.Aluno;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateAlunoService implements AlunoDataServiceInterface{

    public Aluno execute(Aluno aluno) {
        //Chama um Repository para salvar o aluno Atualizado
        return aluno;
    }

}
