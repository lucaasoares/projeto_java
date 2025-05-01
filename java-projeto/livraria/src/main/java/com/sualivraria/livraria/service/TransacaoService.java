package com.sualivraria.livraria.service;

import com.sualivraria.livraria.model.Carrinho;
import com.sualivraria.livraria.model.Livro;
import com.sualivraria.livraria.model.Transacao;
import com.sualivraria.livraria.repository.CarrinhoRepository;
import com.sualivraria.livraria.repository.LivroRepository;
import com.sualivraria.livraria.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private LivroRepository livroRepository;

    // Método para alugar o carrinho e registrar a transação
    public Transacao alugarCarrinho(Long carrinhoId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        if (carrinho.getLivros().isEmpty()) {
            throw new RuntimeException("Carrinho vazio. Adicione livros antes de alugar.");
        }

        double valorTotal = 0.0;

        for (Livro livro : carrinho.getLivros()) {
            if (livro.getQuantidade() <= 0) {
                throw new RuntimeException("Livro \"" + livro.getTitulo() + "\" está indisponível.");
            }

            livro.setQuantidade(livro.getQuantidade() - 1);
            valorTotal += livro.getPreco();
            livroRepository.save(livro);
        }

        // Criação da transação
        Transacao transacao = new Transacao();
        transacao.setUsuario(carrinho.getUsuario());
        transacao.setLivros(carrinho.getLivros());
        transacao.setDataTransacao(LocalDateTime.now());
        transacao.setValorTotal(valorTotal);
        transacao.setStatus("concluída");

        transacaoRepository.save(transacao);

        // Finalizar o carrinho
        carrinho.setAtivo(false);
        carrinhoRepository.save(carrinho);

        return transacao;
    }
}
