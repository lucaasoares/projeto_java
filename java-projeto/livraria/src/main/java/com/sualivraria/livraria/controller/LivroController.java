package com.sualivraria.livraria.controller;

import com.sualivraria.livraria.model.Livro;
import com.sualivraria.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // GET: /api/livros
    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    // GET: /api/livros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: /api/livros
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro salvo = livroService.salvar(livro);
        return ResponseEntity.ok(salvo);
    }

    // PUT: /api/livros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return livroService.buscarPorId(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(livroAtualizado.getTitulo());
                    livroExistente.setAutor(livroAtualizado.getAutor());
                    livroExistente.setIsbn(livroAtualizado.getIsbn());
                    livroExistente.setQuantidade(livroAtualizado.getQuantidade());
                    Livro atualizado = livroService.salvar(livroExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: /api/livros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroService.buscarPorId(id).isPresent()) {
            livroService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
