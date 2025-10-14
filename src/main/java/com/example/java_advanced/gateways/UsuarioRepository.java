package com.example.java_advanced.gateways;

import com.example.java_advanced.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
