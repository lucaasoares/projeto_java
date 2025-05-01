package com.sualivraria.livraria.controller;

import com.sualivraria.livraria.model.Carrinho;
import com.sualivraria.livraria.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    // Obter carrinho de um usuário
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Carrinho> obterCarrinho(@PathVariable Long usuarioId) {
        Carrinho carrinho = carrinhoService.obterCarrinho(usuarioId);
        return ResponseEntity.ok(carrinho);
    }

    // Adicionar livro ao carrinho
    @PostMapping("/{carrinhoId}/livros/{livroId}")
    public ResponseEntity<Carrinho> adicionarLivro(@PathVariable Long carrinhoId, @PathVariable Long livroId) {
        Carrinho carrinho = carrinhoService.adicionarLivro(carrinhoId, livroId);
        return ResponseEntity.ok(carrinho);
    }

    // Remover livro do carrinho
    @DeleteMapping("/{carrinhoId}/livros/{livroId}")
    public ResponseEntity<Carrinho> removerLivro(@PathVariable Long carrinhoId, @PathVariable Long livroId) {
        Carrinho carrinho = carrinhoService.removerLivro(carrinhoId, livroId);
        return ResponseEntity.ok(carrinho);
    }

    // Finalizar carrinho
    @PostMapping("/{carrinhoId}/finalizar")
    public ResponseEntity<Carrinho> finalizarCarrinho(@PathVariable Long carrinhoId) {
        Carrinho carrinho = carrinhoService.finalizarCarrinho(carrinhoId);
        return ResponseEntity.ok(carrinho);
    }
}
