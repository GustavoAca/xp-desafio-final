package com.xp.desafio_final.controller.dto;

import com.xp.desafio_final.model.domain.ItemPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CadastroPedidoRequest(@Valid @NotNull Long clienteId,
                                    List<ItemPedidoDto> itensProdutos) {
}
