package com.xp.desafio_final.controller;

import com.xp.desafio_final.controller.dto.AtualizarProdutoRequest;
import com.xp.desafio_final.controller.dto.CadastroProdutoRequest;
import com.xp.desafio_final.model.domain.Produto;
import com.xp.desafio_final.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public Page<Produto> listar(@PageableDefault(size = 20) Pageable pageable) {
        return produtoService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscaPorId(id);
    }

    @GetMapping("/total")
    public long buscarTotalDeProdutos() {
        return produtoService.count();
    }

    @GetMapping("/por-nome")
    public Page<Produto> buscarPorNome(@RequestParam String nome,
                                       @PageableDefault(size = 20) Pageable pageable) {
        return produtoService.buscarPorNome(nome, pageable);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody CadastroProdutoRequest cadastroProdutoRequest) {
        return produtoService.cadastrar(cadastroProdutoRequest);
    }

    @PutMapping("/atualizar/{id}")
    public Produto cadastrar(@PathVariable Long id, @RequestBody AtualizarProdutoRequest atualizarProdutoRequest) {
        return produtoService.atualizar(id, atualizarProdutoRequest);
    }
}
