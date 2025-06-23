package com.xp.desafio_final.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AtualizarPedidoRequest(@Valid @NotNull Long clienteId,
                                     @Valid @NotEmpty List<ItemPedidoDto> itensProdutos) {
}
