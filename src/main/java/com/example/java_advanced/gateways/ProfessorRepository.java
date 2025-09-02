package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

}
