package com.example.meu_primeiro_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "produtos") // Especifica o nome da tabela no banco de dados
public class Produto {
    @Id // Indica que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o valor do ID será gerado automaticamente pelo
                                                        // banco de dados
    private long id;

    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
