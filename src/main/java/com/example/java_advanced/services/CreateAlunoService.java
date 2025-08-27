package com.example.java_advanced.services;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.gateways.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateAlunoService implements AlunoDataServiceInterface {

    private final AlunoRepository alunoRepository;

    public Aluno execute(Aluno aluno) {

         Aluno alunoSaved = alunoRepository.save(aluno);
        List<Aluno> alunosByIdade = alunoRepository.findByIdade(36);

        return alunoSaved;
    }

}
