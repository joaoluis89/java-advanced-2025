package com.example.java_advanced.services;

import com.example.java_advanced.domains.Professor;
import com.example.java_advanced.gateways.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

  private final ProfessorRepository professorRepository;

  public Professor save(Professor professor) {
    return professorRepository.save(professor);
  }

  public Professor get(String id) {
    return null;
  }

}
