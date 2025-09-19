package com.example.java_advanced.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Professor {

    @Id
    private String id;
    @OneToOne
    private Pessoa pessoa;
    @ManyToOne()
    private Materia materia;
}
