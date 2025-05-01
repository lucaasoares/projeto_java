package com.sualivraria.livraria.repository;

import com.sualivraria.livraria.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // Pode adicionar métodos específicos de consulta, se necessário
}
