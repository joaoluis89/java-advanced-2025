package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Professor;
import com.example.java_advanced.gateways.dtos.ProfessorDto;
import com.example.java_advanced.gateways.dtos.ProfessorDtoImpl;
import com.example.java_advanced.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfessorController implements ProfessorControllerInterface {

  private final ProfessorService professorService;

  @PostMapping
  public ResponseEntity<?> postProfessor(ProfessorDtoImpl professorDto) {
    Professor professor = professorService.save(
        new Professor(null, professorDto.getName())
    );
    return ResponseEntity.status(201).body(professor); //DTO de response, não é boa prática devolver o domínio direto
  };

  @GetMapping("/{professorId}")
  public ResponseEntity<?> getProfessor(@PathVariable String professorId) {
    return null;
  };




}
