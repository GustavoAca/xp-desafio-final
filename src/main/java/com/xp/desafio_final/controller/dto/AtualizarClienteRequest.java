package com.xp.desafio_final.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AtualizarClienteRequest(@Valid @NotNull Long id,
                                      @Valid @NotNull String username,
                                      @Valid @NotNull String nome) {
}
