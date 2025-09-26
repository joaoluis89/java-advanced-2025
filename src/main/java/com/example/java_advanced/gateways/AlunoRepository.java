package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

    Page<Aluno> findByPessoaIdade(int idade, Pageable page);

    List<Aluno> findByPessoaIdadeEquals(int idade);

    @Query(value = "Select * from aluno al where al.id = ?1 and al.matricula = ?2",  nativeQuery = true)
    Optional<Aluno> getOneAlunoById(String id, String matricula);

}
