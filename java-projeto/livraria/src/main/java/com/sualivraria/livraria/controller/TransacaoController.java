package com.sualivraria.livraria.controller;

import com.sualivraria.livraria.model.Transacao;
import com.sualivraria.livraria.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    // Alugar os livros de um carrinho e registrar a transação
    @PostMapping("/alugar/{carrinhoId}")
    public ResponseEntity<Transacao> alugarCarrinho(@PathVariable Long carrinhoId) {
        Transacao transacao = transacaoService.alugarCarrinho(carrinhoId);
        return ResponseEntity.ok(transacao);
    }
}
