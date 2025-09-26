package com.example.java_advanced.services;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.gateways.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListAlunosService {

    private final AlunoRepository alunoRepository;

    public Page<Aluno> listarAlunos(int page, int quantidadeListada, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, quantidadeListada,
                Sort.by(direction, "pessoa.idade"));
        return alunoRepository.findAll(pageable);
    }


}
