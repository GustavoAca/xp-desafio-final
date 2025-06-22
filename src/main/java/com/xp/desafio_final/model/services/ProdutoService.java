package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.AtualizarProdutoRequest;
import com.xp.desafio_final.controller.dto.CadastroProdutoRequest;
import com.xp.desafio_final.core.domain.service.BaseService;
import com.xp.desafio_final.model.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService extends BaseService<Produto, Long> {
    Produto buscaPorId(Long id);

    Produto cadastrar(CadastroProdutoRequest cadastroProdutoRequest);

    Produto atualizar(Long id, AtualizarProdutoRequest atualizarProdutoRequest);

    Page<Produto> buscarPorNome(String nome, Pageable pageable);
}
