package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Professor;
import com.example.java_advanced.gateways.dtos.ProfessorDto;
import com.example.java_advanced.gateways.dtos.ProfessorDtoImpl;
import com.example.java_advanced.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fiap/professor")
public class ProfessorController implements ProfessorControllerInterface {

  private final ProfessorService professorService;

  @PostMapping
  public ResponseEntity<?> postProfessor(ProfessorDtoImpl professorDto) {
    Professor professor = professorService.save(
            //TODO add info for teacher
        Professor.builder().build()
    );
    return ResponseEntity.status(201).body(professor); //DTO de response, não é boa prática devolver o domínio direto
  };

  @GetMapping("/{professorId}")
  public ResponseEntity<?> getProfessor(@PathVariable String professorId) {
    return ResponseEntity.ok("professor");
  };




}
