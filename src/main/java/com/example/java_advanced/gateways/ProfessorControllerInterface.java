package com.example.java_advanced.gateways;

import com.example.java_advanced.gateways.dtos.ProfessorDto;
import org.springframework.http.ResponseEntity;

public interface ProfessorControllerInterface {


  ResponseEntity<?> postProfessor(ProfessorDto professorDto);
  ResponseEntity<?> getProfessor(String professorId);
}
