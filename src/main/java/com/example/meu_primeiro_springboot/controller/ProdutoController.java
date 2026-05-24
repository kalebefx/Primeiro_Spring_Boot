package com.example.meu_primeiro_springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/produtos") // Define a rota base para os endpoints deste controlador
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping // Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}") // Buscar um produto por ID
    public ResponseEntity<Produto> BuscarProduto(@PathVariable long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Criar um novo produto
    public String criarProduto(@RequestBody Produto produto) {
        return "Produto criado com sucesso: " + produtoService.salvarProduto(produto).getNome();
    }

    @DeleteMapping("/{id}") // Deletar um produto por ID
    public ResponseEntity<Void> deletarProduto(@PathVariable long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
    
}
