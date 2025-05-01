package com.sualivraria.livraria.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private String isbn;

    private Integer quantidade;

    private double preco;  // Campo adicionado para preço

    // Construtor padrão
    public Livro() {}

    // Construtor com preço
    public Livro(String titulo, String autor, String isbn, Integer quantidade, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.preco = preco;  // Inicialização do preço
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Método getPreco
    public double getPreco() {
        return preco;
    }

    // Método setPreco
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
