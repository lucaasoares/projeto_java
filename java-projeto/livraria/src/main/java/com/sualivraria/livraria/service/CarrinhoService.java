package com.sualivraria.livraria.service;

import com.sualivraria.livraria.model.Carrinho;
import com.sualivraria.livraria.model.Livro;
import com.sualivraria.livraria.repository.CarrinhoRepository;
import com.sualivraria.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private LivroRepository livroRepository;

    // Criar ou obter o carrinho de um usuário
    public Carrinho obterCarrinho(Long usuarioId) {
        return carrinhoRepository.findById(usuarioId).orElse(new Carrinho());
    }

    // Adicionar livro ao carrinho
    public Carrinho adicionarLivro(Long carrinhoId, Long livroId) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(carrinhoId);
        Optional<Livro> livro = livroRepository.findById(livroId);

        if (carrinho.isPresent() && livro.isPresent()) {
            Carrinho c = carrinho.get();
            c.getLivros().add(livro.get());
            carrinhoRepository.save(c);
        }
        return carrinho.get();
    }

    // Remover livro do carrinho
    public Carrinho removerLivro(Long carrinhoId, Long livroId) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(carrinhoId);
        if (carrinho.isPresent()) {
            carrinho.get().getLivros().removeIf(livro -> livro.getId().equals(livroId));
            carrinhoRepository.save(carrinho.get());
        }
        return carrinho.get();
    }

    // Finalizar carrinho
    public Carrinho finalizarCarrinho(Long carrinhoId) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(carrinhoId);
        if (carrinho.isPresent()) {
            carrinho.get().setAtivo(false);
            carrinhoRepository.save(carrinho.get());
        }
        return carrinho.get();
    }

    // 🆕 Alugar livros do carrinho
    public Carrinho alugarCarrinho(Long carrinhoId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);

        if (carrinhoOpt.isEmpty()) {
            throw new RuntimeException("Carrinho não encontrado.");
        }

        Carrinho carrinho = carrinhoOpt.get();

        if (carrinho.getLivros().isEmpty()) {
            throw new RuntimeException("Carrinho vazio. Adicione livros antes de alugar.");
        }

        for (Livro livro : carrinho.getLivros()) {
            if (livro.getQuantidade() <= 0) {
                throw new RuntimeException("Livro \"" + livro.getTitulo() + "\" indisponível para aluguel.");
            }
            livro.setQuantidade(livro.getQuantidade() - 1);
            livroRepository.save(livro);
        }

        // Finaliza o carrinho
        carrinho.setAtivo(false);
        carrinhoRepository.save(carrinho);

        return carrinho;
    }
}
