package com.sualivraria.livraria.repository;

import com.sualivraria.livraria.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    // Pode adicionar métodos específicos de consulta, se necessário
}
