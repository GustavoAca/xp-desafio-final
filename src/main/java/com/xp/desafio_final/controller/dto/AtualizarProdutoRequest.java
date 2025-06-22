package com.xp.desafio_final.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AtualizarProdutoRequest(@Valid @NotNull Long id,
                                      @Valid @NotNull String nome,
                                      @Valid @NotNull BigDecimal preco,
                                      @Valid @NotNull Integer estoque) {
}
