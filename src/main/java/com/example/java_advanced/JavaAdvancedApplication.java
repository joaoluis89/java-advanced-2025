package com.example.java_advanced;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.domains.Materia;
import com.example.java_advanced.domains.Pessoa;
import com.example.java_advanced.gateways.AlunoRepository;
import com.example.java_advanced.gateways.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JavaAdvancedApplication {

    private final AlunoRepository alunoRepository;
    private final MateriaRepository materiaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaAdvancedApplication.class, args);
    }

    @EventListener(value = ApplicationReadyEvent.class)
    public void setupAlunos() {
        LocalDate now = LocalDate.now();
        List<Materia> materias = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Materia build = Materia.builder()
                    .nome("Materia " + i)
                    .build();
            Materia saved = materiaRepository.save(build);
            materias.add(saved);
        }
        for (int i = 0; i <= 200; i++) {
            if (i % 10 == 0) {
                now = now.plusDays(1);
            }
            Aluno alunoASerCadastrado = Aluno.builder()
                    .pessoa(Pessoa.builder()
                            .nome("Aluno ")
                            .sobrenome("" + i)
                            .idade(i)
                            .build())
                    .build();
            alunoRepository.save(alunoASerCadastrado);
        }

    }

}
