package com.example.java_advanced.services;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.domains.AlunoMateria;
import com.example.java_advanced.domains.Materia;
import com.example.java_advanced.domains.Pessoa;
import com.example.java_advanced.gateways.AlunoMateriaRepository;
import com.example.java_advanced.gateways.AlunoRepository;
import com.example.java_advanced.gateways.MateriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateAlunoService implements AlunoDataServiceInterface {

    private final AlunoRepository alunoRepository;
    private final MateriaRepository materiaRepository;
    private final AlunoMateriaRepository alunoMateriaRepository;

    public Aluno execute(Aluno aluno) {

        Materia materia = Materia.builder()
                .nome("JavaAdvancedETop")
                .build();
        Materia materiaSalva = materiaRepository.save(materia);


        Aluno alunoSaved = alunoRepository.save(aluno);

        AlunoMateria alunoMateria =
                AlunoMateria.builder()
                        .aluno(alunoSaved)
                        .materia(materiaSalva)
                        .dataMatricula(LocalDate.now())
                        .build();

        alunoMateriaRepository.save(alunoMateria);
        Optional<Aluno> byId = alunoRepository.findById(alunoSaved.getId());

        return alunoSaved;
    }
}
