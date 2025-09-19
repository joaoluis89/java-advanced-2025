package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository repository;


    @Test
    void findAlunoById() {
        //AAA
        //Arrange
        Aluno esperado = Aluno.builder()
                .nome("Joao")
                .sobrenome("Pacheco")
                .build();
        //Act
        Aluno resultadoDoSave = repository.save(esperado);
        Optional<Aluno> optionalRecuperadoPorId = repository.findById(resultadoDoSave.getId());

        //Assert
        assertTrue(optionalRecuperadoPorId.isPresent());
        Aluno repureradoPorId = optionalRecuperadoPorId.get();
        assertEquals(resultadoDoSave, repureradoPorId);
    }

    @Test
    void findByIdade() {
        //AAA
        //Arrange
        int idade = 36;
        Aluno esperado = Aluno.builder()
                .nome("Joao")
                .sobrenome("Pacheco")
                .idade(idade)
                .build();

        Aluno esperado2 = Aluno.builder()
                .nome("Joao")
                .sobrenome("Pacheco")
                .idade(18)
                .build();

        repository.save(esperado);
        repository.save(esperado2);

        //Act
        List<Aluno> optionalRecuperadoPorIdade = repository.findByIdade(idade);

        //Assert
        Assertions.assertFalse(optionalRecuperadoPorIdade.isEmpty());
        Assertions.assertEquals(1, optionalRecuperadoPorIdade.size());
        Assertions.assertEquals(esperado, optionalRecuperadoPorIdade.get(0));
        Assertions.assertEquals(idade, optionalRecuperadoPorIdade.get(0).getIdade());















    }


}