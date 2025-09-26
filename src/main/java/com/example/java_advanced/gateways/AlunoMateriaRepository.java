package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.AlunoMateria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoMateriaRepository extends JpaRepository<AlunoMateria, String> {
}
