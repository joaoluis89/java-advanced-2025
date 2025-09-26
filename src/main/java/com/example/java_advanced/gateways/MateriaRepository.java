package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
