package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.gateways.dtos.AlunoDataRequest;
import com.example.java_advanced.gateways.dtos.response.AlunoResponseDto;
import com.example.java_advanced.services.ConcatIdToAlunoService;
import com.example.java_advanced.services.CreateAlunoService;
import com.example.java_advanced.services.ListAlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiap/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final ConcatIdToAlunoService concatIdToAlunoService;
    private final ListAlunosService listAlunosService;
    private final CreateAlunoService criaAlunoService;

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
    public AlunoResponseDto cadastroAluno(@RequestBody AlunoDataRequest alunoDto) {

        Aluno alunoCriado = criaAlunoService.execute(alunoDto.toAluno());
        return new AlunoResponseDto(
                alunoCriado.getNome(),
                alunoCriado.getSobrenome(),
                alunoCriado.getMatricula(),
                alunoCriado.getIdade()
        );

    }

    @PutMapping
    public String atualiuzarAluno(@RequestBody AlunoDataRequest aluno) {
        return "Aluno atualizado com sucesso".concat(aluno.getNomeCompleto());
    }
}
