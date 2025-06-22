package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.ItemPedidoDto;
import com.xp.desafio_final.core.domain.service.BaseService;
import com.xp.desafio_final.model.domain.ItemPedido;
import com.xp.desafio_final.model.domain.Pedido;

public interface ItemPedidoService extends BaseService<ItemPedido, Long> {

    ItemPedido cadastrar(ItemPedidoDto itemPedidoDto, Pedido pedido);
}
