package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import com.example.java_advanced.gateways.dtos.AlunoDataRequestDto;
import com.example.java_advanced.gateways.dtos.response.AlunoResponseDto;
import com.example.java_advanced.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiap/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final ConcatIdToAlunoService concatIdToAlunoService;
    private final ListAlunosService listAlunosService;
    private final AlunoDataServiceInterface createAlunoService;
    private final AlunoDataServiceInterface updateAlunoService;

    @GetMapping("/{id}")
    @Operation(
            description = "returns the aluno concatenated with its id"

    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200"
                    ),

                    @ApiResponse(
                            responseCode = "400"
                    ),

                    @ApiResponse(
                            responseCode = "422"
                    )
            }
    )
        public String getAluno(Authentication authentication, @PathVariable String id) {
            String execute = concatIdToAlunoService.execute(id);
        return execute.concat("1");
    }

    @GetMapping()
    public ResponseEntity<?> getAlunos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam Sort.Direction direction,
            @RequestParam(defaultValue = "10") int quantidadeListada,
            Authentication authentication
    ) {
       Page<Aluno> alunos = listAlunosService.listarAlunos(page, quantidadeListada, direction);

        Page<AlunoResponseDto> list = alunos.map(AlunoResponseDto::fromAluno);

        if (alunos.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        } else {
            return ResponseEntity.ok(list);
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDto cadastroAluno(
            @RequestBody @Valid AlunoDataRequestDto alunoDto) {

        Aluno alunoCriado = createAlunoService.execute(alunoDto.toAluno());
        return AlunoResponseDto.fromAluno(alunoCriado);

    }

    @PutMapping
    public AlunoResponseDto atualiuzarAluno(@RequestBody AlunoDataRequestDto alunoDto) {
        Aluno alunoAtualizado = updateAlunoService.execute(alunoDto.toAluno());
        return AlunoResponseDto.fromAluno(alunoAtualizado);
    }
}
