package com.example.java_advanced.gateways;

import com.example.java_advanced.gateways.dtos.ProfessorDto;
import com.example.java_advanced.gateways.dtos.ProfessorDtoImpl;
import org.springframework.http.ResponseEntity;

public interface ProfessorControllerInterface {


  ResponseEntity<?> postProfessor(ProfessorDtoImpl professorDto);
  ResponseEntity<?> getProfessor(String professorId);
}
