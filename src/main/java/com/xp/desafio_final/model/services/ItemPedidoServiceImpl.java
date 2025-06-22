package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.ItemPedidoDto;
import com.xp.desafio_final.core.domain.service.AbstractService;
import com.xp.desafio_final.model.domain.ItemPedido;
import com.xp.desafio_final.model.domain.Pedido;
import com.xp.desafio_final.model.domain.Produto;
import com.xp.desafio_final.model.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoServiceImpl extends AbstractService<ItemPedido, Long, ItemPedidoRepository> implements ItemPedidoService {

    private final ProdutoService produtoService;

    @Autowired
    public ItemPedidoServiceImpl(ItemPedidoRepository repo, ProdutoService produtoService) {
        super(repo);
        this.produtoService = produtoService; 
    }

    @Override
    public ItemPedido cadastrar(ItemPedidoDto itemPedidoDto, Pedido pedido) {
        Produto produto = produtoService.buscaPorId(itemPedidoDto.produtoId());
        return ItemPedido.builder()
                .produto(produto)
                .pedido(pedido)
                .quantidade(itemPedidoDto.quantidade())
                .precoUnitario(produto.getPreco())
                .build();
    }
}
