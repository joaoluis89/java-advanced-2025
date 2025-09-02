package com.example.java_advanced.configurations;

import com.example.java_advanced.services.ConcatIdToAlunoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfiguration {


    @Bean
    @ConditionalOnProperty(prefix = "service.aluno", name = "concat-id-to-aluno", havingValue = "!enabled")
    public ConcatIdToAlunoService concatIdToAlunoService() {
        return new ConcatIdToAlunoService();
    }
}
