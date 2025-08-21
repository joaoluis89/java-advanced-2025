package com.example.java_advanced.gateways;

import com.example.java_advanced.gateways.dtos.AlunoPostRequest;
import com.example.java_advanced.services.ConcatIdToAlunoService;
import com.example.java_advanced.services.ListAlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fiap/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final ConcatIdToAlunoService concatIdToAlunoService;
    private final ListAlunosService listAlunosService;

    @GetMapping("/{id}")
    public String getAluno(@PathVariable String id) {
        return concatIdToAlunoService.execute(id);
    }

    @GetMapping()
    public ResponseEntity<?> getAlunos(
            @RequestParam(name = "sala") String classRoom,
            @RequestParam(required = false, name = "nomeBuscado") String searchedName) {
        List<String> alunos = listAlunosService.listarAlunos();

        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(alunos);
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastroAluno(@RequestBody AlunoPostRequest aluno) {

        return "Aluno cadastrado com sucesso: ".concat(aluno.getNomeCompleto());

    }
}
