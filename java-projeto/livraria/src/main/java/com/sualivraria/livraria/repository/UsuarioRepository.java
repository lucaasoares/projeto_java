package com.sualivraria.livraria.repository;

import com.sualivraria.livraria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Pode adicionar métodos específicos, se necessário
}
