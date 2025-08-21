package com.example.java_advanced.configurations;

import com.example.java_advanced.services.ConcatIdToAlunoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfiguration {


    @Bean
    public ConcatIdToAlunoService concatIdToAlunoService() {
        return new ConcatIdToAlunoService();
    }
}
