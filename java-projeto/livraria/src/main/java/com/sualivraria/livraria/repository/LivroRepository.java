package com.sualivraria.livraria.repository;

import com.sualivraria.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Aqui você pode adicionar métodos customizados, como buscar por título, se quiser.
}
