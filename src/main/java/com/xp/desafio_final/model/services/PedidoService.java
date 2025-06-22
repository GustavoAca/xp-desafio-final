package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.CadastroPedidoRequest;
import com.xp.desafio_final.core.domain.service.BaseService;
import com.xp.desafio_final.model.domain.Pedido;

public interface PedidoService extends BaseService<Pedido, Long> {

    Pedido buscaPorId(Long id);

    Pedido cadastrar(CadastroPedidoRequest cadastroPedidoRequest);
}
