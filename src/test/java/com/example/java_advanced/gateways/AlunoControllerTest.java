package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.services.AlunoDataServiceInterface;
import com.example.java_advanced.services.ConcatIdToAlunoService;
import com.example.java_advanced.services.ListAlunosService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private ConcatIdToAlunoService concatIdToAlunoService;
    @Mock
    private ListAlunosService listAlunosService;
    @Mock
    private AlunoDataServiceInterface createAlunoService;
    @Mock
    private AlunoDataServiceInterface updateAlunoService;

    @Test
    void getAlunoTest() {
        //Arrange
        String expected = "a-string";
        String parametro = "sdfghjklhgfdsgh";
        Mockito.when(concatIdToAlunoService.execute(parametro)).thenReturn(expected);
        //Act
        String actual = alunoController.getAluno(parametro);

        Aluno expectedAluno = Aluno.builder()
                .nome("Joao")
                .build();
        Aluno actualAluno = Aluno.builder()
                .nome("Joao")
                .build();


        Mockito.when(listAlunosService.listarAlunos()).thenReturn(List.of());

        ResponseEntity<?> object = alunoController.getAlunos("abc", "joao");














        //Assert
        assertEquals(expected, actual);

        assertEquals(expectedAluno, actualAluno);

        Mockito.verify(concatIdToAlunoService,
                Mockito.times(1)).execute(Mockito.anyString());










    }

}