package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.AtualizarProdutoRequest;
import com.xp.desafio_final.controller.dto.CadastroProdutoRequest;
import com.xp.desafio_final.core.domain.service.AbstractService;
import com.xp.desafio_final.core.exception.RegistroNaoEncontradoException;
import com.xp.desafio_final.model.domain.Produto;
import com.xp.desafio_final.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends AbstractService<Produto, Long, ProdutoRepository> implements ProdutoService {

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository repo) {
        super(repo);
    }

    public Produto buscaPorId(Long id) {
        return super.buscarPorId(id).orElseThrow(() -> new RegistroNaoEncontradoException(id, Produto.class.getSimpleName()));
    }

    @Override
    public Produto cadastrar(CadastroProdutoRequest cadastroProdutoRequest) {
        return salvar(Produto.builder()
                .nome(cadastroProdutoRequest.nome())
                .preco(cadastroProdutoRequest.preco())
                .estoque(cadastroProdutoRequest.estoque())
                .build());
    }

    @Override
    public Produto atualizar(Long id, AtualizarProdutoRequest atualizarProdutoRequest) {
        var produto = buscaPorId(id);
        produto.setNome(atualizarProdutoRequest.nome());
        produto.setPreco(atualizarProdutoRequest.preco());
        produto.setEstoque(atualizarProdutoRequest.estoque());

        return super.salvar(produto);
    }

    @Override
    public Page<Produto> buscarPorNome(String nome, Pageable pageable) {
        return repo.findByNomeContainingIgnoreCase(nome, pageable);
    }
}
