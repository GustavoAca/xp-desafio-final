package com.xp.desafio_final.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CadastroClienteRequest(@Valid @NotNull String username,
                                     @Valid @NotNull String password,
                                     @Valid @NotNull String nome) {
}
