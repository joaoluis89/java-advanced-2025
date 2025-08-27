package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, String> {


    List<Aluno> findByIdade(int idade);
}
